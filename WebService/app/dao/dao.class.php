<?php

/**
 * Description of dao
 *
 * @author Alan M.E
 * @version 1.0
 */
class dao {
    
    private $_connection;
    
    public function setConnection(connection $connection) {
        $this->_connection = $connection;
    }
    
    public function getConnection(): connection {
        return $this->_connection;
    }

}
