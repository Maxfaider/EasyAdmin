<?php
/**
 * Main
 */ 
include 'app/controller/view_controller.class.php';

$url = isset($_GET['url']) ? $_GET['url']:"home";

$arguments = explode("/", $url);

$view = new view_Controller();
if($view->is_exists_route($arguments[0])) {
    if(count($arguments)==1) {
        $arguments[1] = '';
    }
    $view->getView($arguments[0], $arguments[1]);
} else {
    $view->getView('home', '');
}
        
    