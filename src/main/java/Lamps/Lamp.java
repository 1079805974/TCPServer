package Lamps;

public class Lamp {
    //"{"id":"VSFSSAWFFASS","position":"unknown",
    // "name":"unknown","brightness":"","userLevel":2,
    // "red":255,"green":255,"blue":255,"voltage":2.353,"IP":"192.168.13.223"}"
    private int brightness;
    private String id;
    private String IP;
    private String name;
    private int userLevel;
    private String position;
    private int red,green,blue;
    private float voltage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lamp lamp = (Lamp) o;

        return id != null ? id.equals(lamp.id) : lamp.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"brightness\":")
                .append(brightness);
        sb.append(",\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"IP\":\"")
                .append(IP).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"userLevel\":")
                .append(userLevel);
        sb.append(",\"position\":\"")
                .append(position).append('\"');
        sb.append(",\"red\":")
                .append(red);
        sb.append(",\"green\":")
                .append(green);
        sb.append(",\"blue\":")
                .append(blue);
        sb.append(",\"voltage\":")
                .append(voltage);
        sb.append('}');
        return sb.toString();
    }

    public int getBrightness() {

        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public float getVoltage() {
        return voltage;
    }

    public void setVoltage(float voltage) {
        this.voltage = voltage;
    }
}
