package LampCenter;

import java.util.HashMap;

public enum LampCommand {
    GET_VOLTAGE("getVoltage"),
    SET_BRIGHTNESS("setBrightness"),
    SET_NAME("setName"),
    SET_POSITION("setPosition");

    private HashMap<String,String> stringAppends = new HashMap<>();
    private HashMap<String,Integer> intAppends = new HashMap<>();
    private HashMap<String,Double> doubleAppends = new HashMap<>();

    private String cmdType;

    private LampCommand(String cmdType) {
        this.cmdType = cmdType;
    }

    public LampCommand append(String key, String value){
        stringAppends.put(key,value);
        return this;
    }
    public LampCommand append(String key, int value){
        intAppends.put(key,value);
        return this;
    }
    public LampCommand append(String key, double value){
        doubleAppends.put(key, value);
        return this;
    }

    public String toJson(){
        StringBuilder sb = new StringBuilder()
            .append("{\"cmd\": ")
            .append("\""+cmdType+"\"")
            .append(", ");
        for(String key: stringAppends.keySet()){
            sb.append("\""+key+"\": ");
            sb.append("\""+stringAppends.get(key)+"\"")
            .append(", ");
        }
        for(String key: intAppends.keySet()){
            sb.append("\""+key+"\": ");
            sb.append(intAppends.get(key))
            .append(", ");
        }
        for(String key: doubleAppends.keySet()){
            sb.append("\""+key+"\": ");
            sb.append(doubleAppends.get(key))
                    .append(", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
}
