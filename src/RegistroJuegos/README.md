# Paquete RegistroJuegos

## Descripción General

Este paquete fue desarrollado como parte de una tarea de Programación Orientada a Objetos (POO) en Java. El objetivo es crear un sistema de registro y gestión de juegos de video que demuestre conceptos fundamentales de POO como herencia, polimorfismo, manejo de colecciones (ArrayList) y excepciones personalizadas.

## Objetivo del Proyecto

Implementar un sistema interactivo que permita:
- Registrar diferentes tipos de juegos (Mario Bros y Juegos de Carreras)
- Almacenar información de los juegos en una colección dinámica
- Buscar juegos por nombre
- Filtrar juegos por tipo
- Mostrar todos los juegos registrados

## Conceptos de POO Aplicados

### 1. Herencia
Se utilizó una clase abstracta `Juego` como base para las clases especializadas:
- `MarioBros`: Representa juegos de la serie Mario Bros con atributo "personaje principal"
- `CarreraVehiculos`: Representa juegos de carreras con atributo "tipo de vehículo"

### 2. Polimorfismo
Cada clase hija implementa su propio método `mostrarDetalles()` para mostrar información específica del tipo de juego.

### 3. Manejo de Colecciones (ArrayList)
Se utiliza un `ArrayList<Juego>` para almacenar dinámicamente los juegos registrados, permitiendo agregar, buscar y filtrar elementos.

### 4. Excepciones Personalizadas
Se creó `ExcepcionJuego` para validar datos de entrada y lanzar excepciones cuando los datos son inválidos (precio negativo, año inválido, campos vacíos).

### 5. Encapsulación
Todos los atributos son privados/protegidos y se accede a través de métodos getters y setters.

## Estructura del Paquete

### Clases Principales

**Juego.java (Clase Abstracta)**
- Atributos: nombre, precio, anioLanzamiento
- Método abstracto: mostrarDetalles()
- Getters y setters para los atributos

**MarioBros.java (Hereda de Juego)**
- Atributo adicional: personajePrincipal
- Implementa mostrarDetalles() mostrando información específica del juego Mario Bros

**CarreraVehiculos.java (Hereda de Juego)**
- Atributo adicional: tipoVehiculo
- Implementa mostrarDetalles() mostrando información específica del juego de carreras

**GestorJuegos.java**
- Gestiona el ArrayList de juegos
- Métodos principales:
  - `registrarJuego()`: Agrega un nuevo juego a la lista
  - `listarJuegos()`: Muestra todos los juegos registrados
  - `buscarPorNombre()`: Busca un juego específico por nombre
  - `filtrarPorTipo()`: Filtra juegos por su tipo (Mario Bros o Carreras)

**ExcepcionJuego.java**
- Excepción personalizada para validaciones del sistema de juegos

**Main.java**
- Implementa un menú interactivo en consola
- Permite al usuario registrar juegos, buscar, filtrar y listar
- Manejo de excepciones para entrada de datos inválida

## Funcionalidades del Sistema

### Menú Principal
```
--- SISTEMA DE REGISTRO DE JUEGOS ---
1. Registrar Juego de Mario Bros
2. Registrar Juego de Carreras
3. Mostrar todos los juegos
4. Buscar juego por nombre
5. Filtrar por tipo de juego
6. Salir
```

### Opción 1: Registrar Juego de Mario Bros
- Solicita: nombre, precio, año de lanzamiento, personaje principal
- Valida que los datos sean correctos
- Agrega el juego a la lista

### Opción 2: Registrar Juego de Carreras
- Solicita: nombre, precio, año de lanzamiento, tipo de vehículo
- Valida que los datos sean correctos
- Agrega el juego a la lista

### Opción 3: Mostrar todos los juegos
- Recorre el ArrayList y muestra todos los juegos registrados
- Cada juego muestra su información específica

### Opción 4: Buscar juego por nombre
- Solicita el nombre del juego a buscar
- Utiliza `equalsIgnoreCase()` para búsqueda sin importar mayúsculas/minúsculas
- Muestra los detalles del juego si lo encuentra

### Opción 5: Filtrar por tipo de juego
- Permite filtrar por "Mario Bros" o "Juegos de Carreras"
- Utiliza `isInstance()` para verificar el tipo de cada objeto

### Opción 6: Salir
- Cierra el programa

## Manejo de Errores

El sistema incluye tres niveles de manejo de excepciones:

1. **ExcepcionJuego**: Errores de validación de datos (precio negativo, campos vacíos, etc.)
2. **InputMismatchException**: Error cuando se ingresa un valor que no es un número
3. **Exception**: Captura general para cualquier error inesperado

## Correcciones Realizadas

Durante el desarrollo se identificaron y corrigieron dos errores lógicos críticos:

1. **Búsqueda por nombre**: La condición de validación estaba invertida. Se corrigió de `if (encontrado)` a `if (!encontrado)`.

2. **Filtrado por tipo**: El parámetro de la función `isInstance()` era incorrecto. Se corrigió de `tipo.isInstance(tipo)` a `tipo.isInstance(juego)`.

## Ejemplo de Uso

```
--- SISTEMA DE REGISTRO DE JUEGOS ---
1. Registrar Juego de Mario Bros

---Nuevo Mario Bros ---
Nombre:: Super Mario World
Precio: 59.99
Año: 1990
Personaje Principal: Mario

--- Nuevo Juego de Carreras ---
Nombre: Need for Speed
Precio: 49.99
Año: 2015
Tipo de Vehículo: Autos de Carreras

---Mostrando dispositivos---
Juego: Super Mario World, Precio: 59.99, Año: 1990, Personaje: Mario
Juego: Need for Speed, Precio: 49.99, Año: 2015, Vehículo: Autos de Carreras
```

## Aprendizajes Clave

- La importancia de la herencia para reutilizar código
- Cómo el polimorfismo permite que diferentes tipos de objetos compartan una interfaz común
- Uso de colecciones dinámicas con ArrayList
- Creación de excepciones personalizadas para validaciones específicas
- Manejo de excepciones en menús interactivos
- Uso de métodos de comparación como `equalsIgnoreCase()` e `isInstance()`

## Autor

Desarrollado como parte de las tareas de Programación Orientada a Objetos

