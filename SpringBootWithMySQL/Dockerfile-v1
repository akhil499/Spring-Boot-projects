# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file to the container
COPY build/libs/SpringBootWithMySQL-0.0.1-SNAPSHOT.jar /app/app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
