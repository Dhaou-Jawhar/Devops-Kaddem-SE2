# Création de l'image de projet à partir de jar dans le nexus
#FROM openjdk:12-alpine

#EXPOSE 8085

#ADD http://192.168.33.10:8081/repository/maven-snapshots/ /kaddem-1.0.jar


# Commande pour exécuter l'application Spring Boot
##ENTRYPOINT ["java", "-jar", "/kaddem-1.0.jar"]
##############################################
# Utiliser l'image Java 11 en tant qu'image de base
FROM openjdk:12-alpine

# EXPOSE 8085  # Vous n'avez pas besoin de cette ligne si votre application n'écoute pas sur ce port

# Copier le fichier JAR de votre application dans le conteneur
COPY target/kaddem-*.jar /app.jar

# Commande pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/app.jar"]
