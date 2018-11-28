
package co.edu.unicartagena.model.useful;

import co.com.amecodetech.infoclient.Client;
import org.json.simple.JSONObject;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class ConverterJson {
    
    public static String converterModelToJson(Client client) {
        
        JSONObject jsonClient = new JSONObject();
        JSONObject jsonNetwork = new JSONObject();
        JSONObject jsonCPU = new JSONObject();
        JSONObject jsonRam = new JSONObject();
       
        
        jsonNetwork.put("ip", client.getNetwork().getIp());
        jsonNetwork.put("mask", client.getNetwork().getMask());
        jsonNetwork.put("mac", client.getNetwork().getMac());
        jsonNetwork.put("description", client.getNetwork().getDescription());
        
        jsonCPU.put("model", client.getCpu().getModel());
        jsonCPU.put("vendor", client.getCpu().getVendor());
        jsonCPU.put("mhz", client.getCpu().getmHZ());
        jsonCPU.put("core", client.getCpu().getCore());
        jsonCPU.put("cache", client.getCpu().getCache());
        
        jsonRam.put("totalMemory", client.getRam().getTotalMemory());
        jsonRam.put("totalSwap", client.getRam().getSWAP());
        
        jsonClient.put("userName", client.getUserName());
        jsonClient.put("operativeSystem", client.getOperativeSystem());
        jsonClient.put("featuresSystem", client.getFeaturesSystem());
        jsonClient.put("network", jsonNetwork);
        jsonClient.put("cpu", jsonCPU);
        jsonClient.put("ram", jsonRam);
       
        return jsonClient.toJSONString();
    }
    
}
