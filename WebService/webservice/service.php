<?php

include '../app/dao/connect/connection.class.php';
include '../app/dao/connect/mysqli_connect.class.php';
include '../app/dao/dao.class.php';
include '../app/dao/admin_dao.class.php';
include '../app/dao/client_dao.class.php';
include '../app/dao/order_dao.class.php';

include '../app/model/admin.class.php';
include '../app/model/infoPersonal.class.php';
include '../app/model/client.class.php';
include '../app/model/cpu.class.php';
include '../app/model/ram.class.php';
include '../app/model/network.class.php';
include '../app/model/order.class.php';

include '../app/useful/converterJson.class.php';
include '../app/useful/database.class.php';

include '../app/controller/request_controller.class.php';

$request = new request_controller();
//devuelve resultado de la inserccion administrador
function registerAdmin($json) {
    return $GLOBALS['request']->setRequest('registerAdmin', $json);
}

//devuelve id del administrador
function loginAdmin($user, $pass) {
    return $GLOBALS['request']->setRequest('loginAdmin', array($user, $pass));
}

//devuelve resultado de la inserccion cliente
function registerClient($json, $id_admin) {
    return $GLOBALS['request']->setRequest('registerClient', array($json, $id_admin));
}

//devuelve json con lista de los clientes asociados al administrador
function sendClient($id_admin) {
    return $GLOBALS['request']->setRequest('sendClient', $id_admin);
}

//string de resultado de la orden
function sendCommand($id_admin, $order, $ip_client) {
    return $GLOBALS['request']->setRequest('sendCommand', array($id_admin, $order, $ip_client));
}

//devuelve la orden almacenada por el administrador (corregir)
function findOrder($ip_client, $id_admin) {
    return $GLOBALS['request']->setRequest('findOrder', array($ip_client, $id_admin));
}

function changeState($ip_client, $id_admin) {
    return $GLOBALS['request']->setRequest('changeState', array($ip_client, $id_admin));
}

ini_set("soap.wsdl_cache_enabled", 0);

$server = new SoapServer('scramble.wsdl');

$server->addFunction('registerAdmin');
$server->addFunction('loginAdmin');
$server->addFunction('registerClient');
$server->addFunction('sendClient');
$server->addFunction('sendCommand');
$server->addFunction('findOrder');
$server->addFunction('changeState');

$server->handle();