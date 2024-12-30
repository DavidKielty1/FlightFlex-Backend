package com.example.FlightFlex.grpc;

import com.example.FlightFlex.repository.AdRecommendationRepository;
import com.example.FlightFlex.entity.AdRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.grpc.stub.StreamObserver;
import com.example.FlightFlex.grpc.FlightServiceGrpc;
import com.example.FlightFlex.grpc.FlightFlexServiceProto.UserIdRequest;
import com.example.FlightFlex.grpc.FlightFlexServiceProto.AdRecommendationsResponse;

import java.util.Arrays;

@Service
public class FlightFlexServiceImpl extends FlightServiceGrpc.FlightServiceImplBase {

    @Autowired
    private AdRecommendationRepository adRecommendationRepository;

    @Override
    public void getAdRecommendations(UserIdRequest request, StreamObserver<AdRecommendationsResponse> responseObserver) {
        AdRecommendation recommendation = adRecommendationRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        AdRecommendationsResponse response = AdRecommendationsResponse.newBuilder()
                .addAllRecommendedAds(Arrays.asList(recommendation.getRecommendedAds().split(", ")))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

