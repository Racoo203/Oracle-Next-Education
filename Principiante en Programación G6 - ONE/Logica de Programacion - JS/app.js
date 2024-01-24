// Variables
let numeroSecreto = 5;
let numeroUsuario = 0;
let numeroIntentos = 0;

while (numeroSecreto != numeroUsuario) {
    numeroUsuario = prompt("Adivina el número secreto:");
    numeroIntentos += 1;
    console.log('Valor de intento:', numeroUsuario);
    /*
        Este codigo realiza la 
        comparación de dos números
    */
    console.log('Resultado de la comparación:', numeroUsuario == numeroSecreto);
    
    if (numeroSecreto == numeroUsuario) {
        // Acertamos, se cumple la condición
        alert(`Has acertado! El número secreto era ${numeroSecreto} \nNúmero de intentos: ${numeroIntentos}`);
    } else {
        // No acertamos, no se cumple la condición
    
        if (numeroUsuario > numeroSecreto) {
            alert("Lo siento, no acertaste el numero! El número secreto es menor." );
        } else if (numeroUsuario < numeroSecreto) {
            alert("Lo siento, no acertaste el numero! El número secreto es mayor." );
        }
    
        console.log('Valor del número secreto:', numeroSecreto);
    }
}
