<?php

/**
 * @author Alan M.E
 */
class network {
    private $_ip;
    private $_mask;
    private $_mac;
    private $_description;
    
    function __construct() {
        
    }
    
    function set_ip($_ip) {
        $this->_ip = $_ip;
        return $this;
    }

    function set_mask($_mask) {
        $this->_mask = $_mask;
        return $this;
    }

    function set_mac($_mac) {
        $this->_mac = $_mac;
        return $this;
    }

    function set_description($_description) {
        $this->_description = $_description;
        return $this;
    }
 
    function get_ip() {
        return $this->_ip;
    }

    function get_mask() {
        return $this->_mask;
    }

    function get_mac() {
        return $this->_mac;
    }

    function get_description() {
        return $this->_description;
    }
    
    function toString() {
        return '{"ip":"'.$this->_ip.'",'.
               '"mask":"'.$this->_mask.'",'.
               '"mac":"'.$this->_mac.'",'.
               '"description":"'.$this->_description.'"'.
               '}';
    }
    
}
