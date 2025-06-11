# -------- Stage 1: Build with Maven --------
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Set working directory
WORKDIR /build

# Copy pom.xml and download dependencies first
COPY ./ ./
RUN mvn dependency:go-offline

# Copy the entire source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# -------- Stage 2: Run with OpenJDK --------
FROM openjdk:21-jdk

# Set working directory
WORKDIR /app

# Copy the jar from the builder stage
COPY --from=builder /build/target/*.jar app.jar

# Run the application with the dev profile
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=dev"]