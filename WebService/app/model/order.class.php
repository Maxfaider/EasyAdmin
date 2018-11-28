<?php

/**
 * @author Lmarck
 */
class order {
    private $_action;
    private $_admin;
    private $_client;
    
    function __construct($action, $admin, $client) {
        $this->_action = $action;
        $this->_admin = $admin;
        $this->_client = $client;
    }
    
    function get_action() {
        return $this->_action;
    }

    function get_admin() {
        return $this->_admin;
    }

    function get_client() {
        return $this->_client;
    }

    function set_action($_action) {
        $this->_action = $_action;
    }

    function set_admin($_admin) {
        $this->_admin = $_admin;
    }

    function set_client($_client) {
        $this->_client = $_client;
    }
    
}
