<?php

/**
 * @author Alan M.E
 * @version 1.0
 */
class cpu {
    private $_model;
    private $_vendor;
    private $_mhz;
    private $_core;
    private $_cache;
    
    function __construct() {
        
    }
    
    function set_model($_model) {
        $this->_model = $_model;
        return $this;
    }

    function set_vendor($_vendor) {
        $this->_vendor = $_vendor;
        return $this;
    }

    function set_mhz($_mhz) {
        $this->_mhz = $_mhz;
        return $this;
    }

    function set_core($_core) {
        $this->_core = $_core;
        return $this;
    }

    function set_cache($_cache) {
        $this->_cache = $_cache;
        return $this;
    }

    function get_model() {
        return $this->_model;
    }

    function get_vendor() {
        return $this->_vendor;
    }

    function get_mhz() {
        return $this->_mhz;
    }

    function get_core() {
        return $this->_core;
    }

    function get_cache() {
        return $this->_cache;
    }

    function toString() {
        return '{"model":"'.$this->_model.'",'.
               '"vendor":"'.$this->_vendor.'",'.
               '"mhz":"'.$this->_mhz.'",'.
               '"core":"'.$this->_core.'",'.
               '"cache":"'.$this->_cache.'"'.
               '}';
    }
    
}
