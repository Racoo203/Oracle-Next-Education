function hello() {
    console.log("Hello World");
}

function sayHi(name) {
    console.log(`Hola, ${name}`);
}

function double(num) {
    return num*2;
}

function avg(a,b,c) {
    return (a+b+c)/3;
}

function bigger(a,b) {
    if (a > b) {
        console.log(`${a} is bigger`)
    } else if (a < b) {
        console.log(`${b} is bigger`)
    } else console.log("Theyre the same")
}

function square(num) {
    return num**2;
}