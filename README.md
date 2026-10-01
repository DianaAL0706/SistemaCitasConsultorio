# Sistema de Administración de Citas para Consultorio Clínico

## Descripción
Proyecto desarrollado en Java para simular un sistema de administración de citas de un consultorio clínico.

El sistema permitirá registrar doctores y pacientes, crear citas y relacionarlas con un doctor y un paciente. También contará con un control de acceso para administradores mediante un identificador y una contraseña.

## Funcionalidades
- Alta de doctores.
- Alta de pacientes.
- Creación de citas con fecha y hora.
- Asignación de un doctor y un paciente a cada cita.
- Control de acceso mediante administradores.

## Tecnologías utilizadas
- Java 11
- IntelliJ IDEA
- Git
- GitHub
## Instalación y configuración

1. Instalar JDK 11.
2. Instalar y configurar IntelliJ IDEA.
3. Instalar y configurar Git.
4. Clonar o descargar el repositorio del proyecto.
5. Abrir el proyecto en IntelliJ IDEA.
6. Verificar que el JDK 11 esté configurado como SDK del proyecto.
7. Ejecutar la aplicación desde la clase `Main.java` en IntelliJ IDEA o mediante el archivo JAR ejecutable.
    Para generar el archivo JAR desde IntelliJ IDEA, se debe configurar un artefacto de tipo JAR utilizando la opción `From modules with dependencies`, seleccionar la clase `Main` como clase principal y posteriormente utilizar `Build > Build Artifacts`.

## Uso del programa

El programa simula un sistema de administración de citas para un consultorio clínico.

Al ejecutar la aplicación, el sistema valida el acceso del administrador y permite realizar las siguientes operaciones:

- Registrar doctores mediante un ID, nombre completo y especialidad.
- Registrar pacientes mediante un ID y nombre completo.
- Crear citas indicando ID, fecha, hora y motivo.
- Asignar a cada cita un doctor y un paciente previamente registrados.
- Validar que no existan identificadores duplicados.
- Almacenar la información de doctores, pacientes y citas en archivos dentro de la carpeta `db`.
- Recuperar la información almacenada al iniciar nuevamente el programa.
- Regenerar automáticamente los archivos de datos en caso de que no existan.

El programa puede ejecutarse desde la clase `Main.java` en IntelliJ IDEA o mediante el archivo JAR ejecutable generado a partir del proyecto.

## Créditos

Proyecto académico desarrollado por Diana Torres Rionda.

## Licencia

Este proyecto fue desarrollado con fines académicos y educativos. Su código se proporciona únicamente para fines de aprendizaje y evaluación académica.

## Estado del proyecto

Versión estable v1.0.

El sistema cuenta con las funcionalidades de registro de doctores, pacientes y citas, persistencia de información mediante archivos y generación de un JAR ejecutable.