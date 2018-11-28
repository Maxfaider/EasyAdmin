<?php

/**
 * Description of view_controller
 * Controlador de vistas
 *
 * @author Alan M.E
 * @version 1.0
 */
class view_controller {
    private $_route = 'app/view/';
    private $_path;
    
    public function __construct() {
        $this->_path = [ 
           "home" => $this->_route.'index.php',
           "portafolio" => $this->_route.'portafolio.php',
           "price" => $this->_route.'price.php',  
        ];
    }
    
    public function is_exists_route(string $key): bool {
        foreach($this->_path as $index => $value) {
            if($index == $key) {
                return true;
            }
        }
        return false;
    }
    
    public function getView(string $key, $argument) {
        include $this->_path[$key];
    }
    
}
