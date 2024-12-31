package com.example.FlightFlex.controller;

import com.example.FlightFlex.grpc.FlightFlexServiceProto.UserIdRequest;
import com.example.FlightFlex.grpc.FlightFlexServiceProto.AdRecommendationsResponse;
import com.example.FlightFlex.grpc.FlightServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightFlexController {
    private final FlightServiceGrpc.FlightServiceBlockingStub stub;

    public FlightFlexController() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        this.stub = FlightServiceGrpc.newBlockingStub(channel);
    }

    @GetMapping("/ads/recommendations")
    public List<String> getRecommendations(@RequestParam int userId) {
        UserIdRequest request = UserIdRequest.newBuilder().setUserId(userId).build();
        AdRecommendationsResponse response = stub.getAdRecommendations(request);
        return response.getRecommendedAdsList();
    }
}
