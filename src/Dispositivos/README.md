# Paquete Dispositivos

## Descripción General

Este paquete fue desarrollado como parte de una tarea de Programación Orientada a Objetos (POO) en Java. El objetivo es crear un sistema de gestión de dispositivos electrónicos que demuestre conceptos fundamentales de POO como herencia, polimorfismo, encapsulación y manejo de excepciones personalizadas.

## Objetivo del Proyecto

Implementar un sistema que permita:
- Crear y gestionar diferentes tipos de dispositivos electrónicos (Laptop y Teléfono)
- Validar datos de entrada mediante excepciones personalizadas
- Utilizar polimorfismo para mostrar información de diferentes dispositivos
- Almacenar dispositivos en una colección dinámica (ArrayList)
- Manejar errores de forma controlada

## Conceptos de POO Aplicados

### 1. Herencia
Se utiliza una clase base `Dispositivo` para las clases especializadas:
- `Laptop`: Representa computadoras portátiles con atributo "RAM (GB)"
- `Telefono`: Representa teléfonos móviles con atributo "sistema operativo"

### 2. Polimorfismo
Aunque en este proyecto la clase base implementa un método común `mostrarInfo()`, el concepto de polimorfismo se aplica permitiendo que objetos de diferentes tipos sean tratados como objetos de la clase base en el ArrayList.

### 3. Encapsulación
Todos los atributos son privados y se accede a través de métodos getters y setters que incluyen validaciones.

### 4. Excepciones Personalizadas
Se creó `DatoInvalidoException` para validar datos de entrada:
- Marca no puede estar vacía
- Precio no puede ser negativo

### 5. Validación de Datos
Cada setter valida que los datos cumplan con ciertos criterios antes de ser asignados.

## Estructura del Paquete

### Clases Principales

**Dispositivo.java (Clase Base)**
- Atributos: marca, modelo, precio
- Constructor que valida los datos al crear una instancia
- Getters y setters con validaciones
- Método `mostrarInfo()`: Muestra la información del dispositivo

**Laptop.java (Hereda de Dispositivo)**
- Atributo adicional: ramGB (memoria RAM en gigabytes)
- Constructor que hereda de Dispositivo y agrega validación de RAM
- Extiende la funcionalidad de la clase base

**Telefono.java (Hereda de Dispositivo)**
- Atributo adicional: sistemaOperativo
- Constructor que hereda de Dispositivo y agrega validación del S.O.
- Extiende la funcionalidad de la clase base

**DatoInvalidoException.java**
- Excepción personalizada para errores de validación
- Se lanza cuando:
  - La marca está vacía o es nula
  - El precio es negativo

**Main.java**
- Programa principal que demuestra el funcionamiento del sistema
- Crea instancias de Laptop y Telefono
- Utiliza try-catch para manejar excepciones
- Incluye ejemplos de datos inválidos comentados para pruebas

## Validaciones Implementadas

### En la Clase Dispositivo

**setMarca(String marca)**
- Valida que no sea nula
- Valida que no esté vacía (trim())
- Lanza `DatoInvalidoException` si no cumple

**setPrecio(double precio)**
- Valida que no sea negativo
- Lanza `DatoInvalidoException` si es menor a 0

### En las Clases Heredadas

**Laptop**
- Hereda las validaciones de marca y precio
- Puede incluir validación adicional de RAM

**Telefono**
- Hereda las validaciones de marca y precio
- Puede incluir validación adicional del sistema operativo

## Ejemplo de Uso

```java
ArrayList<Dispositivo> listaDispositivos = new ArrayList<>();

try {
    // Crear dispositivos válidos
    Laptop laptop1 = new Laptop("Dell", "XPS 15", 1500.00, 16);
    Telefono telefono1 = new Telefono("Samsung", "Galaxy S23", 900.50, "Android");
    
    listaDispositivos.add(laptop1);
    listaDispositivos.add(telefono1);
    
    // Mostrar dispositivos
    for(Dispositivo dispositivo : listaDispositivos) {
        dispositivo.mostrarInfo();
    }
} catch(DatoInvalidoException e) {
    System.out.println("Error al registrar: " + e.getMessage());
}
```

## Pruebas de Excepciones

El archivo Main.java incluye ejemplos comentados para probar el manejo de excepciones:

### Caso A: Precio Negativo
```java
Laptop laptopError = new Laptop("HP", "Pavilion", -500, 8);
// Resultado: DatoInvalidoException: El precio no puede estar vacío
```

### Caso B: Marca Vacía
```java
Telefono telefonoError = new Telefono("", "iPhone 15", 1200, "iOS");
// Resultado: DatoInvalidoException: La marca no puede estar vacío
```

## Flujo de Ejecución

1. Se crea una lista ArrayList para almacenar dispositivos
2. Se intenta crear instancias de Laptop y Telefono
3. Si la creación es exitosa, se agregan a la lista
4. Si hay datos inválidos, se lanza una excepción que es capturada
5. Se muestran todos los dispositivos creados exitosamente

## Salida del Programa

```
--- Registrando dispositivos ---

---Mostrando dispositivos---
Dispositivo: Dell XPS 15 -  $1500.0
Dispositivo: Samsung Galaxy S23 -  $900.5
```

## Aprendizajes Clave

- Importancia de validar datos en el constructor y setters
- Uso de excepciones personalizadas para errores específicos del dominio
- Cómo la herencia permite reutilizar código y lógica de validación
- Aplicación del principio de "fail fast" lanzando excepciones temprano
- Uso de try-catch para manejar excepciones en el flujo del programa
- Polimorfismo mediante referencias de la clase base en colecciones
- El método `trim()` para validar strings
- Diferencia entre validación en el constructor vs. en setters

## Mejoras Futuras

1. Agregar más tipos de dispositivos (Tablet, Smartwatch, etc.)
2. Implementar un método `compareTo()` para ordenar dispositivos por precio
3. Crear un método para guardar/cargar dispositivos en archivo
4. Agregar métodos para actualizar información de dispositivos
5. Implementar un gestor de dispositivos (similar a GestorJuegos) con CRUD completo

## Autor

Desarrollado como parte de las tareas de Programación Orientada a Objetos

