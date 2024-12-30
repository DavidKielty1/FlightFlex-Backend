package com.example.FlightFlex;
import com.example.FlightFlex.grpc.FlightFlexServiceImpl;


import io.grpc.Server;
import io.grpc.ServerBuilder;

public class FlightFlexApplication {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
            .addService(new FlightFlexServiceImpl())
            .build()
            .start();

        System.out.println("gRPC server started on port 50051");
        server.awaitTermination();
    }
}
