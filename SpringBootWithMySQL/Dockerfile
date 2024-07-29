# Stage 1: Build the application
FROM gradle:8.1-jdk17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle settings.gradle ./

# Download dependencies (this step caches dependencies to speed up future builds)
RUN gradle dependencies --no-daemon

# Copy the rest of the application code
COPY . .

# Build the application
RUN gradle clean build --no-daemon

# Stage 2: Create the runtime image
FROM gcr.io/distroless/java17-debian11 AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/SpringBootWithMySQL-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port 8080
EXPOSE 8080

# Run the JAR file
CMD ["app.jar"]
git add .
