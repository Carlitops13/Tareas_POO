Sistema de Registro de Olimpiadas

Descripcion
Este programa en Java implementa un sistema completo de gestion de olimpiadas que permite registrar olimpiadas, crear eventos, y registrar participantes (atletas y equipos). El sistema utiliza conceptos fundamentales de Programacion Orientada a Objetos como herencia, polimorfismo, manejo de listas y excepciones personalizadas.

Objetivo General
Modelar un sistema UML de gestion de olimpiadas, permitiendo registrar participantes, eventos y la informacion principal de la olimpiada, utilizando herencia y polimorfismo para distinguir entre tipos de participantes.

Estructura del Proyecto
SistemaOlimpiadas/
├── DatosInvalidosException.java
├── Participante.java
├── Atleta.java
├── Equipo.java
├── Evento.java
├── Olimpiada.java
└── Main.java

Clases Principales

1. DatosInvalidosException
Excepcion personalizada para manejar datos invalidos o insuficientes.
Se lanza cuando:
- Campos de texto estan vacios
- Numeros estan fuera de rango
- Datos requeridos son nulos

2. Participante (Clase Abstracta)
Define la estructura base para todos los participantes.
Atributos:
- nombre: String
- pais: String
- anoRegistro: int

Metodos:
- obtenerDetalles(): String (abstracto)
- validarDatos(): void
- Getters y Setters con validacion

3. Atleta
Hereda de Participante.
Atributos adicionales:
- deporte: String
- edad: int
- altura: double

Metodo sobrescrito:
- obtenerDetalles(): Muestra tipo "ATLETA" con todos los detalles

4. Equipo
Hereda de Participante.
Atributos adicionales:
- nombreEquipo: String
- cantidadMiembros: int
- deporte: String

Metodo sobrescrito:
- obtenerDetalles(): Muestra tipo "EQUIPO" con todos los detalles

5. Evento
Gestiona eventos de una olimpiada.
Atributos:
- nombre: String
- disciplina: String
- fecha: String
- participantes: ArrayList<Participante>

Metodos principales:
- agregarParticipante(): Agrega un participante al evento
- mostrarParticipantes(): Muestra todos los participantes (aplicando polimorfismo)
- obtenerDetalles(): Retorna informacion del evento

6. Olimpiada
Gestiona la informacion general de una olimpiada y sus eventos.
Atributos:
- nombre: String
- pais: String
- ano: int
- eventos: ArrayList<Evento>

Metodos principales:
- agregarEvento(): Agrega un evento a la olimpiada
- mostrarEventos(): Muestra todos los eventos
- obtenerDetalles(): Retorna informacion de la olimpiada

7. Main
Clase principal con menu interactivo.
Funcionalidades:
1. Crear Olimpiada
2. Crear Evento
3. Registrar Atleta
4. Registrar Equipo
5. Mostrar Olimpiadas
6. Mostrar Eventos de Olimpiada
7. Mostrar Participantes de Evento
8. Salir

Validaciones
- Nombres y textos no pueden estar vacios
- Anos deben estar en rangos validos (1900-2100 para olimpiadas, 2000-2100 para participantes)
- Edad debe estar entre 10 y 100 anos
- Altura debe estar entre 0 y 3 metros
- Cantidad de miembros de equipo entre 2 y 100
- Se validan entradas numericas invalidas

Polimorfismo
El polimorfismo se aplica mediante:
1. Metodo abstracto obtenerDetalles() en Participante
2. Sobrescritura en Atleta y Equipo con detalles especificos
3. Cuando se muestran participantes en un evento, cada uno llama su propia implementacion

Relaciones UML
- Herencia: Atleta y Equipo heredan de Participante
- Composicion: Evento contiene ArrayList de Participantes
- Composicion: Olimpiada contiene ArrayList de Eventos
- Dependencia: Main depende de todas las clases

Como Compilar y Ejecutar

Compilar:
javac src/SistemaOlimpiadas/*.java

Ejecutar:
java -cp src SistemaOlimpiadas.Main

Ejemplo de Uso

Paso 1: Crear Olimpiada
Nombre: Paris 2024
Pais: Francia
Ano: 2024

Paso 2: Crear Evento
Nombre: Atletismo 100m
Disciplina: Atletismo
Fecha: 05/08/2024

Paso 3: Registrar Atleta
Nombre: Juan Perez
Pais: Mexico
Ano Registro: 2024
Deporte: Atletismo
Edad: 28
Altura: 1.85

Paso 4: Registrar Equipo
Nombre Pais: Mexico
Pais: Mexico
Ano Registro: 2024
Nombre Equipo: Voleibol Mexico
Cantidad Miembros: 12
Deporte: Voleibol

Paso 5: Mostrar Participantes
Ver todos los atletas y equipos registrados en un evento

Requerimientos Cumplidos
- Clase abstracta Participante con atributos base y metodo abstracto
- Clases hijas Atleta y Equipo que heredan de Participante
- Clase Evento para registrar participantes
- Clase Olimpiada para almacenar eventos
- Polimorfismo en metodo obtenerDetalles()
- Excepciones personalizadas para validar datos
- Listas dinamicas (ArrayList) para gestionar datos
- Menu interactivo completo
- Validaciones robustas de entrada
- Diagrama UML completo

Conceptos de POO Aplicados
- Encapsulacion: Atributos privados/protegidos con getters/setters
- Herencia: Atleta y Equipo heredan de Participante
- Polimorfismo: Metodo obtenerDetalles() con diferentes implementaciones
- Abstraccion: Clase Participante define interfaz comun
- Composicion: Evento y Olimpiada contienen colecciones de otros objetos

Notas Importantes
- El sistema valida todos los datos antes de guardarlos
- Se pueden registrar multiples atletas y equipos en un mismo evento
- La busqueda de olimpiadas y eventos es interactiva
- Cada olimpiada puede tener multiples eventos
- Cada evento puede tener multiples participantes (atletas y/o equipos)
- El polimorfismo permite mostrar detalles especificos de cada tipo de participante

Autor
Actividad de Programacion Orientada a Objetos (POO) en Java

