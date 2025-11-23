# Concurso: Candidatas Reina de Quito

## 1. Enunciado
Aplicación en Java para registrar candidatas (estudiante/profesional), validar datos, y simular votación. Incluye gestión de candidatas, conteo de votos y obtención de ganadoras.

## 2. Estructura del proyecto
Archivos principales en `src/Candidatas_Reina_de_Quito`:
- `Main.java`
- `Gestion_Candidatas.java`
- `Gestion_Votacion.java`
- `Candidata.java`
- `CandidataEstudiante.java`
- `CandidataProfesional.java`
- `DatoInvalidoException.java`

## 3. Requisitos
- JDK 17+ instalado
- Windows (instrucciones para IntelliJ incluidas)
- IntelliJ IDEA 2025.2.4 (opcional)

## 4. Instrucciones para ejecutar

- Desde IntelliJ IDEA:
  1. Abrir el proyecto.
  2. Asegurarse que el `Project SDK` esté configurado.
  3. Ejecutar la clase `Candidatas_Reina_de_Quito.Main` (Run).

- Desde línea de comandos (PowerShell o CMD) en la raíz del proyecto:
  1. Compilar:
     - `javac -d out -sourcepath src src\Candidatas_Reina_de_Quito\Main.java`
  2. Ejecutar:
     - `java -cp out Candidatas_Reina_de_Quito.Main`

## 5. Capturas de pantalla (colocar en `docs/screenshots/`)
- `docs/screenshots/01_registro_5_candidatas.png` — pantalla tras registrar 5 candidatas
- `docs/screenshots/02_listado_candidatas.png` — listado completo
- `docs/screenshots/03_simulacion_votacion.png` — ingreso de votos
- `docs/screenshots/04_resultados_votacion.png` — resultados finales y ganadoras

Incluya las imágenes en el repositorio y referéncielas desde este README si desea.

## 6. Ejemplos de entrada / salida

Ejemplo: registrar 5 candidatas (consola)

```text
--- Registro de candidata ---
Tipo (estudiante/profesional): estudiante
Nombre: Ana Pérez
Edad: 20
Puntaje jurado: 8.5
Distrito: Centro
Universidad: Universidad Central
Carrera: Diseño

--- Registro de candidata ---
Tipo (estudiante/profesional): profesional
Nombre: María López
Edad: 28
Puntaje jurado: 9.0
Distrito: Norte
Profesión: Arquitecta
Años experiencia: 6

(repetir para 3 candidatas más)