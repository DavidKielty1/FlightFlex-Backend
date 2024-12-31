package com.example.FlightFlex.grpc;

import com.example.FlightFlex.entity.AdRecommendation;
import com.example.FlightFlex.service.AdRecommendationService;
import com.example.FlightFlex.grpc.FlightFlexServiceProto.UserIdRequest;
import com.example.FlightFlex.grpc.FlightFlexServiceProto.AdRecommendationsResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class FlightFlexServiceImpl extends FlightServiceGrpc.FlightServiceImplBase {
    private final AdRecommendationService service;

    public FlightFlexServiceImpl(AdRecommendationService service) {
        this.service = service;
    }

    @Override
    public void getAdRecommendations(UserIdRequest request, StreamObserver<AdRecommendationsResponse> responseObserver) {
        AdRecommendation recommendation = service.getRecommendationByUserId(request.getUserId());
        if (recommendation != null) {
            AdRecommendationsResponse response = AdRecommendationsResponse.newBuilder()
                    .addRecommendedAds(recommendation.getRecommendedAds())
                    .build();
            responseObserver.onNext(response);
        } else {
            responseObserver.onNext(AdRecommendationsResponse.newBuilder().build());
        }
        responseObserver.onCompleted();
    }
}
