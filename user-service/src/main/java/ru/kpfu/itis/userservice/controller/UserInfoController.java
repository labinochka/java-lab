package ru.kpfu.itis.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.userservice.client.DocumentServiceClient;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-info")
public class UserInfoController {

    private final DocumentServiceClient documentServiceClient;

    @GetMapping("/documents/{id}")
    public List<String> getDocumentsByUserId(@PathVariable int id) {
        return documentServiceClient.getDocumentsByUserId(id);
    }
}
