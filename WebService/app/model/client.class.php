<?php

/**
 * @author Alan M.E
 * @version 1.0
 */
class client {
    private $_userName;
    private $_operativeSystem;
    private $_FeaturesSystem;
    private $_state;
    private $_network;
    private $_cpu;
    private $_ram;
    
    function __construct(string $_userName, string $_operativeSystem, string $_FeaturesSystem) {
        $this->_userName = $_userName;
        $this->_operativeSystem = $_operativeSystem;
        $this->_FeaturesSystem = $_FeaturesSystem;
    }
    
    function addNetwork(network $_network) {
        $this->_network = $_network;
        return $this;
    }

    function addCpu(cpu $_cpu) {
        $this->_cpu = $_cpu;
        return $this;
    }

    function addRam(ram $_ram) {
        $this->_ram = $_ram;
        return $this;
    }

    function get_userName() {
        return $this->_userName;
    }

    function get_operativeSystem() {
        return $this->_operativeSystem;
    }

    function get_FeaturesSystem() {
        return $this->_FeaturesSystem;
    }

    function get_network(): network {
        return $this->_network;
    }

    function get_cpu(): cpu {
        return $this->_cpu;
    }

    function get_ram(): ram {
        return $this->_ram;
    }

    function set_userName($_userName) {
        $this->_userName = $_userName;
    }
    
    function get_state() {
        return $this->_state;
    }

    function set_state($_state) {
        $this->_state = $_state;
    }
    
    function set_operativeSystem($_operativeSystem) {
        $this->_operativeSystem = $_operativeSystem;
    }

    function set_FeaturesSystem($_FeaturesSystem) {
        $this->_FeaturesSystem = $_FeaturesSystem;
    }
    
    function toString() {
        return '{"userName":"'.$this->_userName.'",'.
               '"operativeSystem":"'.$this->_operativeSystem.'",'.
               '"featuresSystem":"'.$this->_FeaturesSystem.'",'.
               '"state":"'.$this->_state.'",'.
               '"network":'.$this->_network->toString().','.
               '"cpu":'.$this->_cpu->toString().','.
               '"ram":'.$this->_ram->toString().
               '}';        
    }

}
