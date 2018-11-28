<?php

/**
 * @author Lmarck
 * @version 1.0
 */
class infoPersonal {
    private $_name;
    private $_lastName;
    private $_email;
    private $_phone;
    
    function __construct() {
        
    }

    function get_name() {
        return $this->_name;
    }

    function get_lastName() {
        return $this->_lastName;
    }

    function get_email() {
        return $this->_email;
    }

    function get_phone() {
        return $this->_phone;
    }

    function set_name($_name) {
        $this->_name = $_name;
        return $this;
    }

    function set_lastName($_lastName) {
        $this->_lastName = $_lastName;
        return $this;
    }

    function set_email($_email) {
        $this->_email = $_email;
        return $this;
    }

    function set_phone($_phone) {
        $this->_phone = $_phone;
        return $this;
    }

    function toString() {
        return '{"names":"'.$this->_name.'",'.
               '"lastNames":"'.$this->_lastName.'",'.
               '"email":"'.$this->_email.'",'.
               '"phone":"'.$this->_phone.'"'.
               '}';            
    }
    
}
