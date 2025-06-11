
# Use a modern JDK 21 base image
FROM openjdk:21-jdk

EXPOSE 8082

# Optional: allow the JAR file to be passed as a build argument
ARG JAR_FILE=target/*.jar

# Set working directory
WORKDIR /app

# Copy the built JAR into the container
COPY ${JAR_FILE} app.jar

# Default command to run the JAR
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=dev"]