# Use a base image for Java
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file to the container
COPY target/FlightFlex-1.0.0.jar /app/FlightFlex-1.0.0.jar

# Expose the gRPC port
EXPOSE 50051

# Run the gRPC server
CMD ["java", "-jar", "/app/FlightFlex-1.0.0.jar"]
