function IMC(peso, altura) {
    return peso / (altura ** 2);
}

function factorial(num) {
    for (var i = num-1; i >= 1; i--) {
        num *= i;
    }
}

function usdToReal(usd) {
    return usd * 4.80;
}

function recamara(width, height) {
    let area = width * height;
    let perimetro = (width + height) * 2;

    alert(`El área es ${area} y el perímetro es ${perimetro}`);
}

function circulo(radio) {
    let area = Math.PI * (radio ** 2);
    let perimetro = 2* Math.PI * radio;

    alert(`El área es ${area} y el perímetro es ${perimetro}`);
}

function tabla(num) {
    for (var i = 1; i <= 10; i++) {
        console.log(`${num} x ${i} = ${num*i}`);
    }
}