# Use lightweight OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR to the container (adjust filename if needed)
COPY target/player-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot runs on (default 8080 or 8081)
EXPOSE 8081

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
