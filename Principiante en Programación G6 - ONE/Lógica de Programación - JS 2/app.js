let numSecreto = 0;
let intentos = 0;
let numerosSorteados = [];

iniciarJuego();
// Funciones

function verificarIntento() {
    let numIngresado = parseInt(document.getElementById('valorUsuario').value);
    intentos++;

    // console.log(numIngresado);
    if (numIngresado === numSecreto) {
        escribir('p', `¡Ganaste! Intentos: ${intentos}`);
        document.getElementById('reiniciar').removeAttribute('disabled');
        return;
    } else if (numIngresado > numSecreto) {
        escribir('p', 'El número secreto es menor');
        
    } else {
        escribir('p', 'El número secreto es mayor');
    }
    limpiarCaja();
}

function iniciarJuego() {
    escribir('h1', 'Juego del Número Secreto');
    escribir('p', 'Indica un número del 1 al 10');
    numSecreto = generarNumeroAleatorio(1, 10);
    console.log(numSecreto);
    limpiarCaja();
    document.getElementById('reiniciar').setAttribute('disabled', true);
    intentos = 0;
}

function limpiarCaja() {
    let caja = document.querySelector('#valorUsuario');
    caja.value = '';
}

function escribir(tag, texto) {
    let elemento = document.querySelector(tag);
    elemento.innerHTML = texto;
    // Esta función es para escribir en el HTML de forma más rápida
}

function generarNumeroAleatorio(min, max) {
    let opciones = max - min + 1;
    let num = Math.floor(Math.random()*opciones)+min;
    if (numerosSorteados.includes(num)) {
        return generarNumeroAleatorio(min, max);
    } else {
        numerosSorteados.push(num);
        return num;
    }
}
