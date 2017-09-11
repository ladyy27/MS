FROM java:8
ADD /target/matriculas-service-0.0.1-SNAPSHOT.jar matriculas-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","matriculas-service-0.0.1-SNAPSHOT.jar","-Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n"]