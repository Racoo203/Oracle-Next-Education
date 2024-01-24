let porcentajeDescuento = 0;

let cantidadMillas = prompt("Ingrese la cantidad de millas");

if (cantidadMillas > 30000) {
    porcentajeDescuento = 20;	
} else if (cantidadMillas > 5000) {
    porcentajeDescuento = 10;	
} else {
    porcentajeDescuento = 0;
}

console.log(porcentajeDescuento);4000