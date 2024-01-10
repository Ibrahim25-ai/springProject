# Use the official OpenJDK 17 base image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/Evenement-service-0.0.1-SNAPSHOT.jar /app/


# Specify the command to run your application
CMD ["java", "-jar", "Evenement-service-0.0.1-SNAPSHOT.jar"]
