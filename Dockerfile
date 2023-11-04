#FROM openjdk:12-alpine
FROM kaddem_back-end:2.0.0
COPY target/kaddem-*.jar /kaddem.jar

CMD ["java" , "-jar", "/kaddem.jar"]

