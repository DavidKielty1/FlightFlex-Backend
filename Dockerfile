# Use a base image for Java
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file to the container
COPY build/libs/FlightFlex-1.0-SNAPSHOT.jar /app/FlightFlex-1.0-SNAPSHOT.jar

# Expose the gRPC port
EXPOSE 50051

# Set environment variables for database connection
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/flightflexdb
ENV SPRING_DATASOURCE_USERNAME=flight
ENV SPRING_DATASOURCE_PASSWORD=flex

# Run the gRPC server
CMD ["java", "-jar", "/app/FlightFlex-1.0-SNAPSHOT.jar"]

#docker run --name postgres-container \
#-e POSTGRES_USER=flight \
#-e POSTGRES_PASSWORD=flex \
#-e POSTGRES_DB=flightflexdb \
#-p 5432:5432 \
#-v postgres_data:/var/lib/postgresql/data \
#-d postgres:latest
