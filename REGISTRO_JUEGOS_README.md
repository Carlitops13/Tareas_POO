# Sistema de Registro de Juegos - POO en Java

## Descripción

Este proyecto implementa un **Sistema de Registro de Juegos** que permite registrar y gestionar dos tipos de juegos:
- **Juegos de Mario Bros**
- **Juegos de Carreras de Vehículos**

El sistema aplica conceptos fundamentales de **Programación Orientada a Objetos (POO)** en Java, incluyendo:
- **Herencia**
- **Polimorfismo**
- **Excepciones personalizadas**
- **Gestión de colecciones (ArrayList)**

---

## Estructura del Proyecto

```
RegistroJuegos/
├── DatosInvalidosException.java    # Excepción personalizada
├── Juego.java                       # Clase abstracta base
├── MarioBros.java                   # Clase hija - Juegos Mario Bros
├── CarreraVehiculos.java            # Clase hija - Juegos de Carreras
└── Main.java                        # Controlador principal con menú
```

---

## Características Principales

### 1. Registro de Juegos
- Registrar juegos de Mario Bros con detalles específicos
- Registrar juegos de Carreras de Vehículos con detalles específicos
- Validación completa de datos ingresados

### 2. Gestión de Datos
- Almacenamiento en `ArrayList<Juego>`
- Búsqueda de juegos por nombre
- Filtrado por tipo de juego
- Eliminación de juegos

### 3. Mostrar Información
- Vista de todos los juegos registrados
- Detalles específicos de cada juego (polimorfismo)
- Estadísticas del sistema

### 4. Validación Robusta
- Texto no vacío
- Números positivos
- Calificaciones entre 0.0 y 10.0
- Años de lanzamiento válidos (1980-2025)
- Lanzamiento de excepciones personalizadas

---

## Atributos por Tipo de Juego

### MarioBros
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| nombre | String | Nombre del juego |
| desarrollador | String | Empresa desarrolladora |
| anioLanzamiento | int | Año de lanzamiento |
| calificacion | double | Calificación 0.0-10.0 |
| numeroMundos | int | Cantidad de mundos |
| tieneMultiplayer | boolean | Modo multiplayer |
| plataforma | String | Plataforma (NES, SNES, Switch, etc.) |

### CarreraVehiculos
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| nombre | String | Nombre del juego |
| desarrollador | String | Empresa desarrolladora |
| anioLanzamiento | int | Año de lanzamiento |
| calificacion | double | Calificación 0.0-10.0 |
| numeroCircuitos | int | Cantidad de circuitos |
| tipoVehiculos | String | Tipo de vehículos (Autos, Motos, etc.) |
| tieneIAadaptable | boolean | IA adaptable |
| maxJugadores | int | Máximo de jugadores |

---

## Menú Interactivo

```
╔════════════════════════════════════════════════════╗
║                   MENÚ PRINCIPAL                   ║
╠════════════════════════════════════════════════════╣
║ 1. Registrar Juego Mario Bros                      ║
║ 2. Registrar Juego Carrera de Vehículos            ║
║ 3. Mostrar todos los juegos registrados            ║
║ 4. Buscar juego por nombre                         ║
║ 5. Filtrar juegos por tipo                         ║
║ 6. Eliminar juego                                  ║
║ 7. Mostrar estadísticas                            ║
║ 8. Salir                                           ║
╚════════════════════════════════════════════════════╝
```

---

## Excepción Personalizada

### `DatosInvalidosException`

```java
public class DatosInvalidosException extends Exception {
    public DatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}
```

Se lanza en los siguientes casos:
- Texto vacío o nulo
- Números negativos o cero
- Calificación fuera del rango 0.0-10.0
- Año de lanzamiento inválido
- Campos específicos incompletos

---

## Polimorfismo

El polimorfismo se aplica mediante el método abstracto `obtenerDetalles()`:

```java
// Clase abstracta
public abstract String obtenerDetalles();

// Implementación en MarioBros
@Override
public String obtenerDetalles() {
    return "=== JUEGO MARIO BROS ===" + "\n" + ...
}

// Implementación en CarreraVehiculos
@Override
public String obtenerDetalles() {
    return "=== JUEGO CARRERA DE VEHÍCULOS ===" + "\n" + ...
}

// Uso polimórfico
for (Juego juego : juegos) {
    System.out.println(juego.obtenerDetalles()); // Cada uno llama su versión
}
```

---

## Ejemplo de Uso

### Registro de un Juego Mario Bros
```
Nombre: Super Mario Bros 3
Desarrollador: Nintendo
Año: 1990
Calificación: 9.5
Número de Mundos: 8
¿Multiplayer? (s/n): s
Plataforma: NES
```

### Registro de un Juego de Carreras
```
Nombre: Mario Kart 8
Desarrollador: Nintendo
Año: 2014
Calificación: 9.2
Número de Circuitos: 32
Tipo de Vehículos: Karts
¿IA Adaptable? (s/n): s
Máximo de Jugadores: 4
```

---

## Cómo Ejecutar

1. **Compilar el proyecto:**
   ```bash
   javac src/RegistroJuegos/*.java
   ```

2. **Ejecutar la aplicación:**
   ```bash
   java -cp src RegistroJuegos.Main
   ```

3. **Usar el menú interactivo** para registrar y gestionar juegos.

---

## Diagrama UML

El diagrama UML completo está disponible en `RegistroJuegos.puml` e incluye:
- Clase abstracta `Juego`
- Clases hijas `MarioBros` y `CarreraVehiculos`
- Clase controladora `Main`
- Excepción personalizada `DatosInvalidosException`
- Relaciones de herencia y dependencia

---

## Requerimientos Cumplidos

- Clase abstracta `Juego` con atributos base y método abstracto
- Clases hijas `MarioBros` y `CarreraVehiculos` que heredan de `Juego`
- Excepción personalizada `DatosInvalidosException`
- Gestión de juegos en `ArrayList<Juego>`
- Menú interactivo en consola
- Polimorfismo en método `obtenerDetalles()`
- Validación robusta de datos
- Diagrama UML completo

---

## Conceptos de POO Aplicados

| Concepto | Aplicación |
|----------|-----------|
| **Encapsulación** | Atributos protegidos/privados con getters/setters |
| **Herencia** | MarioBros y CarreraVehiculos heredan de Juego |
| **Polimorfismo** | Método `obtenerDetalles()` implementado diferente en cada clase |
| **Abstracción** | Clase Juego define la interfaz común |
| **Excepciones** | `DatosInvalidosException` para manejo de errores |

---

## Notas Importantes

- El sistema valida todos los datos antes de guardarlos
- Se pueden registrar múltiples juegos del mismo tipo
- La búsqueda es **case-insensitive**
- Las estadísticas se calculan en tiempo real
- La interfaz es amigable con bordes decorativos

---

**Creado como actividad de Programación Orientada a Objetos (POO) en Java**

