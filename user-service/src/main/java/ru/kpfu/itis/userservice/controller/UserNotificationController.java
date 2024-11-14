package ru.kpfu.itis.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.userservice.service.UserNotificationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-notification")
public class UserNotificationController {

    private final UserNotificationService userNotificationService;

    @GetMapping
    public List<String> getUsersNotifications() {
        return userNotificationService.getUsersNotifications();
    }
}
