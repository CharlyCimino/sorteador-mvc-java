# Sorteador MVC en Java

## Descripción

Aplicación que permite sortear líneas de texto. Las mismas pueden ser obtenidas vía un archivo txt (`ModeloArchivos`) o una base de datos (`ModeloBBDD` sin implementar).
Por otra parte, la interfaz de usuario puede seleccionarse al principio, optando por manejar la aplicación vía interfaz gráfica (`VistaSwing`) o por consola (`VistaConsola`).

El repositorio permite mostrar la base de la arquitectura MVC (Modelo-Vista-Controlador), en la cual el **Controlador** ofrece de intermediario entre la lógica de la aplicación (**Modelo**) y las acciones del usuario (**Vista**), siendo ambas un conjunto de métodos que definen un contrato (interfaces) que debe implementarse según la característica de cada **Vista** o **Modelo**.

## Diagrama de clases

![Diagrama de clases](src/sorteador/clases-sorteador-mvc-java.png)

Proyecto realizado con Eclipse.