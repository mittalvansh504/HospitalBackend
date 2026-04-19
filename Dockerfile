# Use Java 17 image
FROM eclipse-temurin:17-jdk

# Copy project files
WORKDIR /app
COPY . .

# Build the project
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Run the jar
CMD ["java", "-jar", "target/HealthManagement-0.0.1-SNAPSHOT.jar"]