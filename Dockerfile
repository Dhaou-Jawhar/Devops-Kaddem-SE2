# Utilisez une image de base avec Java
FROM openjdk:11

# Copiez le jar de l'application dans l'image
COPY  target/kaddem-0.0.1-SNAPSHOT.jar /app.jar

# Définissez le port sur lequel l'application va écouter


# Commande pour exécuter l'application lors du démarrage du conteneur
CMD ["java", "-jar", "/app.jar"]