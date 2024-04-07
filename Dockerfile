# Use a base image with Java and Alpine Linux
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY build/libs/springbootdemoapplication-0.0.1-SNAPSHOT.jar /app/my-userapi-app1.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "my-userapi-app1.jar"]
