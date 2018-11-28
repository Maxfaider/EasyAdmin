<?php

/**
 * @author Alan M.E
 * @version 1.0
 */
class admin {
    
    private $_user;
    private $_password;
    private $_infoPersonal;
    
    function __construct(string $_user, string $_password) {
        $this->_user = $_user;
        $this->_password = $_password;
    }
    
    function addInfoPersonal(infoPersonal $_infoPersonal) {
        $this->_infoPersonal = $_infoPersonal;
        return $this;
    }
    
    function get_user() {
        return $this->_user;
    }

    function get_password() {
        return $this->_password;
    }

    function get_infoPersonal(): infoPersonal {
        return $this->_infoPersonal;
    }

    function set_user($_user) {
        $this->_user = $_user;
    }

    function set_password($_password) {
        $this->_password = $_password;
    }

    function toString() {
        return '{"user":"'.$this->_user.'",'.
               '"passwrod":"'.$this->_password.'",'.
               '"info_personal":'.$this->_infoPersonal->toString().
               '}';
    }
    
}
