# Usa una imagen base de OpenJDK 17 con Gradle instalado
FROM gradle:jdk17 AS builder

# Copia los archivos de tu aplicación al contenedor
# COPY . /home/build/libs
# WORKDIR /home/build/libs

# Ejecuta la construcción de tu aplicación Spring Boot usando Gradle
# RUN ./gradlew build  --no-daemon

# Establece una imagen base más ligera
FROM openjdk:17-alpine

# Establece el directorio de trabajo en /app
# WORKDIR /app

# Copia el archivo JAR construido por Gradle desde la imagen anterior
ADD  build/libs/ecommerce-0.0.1-SNAPSHOT.jar ecommerce-0.0.1-SNAPSHOT.jar

# Expone el puerto 8080
EXPOSE 8002

# Comando para ejecutar la aplicación Spring Boot cuando el contenedor se inicie
CMD ["java", "-jar", "app.jar"]