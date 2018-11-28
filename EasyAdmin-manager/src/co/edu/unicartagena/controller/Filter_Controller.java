
package co.edu.unicartagena.controller;

import co.com.amecodetech.infoclient.Client;
import co.edu.unicartagena.annotation.SoapServer;
import co.edu.unicartagena.model.Admin;
import co.edu.unicartagena.soapserver.Service_Impl;
import co.edu.unicartagena.useful.ConverterJson;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class Filter_Controller {
    
    private static Filter_Controller filterController;
    private Memento memento;
    private Service_Impl service;
    
    private Filter_Controller() {
        service = new Service_Impl();
    }
    
    public static Filter_Controller getInstance() {
        if(filterController == null) {
            return filterController = new Filter_Controller();
        }
        return filterController;
    }
    
    @SoapServer(nameFunction="sendClient")
    public List<Client> sendClients() {
        String json = "";
        try{
            json = service.getScramblePort().sendClient(memento.getIdAdmin());
        } catch(RemoteException ex) {
            return null;
        }
        return ConverterJson.converterJsonToModel(json);
    }
    
    @SoapServer(nameFunction="sendOrder")
    public String sendOrder(String order, String ipClient) {
        String result = "";
        try {
            result = service.getScramblePort().sendCommand(memento.getIdAdmin(), 
                    order, ipClient);
        } catch(RemoteException ex) {
            return "Unable to connect to server";
        }
        return result;
    }
    
    @SoapServer(nameFunction="loginAdmin")
    public String loginAdmin(String user, String password) {
        String id = "";
        try {
            id = this.service.getScramblePort().loginAdmin(user, password);
            Integer.parseInt(id);
            memento = new Memento(id, user);
        } catch (RemoteException ex) {
            return "Unable to connect to server";
        } catch(NumberFormatException ex) {
            return id;
        }
        return user;
    }
    
    @SoapServer(nameFunction="registerAdmin")
    public String registerAdmin(Admin admin) {
        String result = "";
        try {
            String jsonAdmin = ConverterJson.converterModelToJson(admin);
            result = service.getScramblePort().registerAdmin(jsonAdmin);
        } catch(RemoteException ex) {
            return "Unable to connect to server";
        }
        return result;
    }
    
    public String getUser() {
        return memento.getUser();
    }
    
    public String idAdmin() {
        return memento.getIdAdmin();
    }   
       
}
