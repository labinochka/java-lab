package ru.kpfu.itis.documentservice.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.documentservice.service.DocumentServiceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GrpcServer {

    private Server server;

    @Value("${grpc.server.port}")
    private int port;

    @PostConstruct
    public void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(new DocumentServiceImpl())
                .build()
                .start();

        System.out.println("gRPC Server started on port " + port);
    }

    @PreDestroy
    public void stop() {
        if (server != null) {
            server.shutdown();
            System.out.println("gRPC Server stopped");
        }
    }
}
