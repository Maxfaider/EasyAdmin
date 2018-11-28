<?php

/**
 * @author Alan M.E
 */
class converterJson {
    
    private function __construct() {
        
    }
    
    static function readJson($json): array {
        $array = json_decode($json, true);
        return $array;
    }
    
    static function writeJsonModel(array $array): string {
        $length = count($array);
        $json = '{ "clients": [';
        
        for ($index=0; $index<$length; $index++) {
            if(($index+1) == $length) {
                $json.=$array[$index]->toString();
                continue;
            }
            $json.=$array[$index]->toString().',';
        }
        $json.=']}';  
        return $json;
    }
}
