<?php
/**
 * @author Alan M.E
 * @version 1.0
 */
class ram {
    private $_totalMemory;
    private $_totalSwap;
    
    function __construct() {
        
    }
    
    function set_totalMemory($_totalMemory) {
        $this->_totalMemory = $_totalMemory;
        return $this;
    }

    function set_totalSwap($_totalSwap) {
        $this->_totalSwap = $_totalSwap;
        return $this;
    }

    function get_totalMemory() {
        return $this->_totalMemory;
    }

    function get_totalSwap() {
        return $this->_totalSwap;
    }
    
    function toString() {
        return '{"totalMemory":"'.$this->_totalMemory.'",'.
               '"totalSwap":"'.$this->_totalSwap.'"'.
               '}';
    }
    
}
