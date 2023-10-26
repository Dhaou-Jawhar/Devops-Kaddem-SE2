FROM openjdk:11-alpine
ADD target/kaddem-* /kaddem.jar
CMD ["java", "-jar", "/kaddem.jar"]


