<?php

/**
 * @author Alan M.E
 */

class database {
    private static $user = 'root';
    private static $pass = '';
    private static $nameDB = 'control';
    private static $domino = 'localhost';
    
    static function getUser() {
        return self::$user;
    }
    
    static function getPass() {
        return self::$pass;
    }
    
    static function getNameDB() {
        return self::$nameDB;
    }
    
    static function getDomino() {
        return self::$domino;
    }
    
}
