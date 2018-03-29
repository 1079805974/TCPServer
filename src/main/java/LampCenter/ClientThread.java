package LampCenter;

import Lamps.Lamp;
import Lamps.LampList;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class ClientThread extends Thread {
    private final Socket lampClient;
    private BufferedReader reader;
    private PrintWriter writer;
    private final String id;

    public ClientThread(Socket lampClient) throws IOException {
        this.lampClient = lampClient;
        reader = new BufferedReader(new InputStreamReader(lampClient.getInputStream()));
        writer = new PrintWriter(lampClient.getOutputStream());
        String initMsg = reader.readLine();
        Lamp lamp = new Gson().fromJson(initMsg, Lamp.class);
        this.id = lamp.getId();
        LampList.getInstance().put(id, lamp);
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                ClientMessage msg = ClientMessageFactory.parseMessage(line);
                msg.getResult(this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnknownTypeMsgException e) {
            e.printStackTrace();
        }
    }

    public void setBrightness(int brightness) {
        LampList.getInstance().get(id).setBrightness(brightness);
        LampCommand cmd = LampCommand.SET_BRIGHTNESS
                .append("brightness", brightness);
        this.send(cmd);
    }

    public void setLampName(String name) {
        LampList.getInstance().get(id).setName(name);
        LampCommand cmd = LampCommand.SET_NAME
                .append("name", name);
        this.send(cmd);
    }

    public void sendGetVoltageMsg(){
        LampCommand cmd = LampCommand.GET_VOLTAGE;
        this.send(cmd);
    }

    public void setPosition(String position) {
        LampList.getInstance().get(id).setPosition(position);
        LampCommand cmd = LampCommand.SET_POSITION
                .append("position", position);
        this.send(cmd);
    }

    private void send(LampCommand cmd) {
        writer.println(cmd.toJson());
    }

    public void addTo(final ConcurrentHashMap<String, Thread> concurrentHashMap) {
        concurrentHashMap.put(id, this);
    }
}
