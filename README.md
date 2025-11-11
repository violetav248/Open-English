# Open-English (Maven, NetBeans)

Estructura por paquetes:
- Traductor: lógica de dominio (diccionario, usuarios)
- GUI: interfaz Swing
- TXT: persistencia en archivos de texto

Requisitos: JDK 17+ y NetBeans con soporte Maven.

Abrir en NetBeans:
1. File -> Open Project…
2. Selecciona la carpeta que contiene `pom.xml`.
3. Ejecuta la clase `Traductor.Main` (o desde Maven: `Run`).

Formato de archivos TXT:
- diccionario.txt: `espanol;ingles`
- usuarios.txt: `nombreCompleto;tipoDocumento;numDocumento;username;contrasena`
- historial_<username>.txt: `fechaISO;palabra;idioma;encontrada;resultado`