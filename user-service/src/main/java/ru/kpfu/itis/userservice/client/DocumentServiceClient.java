package ru.kpfu.itis.userservice.client;

import org.springframework.stereotype.Service;
import net.devh.boot.grpc.client.inject.GrpcClient;
import ru.kpfu.itis.documentservice.proto.DocumentServiceGrpc;
import ru.kpfu.itis.documentservice.proto.UserRequest;

import java.util.List;


@Service
public class DocumentServiceClient {

    @GrpcClient("document-service")
    private DocumentServiceGrpc.DocumentServiceBlockingStub service;

    public List<String> getDocumentsByUserId(int id) {
        return service.getDocumentsByUserId(UserRequest.newBuilder()
                .setId(id)
                .build()).getDocumentsList();
    }
}
