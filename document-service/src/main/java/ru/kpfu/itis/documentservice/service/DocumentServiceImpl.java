package ru.kpfu.itis.documentservice.service;

import io.grpc.stub.StreamObserver;
import ru.kpfu.itis.documentservice.proto.DocumentServiceGrpc;
import ru.kpfu.itis.documentservice.proto.UserRequest;
import ru.kpfu.itis.documentservice.proto.UserResponse;

import java.util.List;
import java.util.Map;

public class DocumentServiceImpl extends DocumentServiceGrpc.DocumentServiceImplBase {

    private final Map<Integer, List<String>> documents = Map.of(
            1, List.of("doc1_1", "doc1_2"),
            2, List.of("doc2_1"),
            3, List.of("doc3_1", "doc3_2", "doc3_3")
    );

    @Override
    public void getDocumentsByUserId(UserRequest request, StreamObserver<UserResponse> responseObserver) {

        UserResponse response = UserResponse.newBuilder()
                .addAllDocuments(documents.get(request.getId()))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
