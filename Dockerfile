# Utilisez une image de base avec Java
FROM openjdk:12-alpine

# Copiez le jar de l'application dans l'image
COPY  target/kaddem-*.jar /eyatizaoui/alpine:1.0.0

# Définissez le port sur lequel l'application va écouter


# Commande pour exécuter l'application lors du démarrage du conteneur
CMD ["java", "-jar", "/eyatizaoui/alpine:1.0.0"]