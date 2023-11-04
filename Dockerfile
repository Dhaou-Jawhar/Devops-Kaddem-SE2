FROM openjdk:12-alpine

ADD http://192.168.18.129:8081/repository/maven-snapshots/ /kaddem.jar

ENTRYPOINT ["java" , "-jar", "/kaddem.jar"]

