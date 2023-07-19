// Please see documentation at https://docs.microsoft.com/aspnet/core/client-side/bundling-and-minification
// for details on configuring this project to bundle and minify static web assets.

// Write your JavaScript code.
function displayRegistro() {
    document.getElementById("formRegistro").style.display = "block";
    document.getElementById("formLogin").style.display = "none";
}

function displayLogin() {
    document.getElementById("formLogin").style.display = "block";
    document.getElementById("formRegistro").style.display = "none";
}

function registrar() {

    var usuarioRegistrado = document.getElementById("usuario").value;;
    var passwordRegistrado = document.getElementById("contraseña").value;
    var mailRegistrado = document.getElementById("mail").value;

    alert("Se ha registrado correctamente");

}

function validar() {

    var usuario = document.getElementById("usuario").value;
    var contraseña = document.getElementById("contraseña").value;

    if (usuario != usuarioRegistrado) {

        alert("ERROR: el nombre de usuario no existe");

    } 
