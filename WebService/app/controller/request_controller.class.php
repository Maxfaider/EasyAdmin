<?php
/**
 * Description of request
 *Controla las solitudes de los clientes
 * 
 * @author Alan M.E
 */
class request_controller {
    
    private $adminDao;
    private $clientDao;
    private $orderDao;
    
    function __construct() {
        $this->adminDao = new admin_dao();
        $this->adminDao->setConnection(new mysqli_connect());
        
        $this->clientDao = new client_dao();
        $this->clientDao->setConnection(new mysqli_connect());
        
        $this->orderDao = new order_dao();
        $this->orderDao->setConnection(new mysqli_connect());
    }
    
    function setRequest($action, $datos) {
        switch ($action) {
            case 'registerAdmin':
                return $this->registerAdmin($datos);
            case 'loginAdmin':
                return $this->loginAdmin($datos[0], $datos[1]);
            case 'registerClient':
                return $this->registerClient($datos[0], $datos[1]);
            case 'sendClient':
                return $this->sendClient($datos);
            case 'sendCommand':
                return $this->sendCommand($datos[0], $datos[1], $datos[2]);
            case 'findOrder':
                return $this->findOrder($datos[0], $datos[1]);
            case 'changeState':
                return $this->changeState($datos[0], $datos[1]);
        }
    }
    
    private function registerAdmin($datos) {
        $arrayModelAdmin = converterJson::readJson($datos);
        
        $infoPersonal = new infoPersonal();
        $infoPersonal->set_name($arrayModelAdmin['info_personal']['names'])
                ->set_lastName($arrayModelAdmin['info_personal']['lastNames'])
                ->set_email($arrayModelAdmin['info_personal']['email'])
                ->set_phone($arrayModelAdmin['info_personal']['phone']);
        
        $admin = new admin($arrayModelAdmin['user'], $arrayModelAdmin['password']);
        $admin->addInfoPersonal($infoPersonal);
        
        return $this->adminDao->register($admin);
    }
    
    private function loginAdmin($user, $password) {
        return $this->adminDao->setAuthentication($user, $password);
    }
    
    private function registerClient($json, $id_admin) {
        $arrayModelClient = converterJson::readJson($json);
        
        $network = new network();
        $network->set_ip($arrayModelClient['network']['ip'])
                ->set_mask($arrayModelClient['network']['mask'])
                ->set_mac($arrayModelClient['network']['mac'])
                ->set_description($arrayModelClient['network']['description']);
        
        $ram = new ram();
        $ram->set_totalMemory($arrayModelClient['ram']['totalMemory'])
                ->set_totalSwap($arrayModelClient['ram']['totalSwap']);
        
        $cpu = new cpu();
        $cpu->set_model($arrayModelClient['cpu']['model'])
                ->set_vendor($arrayModelClient['cpu']['vendor'])
                ->set_mhz($arrayModelClient['cpu']['mhz'])
                ->set_core($arrayModelClient['cpu']['core'])
                ->set_cache($arrayModelClient['cpu']['cache']);
        
        $client = new client($arrayModelClient['userName'], $arrayModelClient['operativeSystem'], $arrayModelClient['featuresSystem']);
        $client->addCpu($cpu)
               ->addNetwork($network)
               ->addRam($ram);
        
        return $this->clientDao->register($client, $id_admin);
    }
    
    private function sendClient($id_admin) {
        $arrayClients = $this->clientDao->listClient($id_admin);
        if($arrayClients === 'not found') {
            return $arrayClients;
        }
        return converterJson::writeJsonModel($arrayClients);
    }
    
    private function sendCommand($id_admin, $action, $ip_client) {
        $id_client = $this->clientDao->find($ip_client, $id_admin);
        $order = new order($action, $id_admin, $id_client);
        return $this->orderDao->uploadOrder($order);
    }
    
    private function findOrder($ip_client, $idAdmin) {
        $idClient = $this->clientDao->find($ip_client, $idAdmin);
        if($idClient != 'not found') {
           return $this->orderDao->getOrder($idClient); 
        }
        return $idClient;
    }
    
    private function changeState($ip_client, $idAdmin) {
        $idClient = $this->clientDao->find($ip_client, $idAdmin);
        if($idClient != 'not found') {
        $client = new client('','','');
        return $this->clientDao->update($client, $idClient);
        }
        return $idClient;
    }
    
}
