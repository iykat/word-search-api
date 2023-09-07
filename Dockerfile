# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container at /app
COPY target/wordsearch-api-0.0.1.jar /app/app.jar

# Run the application when the container starts
CMD ["java", "-jar", "app.jar"]
