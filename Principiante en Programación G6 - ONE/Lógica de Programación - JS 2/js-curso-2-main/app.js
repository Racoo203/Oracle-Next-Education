let h1 = document.querySelector('h1')
h1.innerHTML = 'Hora del Desafío'

function clickedConsole() {
    console.log('El botón fue clickeado')
}

function clickedPrompt() {
    let ciudad = prompt('Ingrese el nombre de alguna ciudad de Brasil');
    alert(`Estuve en ${ciudad} y me acorde de tí.`);
}

function clickedAlert() {
    alert('Yo AMO JS')
}

function clickedSuma() {
    let num1 = parseInt(prompt('Ingrese un número'));
    let num2 = parseInt(prompt('Ingrese otro número'));
    alert(`La suma de los números es ${num1 + num2}`);
}
