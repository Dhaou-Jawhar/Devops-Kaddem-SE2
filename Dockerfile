FROM openjdk:12-alpine

ENV PORT 8081
EXPOSE 8081

COPY target/kaddem-*.jar /kaddem.jar

CMD ["java" , "-jar", "/kaddem.jar"]
