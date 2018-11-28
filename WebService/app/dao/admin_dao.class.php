<?php

/**
 * @author Alan M.E
 * @version 1.0
 */
class admin_dao extends dao {
    
    public function __construct() {
        
    }
    
    public function register(admin $admin): string {
        $connection = $this->getConnection()->open();
        if($connection != null) {
            
            $sql = "INSERT INTO administrador(usuario, contrasena)".
                   "VALUES ('".
                      $admin->get_user()."',".
                      "md5('".$admin->get_password()."')".
                   ")";
            
            if($connection->query($sql)) {
                
                $result = $connection->query("select id from administrador where usuario ='".$admin->get_user()."'");
                $id = $result->fetch_array(MYSQLI_NUM)[0];
                
                $infoPersonal = $admin->get_infoPersonal();
                
                $sql = "INSERT INTO info_personal(nombres, apellidos, correo, telefono, id_admin)".
                   "VALUES ('".
                      $infoPersonal->get_name()."','".
                      $infoPersonal->get_lastName()."','".
                      $infoPersonal->get_email()."','".
                      $infoPersonal->get_phone()."',".
                      $id.
                   ')';  
                
                $connection->query($sql);
                $connection->close();
                return 'success';
            } else {
                return $connection->error;
            }         
        } 
        return 'Connection failure';
    }
    
    public function setAuthentication(string $user, string $pass): string {
        $connection = $this->getConnection()->open();
        if($connection != null) {
            
            $sql = "SELECT id FROM administrador WHERE "
                    ."usuario='".$user."' and contrasena=md5('".$pass."')";
            
            if(($result = $connection->query($sql))) {
                if($result->num_rows === 1) {
                    return $result->fetch_array(MYSQLI_NUM)[0];
                } else {
                    return 'not found'; 
                }
            } 
            $connection->close();     
        } 
        return 'Connection failure';
    } 
    
}

