package LampCenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class LampServer {
    private ServerSocket lampServer;
    private static ConcurrentHashMap<String,Thread> concurrentHashMap = new ConcurrentHashMap<>();

    public LampServer(){
        try {
            lampServer = new ServerSocket(18323);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public LampServer(int port){
        try {
            lampServer = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start() throws IOException {
        while (true){
            Socket lampClient = lampServer.accept();
            ClientThread clientThread = new ClientThread(lampClient);
            clientThread.addTo(concurrentHashMap);
            clientThread.start();
        }
    }
}
