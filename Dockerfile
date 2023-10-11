FROM openjdk:12-alpine

ENV PORT 8080
EXPOSE 8080

COPY target/kaddem-*.jar /kaddem.jar

CMD ["java" , "-jar", "/kaddem.jar"]
