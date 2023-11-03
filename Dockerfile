# Utilisez une image de base avec Java
FROM openjdk:12-alpine

# Copiez le jar de l'application dans l'image
COPY  target/kaddem-*.jar /kaddem.jar

# Définissez le port sur lequel l'application va écouter


# Commande pour exécuter l'application lors du démarrage du conteneur
CMD ["java", "-jar", "/kaddem.jar"]