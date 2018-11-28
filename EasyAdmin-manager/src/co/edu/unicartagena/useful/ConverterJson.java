
package co.edu.unicartagena.useful;

import co.com.amecodetech.infoclient.Client;
import co.com.amecodetech.infoclient.Cpu;
import co.com.amecodetech.infoclient.Network;
import co.com.amecodetech.infoclient.Ram;
import co.edu.unicartagena.model.Admin;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class ConverterJson {
    
    public static List<Client> converterJsonToModel(String json) {
        JSONParser jsonParser = new JSONParser();
        List<Client> clients = new ArrayList();
        
        try {
            Object obj = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            
            JSONArray msg = (JSONArray) jsonObject.get("clients");
            
            for(Object index: msg) {
                JSONObject aux = (JSONObject) index;
                
                Client client = new Client((String) aux.get("userName"),
                                (String) aux.get("operativeSystem"),
                                (String) aux.get("featuresSystem"),
                                (String) aux.get("state"));
                
                JSONObject auxCpu = (JSONObject) aux.get("cpu");
                client.setCpu(new Cpu((String) auxCpu.get("model"),
                        (String) auxCpu.get("vendor"),
                        (String) auxCpu.get("mhz"),
                        (String) auxCpu.get("core"),
                        (String) auxCpu.get("cache")));
                
                JSONObject auxNetwork = (JSONObject) aux.get("network");
                client.setNetwork(new Network((String) auxNetwork.get("ip"),
                (String) auxNetwork.get("mask"),
                (String) auxNetwork.get("mac"),
                (String) auxNetwork.get("description")));
                
                JSONObject auxRam = (JSONObject) aux.get("ram");
                client.setRam(new Ram((String) auxRam.get("totalMemory"),
                        (String) auxRam.get("totalSwap")));
                
                clients.add(client);  
            }    
        } catch (ParseException ex) {
            Logger.getLogger(ConverterJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clients;
    }
    
    public static String converterModelToJson(Admin admin) {
        
        JSONObject jsonAdmin = new JSONObject();
        jsonAdmin.put("user", admin.getUser());
        jsonAdmin.put("password", admin.getPassword());
        
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("names", admin.getInfoPersonal().getNames());
        jsonInfo.put("lastNames", admin.getInfoPersonal().getLastNames());
        jsonInfo.put("email", admin.getInfoPersonal().getEmail());
        jsonInfo.put("phone", admin.getInfoPersonal().getPhone());
        
        jsonAdmin.put("info_personal", jsonInfo);
        
        return jsonAdmin.toJSONString();
    }
    
}
