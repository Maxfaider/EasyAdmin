<?php

/**
 * @author Alan M.E
 * @version 1.0
 */
class client_dao extends dao {
    
    public function __construct() {
       return $this;
    }
    
    public function register(client $client, $idAdmin) {
        $idClient = $this->find($client->get_network()->get_ip(), $idAdmin);
        if($idClient === 'not found') {
                
            $connection = $this->getConnection()->open();
            
            $sql = "INSERT INTO cliente(nombres, sistema, detalles, estado, id_administrador) ".
                   "VALUES ('".
                      $client->get_userName()."','".
                      $client->get_operativeSystem()."','".
                      $client->get_FeaturesSystem()."','".
                      "online',".
                      $idAdmin.
                   ')';
            
            if($connection->query($sql)) {
                $idClient = $connection->insert_id;
                $this->insertCpu($connection, $client->get_cpu(), $idClient);
                $this->insertRam($connection, $client->get_ram(), $idClient);
                $this->insertNetwork($connection, $client->get_network(), $idClient);
                
                $connection->close();
                return 'success';
            } else {
                return $connection->error;
            }    
        } 
        if(is_numeric($idClient)) {
            return $this->update($client, $idClient, 'change');
        }
        return 'Connection failure';
    }
    
    public function find($ip_client, $id_admin): string {
        $connection = $this->getConnection()->open();
        if($connection != null) {
            
            $sql = "SELECT cliente.id FROM red, cliente "
                    . "WHERE red.ip='".$ip_client."' and red.id_client = cliente.id "
                    . "and cliente.id_administrador = ".$id_admin;
            
            if(($result = $connection->query($sql))) {
                if($result->num_rows==1) {
                     return $result->fetch_array(MYSQLI_NUM)[0];
                } else {
                    return 'not found'; 
                }
            }
            echo $connection->error;
            $connection->close();     
        }
        return 'Connection failure';
    }
    
    public function listClient(string $idAdmin) {
        $connection = $this->getConnection()->open();
        if($connection != null) {
            
            $sql = "SELECT cliente.nombres, cliente.sistema, cliente.detalles, cliente.estado, "
                    . "red.ip, red.mascara, red.mac, red.descripcion, "
                    . "cpu.model, cpu.fabricante, cpu.velocidad, cpu.nucleos, cpu.cache, "
                    . "ram.memoriaTotal, ram.swap "
                    . "FROM cliente, cpu, ram, red "
                    . "WHERE cliente.id_administrador = ".$idAdmin." and cliente.id = red.id_client "
                    . "and cliente.id = ram.id_client and cliente.id = cpu.id_client";
            
            $clients = array();
            if(($result = $connection->query($sql))) {
                
               while(($row = $result->fetch_array(MYSQLI_ASSOC))) {
                   $client = new client($row['nombres'], $row['sistema'], $row['detalles']);
                   $client->set_state($row['estado']);
                   
                   $network = new network();
                   $network->set_ip($row['ip'])
                           ->set_mask($row['mascara'])
                           ->set_mac($row['mac'])
                           ->set_description($row['descripcion']);
                   
                   $cpu = new cpu();
                   $cpu->set_model($row['model'])
                           ->set_vendor($row['fabricante'])
                           ->set_mhz($row['velocidad'])
                           ->set_core($row['nucleos'])
                           ->set_cache($row['cache']);
                   
                   $ram = new ram();
                   $ram->set_totalMemory($row['memoriaTotal'])
                           ->set_totalSwap($row['swap']);
                   
                   $client->addCpu($cpu)
                           ->addNetwork($network)
                           ->addRam($ram);
                   $clients[] = $client;
               }   
               return $clients;
            } else {
                return 'not found';
            }
        } 
        return 'Connection failure';
    }
    
    public function update(Client $client, $idClient, $option='state') {
        $connection = $this->getConnection()->open();
        if($connection != null) {
            
            if($option === 'change') {
                $sql = "UPDATE cliente ".
                    "SET nombres='".$client->get_userName()."',".
                    "sistema='".$client->get_operativeSystem()."',".
                    "detalles='".$client->get_FeaturesSystem()."',".
                    "estado='online' ".
                    "WHERE id =".$idClient;
                
                
                if($connection->query($sql)) {
                    
                    $ram = $client->get_ram();
                    
                    $sql = "UPDATE ram"
                            ."SET memoriaTotal='".$ram->get_totalMemory()."',"
                            ."swap='".$ram->get_totalSwap()."', "
                            ."WHERE id_client=".$idClient;
                    
                    $this->excuteQuery($connection, $sql);
                    
                    $network = $client->get_network();
                    
                    $sql = "UPDATE red "
                            . "SET ip='".$network->get_ip()."',"
                            . "mascara='".$network->get_mask()."',"
                            . "mac='".$network->get_mac()."',"
                            . "descripcion='".$network->get_description()."' "
                            . "WHERE id_client=".$idClient;
                    
                    $this->excuteQuery($connection, $sql);
                    
                    $cpu = $client->get_cpu();
                    
                    $sql = "UPDATE cpu "
                            . "SET model='".$cpu->get_model()."',"
                            . "fabricante='".$cpu->get_vendor()."',"
                            . "velocidad='".$cpu->get_mhz()."',"
                            . "nucleos='".$cpu->get_core()."',"
                            . "cache='".$cpu->get_cache()."' "
                            . "WHERE id_client=".$idClient;
                    
                    return $this->excuteQuery($connection, $sql);
                }   
            }
            $sql = "UPDATE cliente ".
                    "SET estado='offline' ".
                    "WHERE id =".$idClient;
            return $this->excuteQuery($connection, $sql);         
        } 
        return 'Connection failure';
    }
    
    private function insertNetwork($connection, $network, $idClient) { 
        $sql = "INSERT INTO red(ip, mascara, mac, descripcion, id_client) ".
                "VALUES ('".
                    $network->get_ip()."','".
                    $network->get_mask()."','".
                    $network->get_mac()."','".
                    $network->get_description()."',".
                    $idClient.  
                 ")";
                
        $connection->query($sql);
    }
    
    private function insertRam($connection, $ram, $idClient) {     
        $sql = "INSERT INTO ram(memoriaTotal, swap, id_client) ".
               "VALUES ('".
                    $ram->get_totalMemory()."','".
                    $ram->get_totalSwap()."',".
                    $idClient.  
                    ")";
        
        $connection->query($sql);
    }
    
    private function insertCpu($connection, $cpu, $idClient) {
        $sql = "INSERT INTO cpu(model, fabricante, velocidad, nucleos, cache, id_client) ".
                "VALUES ('".
                    $cpu->get_model()."','".
                    $cpu->get_vendor()."','".
                    $cpu->get_mhz()."','".
                    $cpu->get_core()."','".
                    $cpu->get_cache()."',".
                    $idClient.  
                ")";
                
        $connection->query($sql);
    }
    
    private function excuteQuery($connection, $sql) {
        if($connection->query($sql)) {
            return 'success';
        } else {
            return $connection->error;
        } 
    }
    
}
