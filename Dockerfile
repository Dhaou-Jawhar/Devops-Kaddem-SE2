FROM openjdk:12-alpine

COPY target/kaddem-*.jar /kaddem.jar

CMD ["java" , "-jar", "/kaddem.jar"]