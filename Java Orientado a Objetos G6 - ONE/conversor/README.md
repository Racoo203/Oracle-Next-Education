# Practicando con Java: Challenge Conversor de Monedas

El proyecto consistió en desarrollar un Conversor de Monedas en Java que utiliza una API de tasas de cambio para realizar conversiones entre diferentes monedas. 
Se implementó la funcionalidad de hacer solicitudes HTTP para obtener datos JSON, analizar y filtrar las monedas disponibles, y luego mostrar resultados precisos de las conversiones al usuario a través de una interfaz de usuario intuitiva.
Esta experiencia práctica mejoró mis habilidades en programación Java, especialmente en el manejo de APIs y datos JSON en aplicaciones reales.

## Descripción

El proyecto se centra en la creación de un Conversor de Monedas en Java, diseñado para permitir a los usuarios realizar conversiones precisas y rápidas entre diferentes monedas internacionales. 
Utiliza una API de tasas de cambio para obtener datos actualizados, lo que asegura que las conversiones reflejen las condiciones del mercado en tiempo real. 
La finalidad principal es proporcionar a los usuarios una herramienta útil y educativa para entender y calcular el valor relativo de diferentes monedas al realizar transacciones comerciales, viajes internacionales o simplemente por curiosidad económica. 
Este proyecto no solo mejora las habilidades en programación Java, sino que también enseña conceptos fundamentales como el manejo de APIs, análisis de datos JSON y diseño de interfaces de usuario intuitivas y funcionales.

## Instalación

- IntelliJ IDEA 2024.1 Community Version
- Gson.jar 2.11.0
- Java version "21.0.3" 2024-04-16 LTS
- Java(TM) SE Runtime Environment (build 21.0.3+7-LTS-152)
- Java HotSpot(TM) 64-Bit Server VM (build 21.0.3+7-LTS-152, mixed mode, sharing)

## Usage

1. Ejemplo de Conversión de USD a ARS:
```
-----------------------------------
Conversor de Monedas
Selecciona una opcion:
-----------------------------------
(1) USD -> ARS
(2) ARS -> USD
-----------------------------------
(3) USD -> BOB
(4) BOB -> USD
-----------------------------------
(5) USD -> BRL
(6) BRL -> USD
-----------------------------------
(7) USD -> CLP
(8) CLP -> USD
-----------------------------------
(9) USD -> COP
(10) COP -> USD
-----------------------------------
(H) Historial
(*) SALIR
-----------------------------------
1
Ingresa el monto de la moneda desde la cual se quiere convertir.
100
1) USD : 100.000000 === ARS : 91175.000000
```

### Ejecución:

Ejecuta la clase Main. Esto iniciará el programa del Conversor de Monedas en la consola.
Sigue las instrucciones en pantalla para seleccionar la conversión deseada, ingresar el monto y ver los resultados.

### API Key:
Asegúrate de obtener una clave válida de la API de tasas de cambio de https://www.exchangerate-api.com/ y reemplazar "##################" en la clase CurrencyQuery con tu clave.
