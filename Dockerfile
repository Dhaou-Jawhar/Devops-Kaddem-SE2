# Utiliser l'image Java 11 en tant qu'image de base
FROM openjdk:12-alpine

EXPOSE 8085

ADD http://192.168.33.10:8081/repository/maven-snapshots/ /kaddem-1.0.jar
# Copier le fichier JAR de votre application dans le conteneur
#COPY target/kaddem-*.jar /app.jar

# Commande pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/kaddem-1.0.jar"]