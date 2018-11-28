/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener('load', init, false);

function init() {
   btncerrar = document.getElementById('btnCerrar');
   btncerrar.addEventListener('click', cerrar);
}

 function mostrar() {
    div = document.getElementById('flotante');
    div.style.display = '';
 }

function cerrar() {
    div = document.getElementById('flotante');
    div.style.display = 'none';
}

