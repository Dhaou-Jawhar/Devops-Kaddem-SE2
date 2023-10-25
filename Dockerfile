# Utiliser l'image Java 11 en tant qu'image de base
FROM openjdk:11-jre-slim

# Copier le fichier JAR de votre application dans le conteneur
COPY target/kaddem-3.0.0.jar /app.jar

# Commande pour exécuter l'application Spring Boot
CMD ["java", "-jar", "/app.jar"]