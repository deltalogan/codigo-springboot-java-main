# Usa una imagen base con OpenJDK 11 y Maven instalados
FROM ubi9/openjdk-21:latest AS build-stage

USER root

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia solo pom
COPY pom.xml pom.xml

# Descarga las dependencias del proyecto y las guarda en el contenedor
RUN mvn dependency:go-offline

# Copia config y código fuente al contenedor
COPY . .

# Empaqueta la aplicación
RUN mvn package -DskipTests

# Etapa de ejecución
FROM ubi9/openjdk-21:latest

USER root

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR construido en la etapa anterior al contenedor
COPY --from=build-stage /app/target/app.jar ./app.jar

# Copia la configuración específica del perfil al contenedor
COPY application.yml ./config/application.yml
COPY application-local.yml ./config/application-local.yml
COPY application-dev.yml ./config/application-dev.yml
COPY application-qa.yml ./config/application-qa.yml
COPY application-pre.yml ./config/application-pre.yml
COPY application-prod.yml ./config/application-prod.yml

# Expone el puerto 8080
EXPOSE 8080

# Agrega un usuario no privilegiado (cambia 'appuser' según tus preferencias)
RUN adduser appuser && chown -R appuser /app
USER appuser

# Command to run the application when the container starts with the active profile and configuration file
CMD java -jar app.jar --spring.profiles.active=${ENV_PROFILE}