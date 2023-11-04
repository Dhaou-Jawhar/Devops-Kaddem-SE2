FROM openjdk:12-alpine

#ADD http://192.168.18.129:8081/repository/maven-snapshots/ /kaddem.jar
COPY target/kaddem-*.jar /kaddem.jar

CMD ["java" , "-jar", "/kaddem.jar"]

