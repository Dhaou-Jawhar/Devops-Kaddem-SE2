# Utiliser l'image Java 11 en tant qu'image de base
FROM openjdk:12-alpine

# Copier le fichier JAR de votre application dans le conteneur
COPY target/kaddem-*.jar /app.jar

# Commande pour exécuter l'application Spring Boot
CMD ["java", "-jar", "/app.jar"]