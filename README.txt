**********************************
** GUIA DE APLICACION JJOO AFAF **
**********************************
**********************************

------------------------
REQUISITOS DE TECNOLOGÍA
------------------------
1. MySQL 5 o superior
2. Java JDK 8
2. Eclipse IDE
3. Maven 3
4. Tomcat 7 o superior

-----------------------
DESPLEGAR LA APLICACION
-----------------------
1. Instalar la BBDD de MySQL en localhost con puerto 3306 y usuario=root y password=root.
2. Abrir MySQL y ejecutar el servicio de servidor de BBDD MySQL.
3. Ejecutar los scripts de BBDD juegosolimpicos_ddl.sql y table_hibernate_sequence.sql situados en la carpeta scripts.
4. Instalar entorno Eclipse, Maven y Tomcat.
5. Abrir Eclipse y configurar Maven y servidor Tomcat.
6. Descomprimir el zip del proyecto en el workspace de Eclipse e importar proyecto maven o, clonar el repositorio de GitHub con 
url: https://github.com/angelfelipereturns/jjoo
7. Una vez el proyecto esté constriudo añadirlo al servidor Tomcat configurado.
8. Arrancar el servidor Tomcat y abrir un navegador para acceder a la aplicación en: http://localhost:8080/jjoo
9. Para acceder al servicio REST de resumen de sedes la url es: http://localhost:8080/jjoo/resumensedes

-------------------------
INFORMACION DE DESARROLLO
-------------------------
1. Para el desarrollo de ésta aplicación se ha utilizado el arquetipo de Spring Boot con el fin de tener un mayor control de las
versiones de las dependencias del proyecto en Maven, así como para poder ser más ágil a la hora de la codificación.
2. Con ello el proyecto se construye bajo la tecnología Maven y resolver así las dependencias del proyecto.
3. Además junto con el arquetipo de Spring Boot se han incluido las dependencias de JDBC, JPA, MySQL connector, Rest, Thymeleaf, Web y Test.
4. La arquitectura se divide según la utilidad de las clases siendo la estructura de los paquetes la siguiente:
Dentro de src/main/java:
- com.afaf.jjoo --> clases de inicialización de la aplicación con Spring Boot: 
	JjooApplication.java que contiene el método main para correr la aplicación.
	ServletInitializer.java que contiene el método configure para dar al contexto de la aplicación los recursos.
- com.afaf.jjoo.controller --> clases para controlar las peticiones http a la aplicación y unirlas con el backend.
- com.afaf.jjoo.data --> clases e interfaces con lógica de acceso a datos.
- com.afaf.jjoo.data.mapper --> clases para instanciar RowMapper necesarias para JDBCTemplate de acceso a datos.
- com.afaf.jjoo.data.model --> clases de entidades de BBDD para el mapeo de datos con JDBCTemplate o JPARepositoy.
- com.afaf.jjoo.rest --> clases controladoras para el API REST servido en la aplicación.
- com.afaf.jjoo.data.service --> clases de servicio para la comunicación con DAOs o lógica interna.
----------------------------------------------------------------------------------------------------------------------------- 
Para un mayor detalle acceder al javadoc de la aplicación situado en la carpeta doc y ejecutar index.html en el navegador.
----------------------------------------------------------------------------------------------------------------------------- 
Dentro de src/main/resources:
- Se encuentra el archivo application.properties para las propiedades de acceso a BBDD y demás.
- /static/css/ --> archivos css de la aplicación.
- /static/js/  --> archivos javascript de la aplicación.
- /static/template/  --> archivos html de la aplicación.
Dentro de src/test/java:
- com.afaf.jjoo --> JjooApplicationTests.java: test para la clase de inicialización.
- com.afaf.jjoo.test --> ResumenSedesDaoTests.java: test para la clase de ResumenSedesDao.
3. En el acceso a la BBDD se ha utilizado tanto JDBCTemplate como JPARepositoy de Spring Data.
4. Para la lógica de negocio y control de peticiones http se ha utilizado Spring Core y Spring Web.
5. En la realización de los test se ha utilizado la implementación JUnit de Spring.
6. Para la parte front de la aplicación se ha utilizado Thymeleaf, html5, css3, Bootstrap y jQuery. 
