# MS
REST service with Eureka and Zuul (Netflix)

Para correr el proyecto (localmente)
***ANTES***
- Se requiere MySQL Server
- Crear una base de datos de nombre: srcl
- Importar srcl.sql

1) Levantar Eureka
- En Netbeans :
Clean & Build 
Run
- Con Maven:
En la consola, ir al root del proyecto y ejecutar
./mvnw clean package
- En el navegador: localhost:8761

2) Levantar el servicio ms-matriculas
- En Netbeans :
Clean & Build 
Run
- Con Maven:
En la consola, ir al root del proyecto y ejecutar
./mvnw clean package
- En el navegador: localhost:3333/matriculas/{id_curso}

3) Levantar Zuul Proxy:
- En Netbeans :
Clean & Build 
Run
- Con Maven:
En la consola, ir al root del proyecto y ejecutar
./mvnw clean package
- En el navegador: localhost:9090/matriculas/{id_curso}


Zuul debe ser capaz de responder a las mismas solicitudes que el servicio

