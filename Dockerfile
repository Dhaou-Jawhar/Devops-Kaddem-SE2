FROM openjdk:12-alpine
ADD target/kaddem-*.jar /kaddem.jar
CMD ["java", "-jar", "/kaddem.jar"]


