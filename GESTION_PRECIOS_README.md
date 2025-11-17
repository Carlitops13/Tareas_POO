Gestion de Precios Inmobiliarios

Descripcion
Este programa en Java gestiona los precios de casas y departamentos utilizando un ArrayList<Double>. Permite al usuario ingresar, buscar, filtrar y analizar precios mediante un menu interactivo en consola.

Estructura del Proyecto
GestionPrecios/
└── GestionPrecios.java

Funcionalidades Principales

1. Ingresar Precio
Solicita al usuario un valor numerico (double) que representa el precio de un inmueble.
Valida que el precio sea mayor a cero.
Agrega el valor al ArrayList.

2. Mostrar Todos los Precios
Muestra todos los precios registrados en el sistema.
Si no hay precios, muestra: "No existen precios registrados."

3. Mostrar Precio Mas Alto
Recorre el ArrayList para obtener el valor maximo.
Muestra el resultado.

4. Mostrar Precio Mas Bajo
Recorre el ArrayList para obtener el valor minimo.
Muestra el resultado.

5. Mostrar Precios Iguales
Solicita al usuario un precio de referencia.
Cuenta y muestra cuantos precios iguales existen.

6. Buscar Precio Especifico
Solicita al usuario el precio a buscar.
Utiliza el metodo contains() para verificar si existe en el ArrayList.
Muestra un mensaje indicando si se encontro o no.

7. Salir
Finaliza el programa.

Menu Principal
===== MENU DE PRECIOS INMOBILIARIOS =====
1. Ingresar precio
2. Mostrar todos los precios
3. Mostrar precio mas alto
4. Mostrar precio mas bajo
5. Mostrar precios iguales
6. Buscar un precio especifico
7. Salir
Seleccione una opcion:

Validaciones
Los precios deben ser mayores a cero.
Se validan entradas numericas invalidas.
Se valida que el ArrayList no este vacio antes de realizar operaciones.

Ejemplo de Uso
Ingrese los siguientes precios:
1. 250000.50
2. 350000.00
3. 250000.50
4. 450000.75
5. 200000.00

Resultados:
- Precio mas alto: 450000.75
- Precio mas bajo: 200000.00
- Precios iguales a 250000.50: 2 coincidencias
- Buscar 350000.00: Se encuentra en la lista

Metodos Principales

mostrarMenu()
Muestra las opciones disponibles en el menu.

obtenerOpcion()
Lee la opcion ingresada por el usuario.

ingresarPrecio()
Agrega un nuevo precio al ArrayList con validacion.

mostrarPrecios()
Muestra todos los precios almacenados.

precioMasAlto()
Encuentra y muestra el precio maximo.

precioMasBajo()
Encuentra y muestra el precio minimo.

precioIguales()
Cuenta y muestra precios duplicados.

buscarPrecio()
Busca si un precio existe en el ArrayList.

Como Compilar y Ejecutar

Compilar:
javac src/GestionPrecios/GestionPrecios.java

Ejecutar:
java -cp src GestionPrecios.GestionPrecios

Requerimientos Cumplidos
- Utilizacion de ArrayList<Double>
- Menu interactivo en consola
- Validacion de datos ingresados
- Metodos organizados para cada funcionalidad
- Manejo de ciclos y estructuras de control
- Diagrama UML incluido
- Pruebas con al menos 5 precios distintos

Autor
Actividad de Programacion Orientada a Objetos (POO) en Java

