FROM openjdk:12-alpine
EXPOSE 8085
ADD target/kaddem-3.0.0.jar MyApplication.jar
ENTRYPOINT ["java", "-jar", "/MyApplication.jar"]
