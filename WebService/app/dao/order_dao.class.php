<?php

/**
 * @author Alan M.E
 */
class order_dao extends dao {
    
    function __construct() {
        
    }
    
    function uploadOrder(Order $order) {
        $connection = $this->getConnection()->open();
        
        if($connection != null) {
            
            $sql = "INSERT INTO ordenes(id_admin, id_client, accion)"
                    . " VALUES ("
                    . $order->get_admin().","
                    . $order->get_client().",'"
                    . $order->get_action()."'"
                    . ")";
            
            if($connection->query($sql)) {
                return 'success';
            } else {
                return 'Failed order';
            }
        }
        return 'Connection failure';
    }
    
    function getOrder($id_client) {
        
        $connection = $this->getConnection()->open();
        
        if($connection != null) {
            
            $sql = "SELECT accion "
                    . "FROM ordenes "
                    . "WHERE id_client =".$id_client;
            
            $result = $connection->query($sql);
            if($result->num_rows == 0) {
                return 'not found';
            } else {
                $this->deleteOrder($connection, $id_client);
                return $result->fetch_array()['accion']; 
            } 
        }
        return 'Connection failure';
    }
    
    private function deleteOrder($connection, $id_client) {
        $sql = "DELETE FROM ordenes "
                . "WHERE id_client=".$id_client;
        
        $connection->query($sql);
    }
    
}
