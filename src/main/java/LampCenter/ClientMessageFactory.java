package LampCenter;

import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;


public class ClientMessageFactory {
    public static ClientMessage parseMessage(String msg) throws UnknownTypeMsgException {
        Logger logger = LoggerFactory.getLogger(ClientMessageFactory.class);
        Gson gson = new Gson();
        JSONObject jsonObject = JSONObject.fromObject(msg);
        String msgType = jsonObject.get("type").toString();
        ClientMessage cm;
        Type messageClass;
        switch (msgType){
            case "result":
                messageClass = ResultMessage.class;
                break;
            case "error":
                messageClass = ErrorMessage.class;
                break;
            case "warning":
                messageClass = WarningMessage.class;
                break;
            case "info":
                messageClass = InfoMessage.class;
                break;
            default:
                throw new UnknownTypeMsgException("unknownMessage");
        }
        cm = gson.fromJson(msg, messageClass);
        return cm;
    }
}
