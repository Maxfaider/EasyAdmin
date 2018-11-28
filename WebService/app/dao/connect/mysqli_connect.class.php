<?php

/**
 * @author Alan M.E
 * @version 1.0
 */
class mysqli_connect implements connection {
    
    private $mysqli;
    
    public function close() {
        if($this->mysqli != null) {
            return $this->mysqli->close();
        }
    }

    public function open() {
        $this->mysqli = new mysqli(database::getDomino(), database::getUser(), database::getPass(), database::getNameDB());
        if(!$this->mysqli->connect_errno) {
            return $this->mysqli;
        }
        return null;
    }

}
