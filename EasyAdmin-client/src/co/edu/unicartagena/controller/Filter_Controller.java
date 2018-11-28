
package co.edu.unicartagena.controller;

import co.edu.unicartagena.model.useful.ConverterJson;
import co.com.amecodetech.infoclient.Client;
import co.edu.unicartagena.annotation.SoapClient;
import co.edu.unicartagena.clientsoap.Service_Impl;
import java.rmi.RemoteException;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class Filter_Controller {
    
    private static Filter_Controller filterController;
    private Service_Impl service;
    private Memento memento;
    
    private Filter_Controller() {
        this.memento = new Memento(); 
        this.service = new Service_Impl();  
    }
    
    public static Filter_Controller getInstance() {
        if(filterController == null) {
            return  filterController = new Filter_Controller();
        } 
        return filterController;
    }
    
    @SoapClient(nameFunction="findOrder")
    public String findOrder() {
        try {
            return this.service.getScramblePort().findOrder(memento.getIpClient(), memento.getIdAmin());
        } catch (RemoteException ex) {
            return "Unable to connect to server";
        }
    }
    
    @SoapClient(nameFunction="registerClient")
    public String RegisterClient(Client client) {
        String json = ConverterJson.converterModelToJson(client);
        String result = "";
        try {
            result = this.service.getScramblePort().registerClient(json, memento.getIdAmin());
            this.memento.setIpClient(client.getNetwork().getIp());
        } catch (RemoteException ex) {
            return "Unable to connect to server";
        }
        return result;
    }
    
    @SoapClient(nameFunction="loginAdmin")
    public String loginAdmin(String user, String password) {
        String id = "";
        try {
            id = this.service.getScramblePort().loginAdmin(user, password);
            Integer.parseInt(id);
        } catch (RemoteException ex) {
            return "Unable to connect to server";
        } catch(NumberFormatException ex) {
            return id;
        }
        this.memento.setIdAmin(id);
        this.memento.setUser(user);
        return user;
    }
    
    @SoapClient(nameFunction="changeSate")
    public String changeState() {
        try {
            return this.service.getScramblePort().changeState(memento.getIpClient(), memento.getIdAmin());
        } catch (RemoteException ex) {
            return "Unable to connect to server";
        }
    }

    public String getUser() {
        return memento.getUser();
    }  
    
    public boolean getLinked() {
        return memento.authorized();
    }
    
    public void setLinked() {
        memento.update();
    }
    
    public String getIp() {
        return memento.getIpClient();
    }
    
}
