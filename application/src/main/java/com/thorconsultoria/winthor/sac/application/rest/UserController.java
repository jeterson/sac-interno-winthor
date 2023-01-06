package com.thorconsultoria.winthor.sac.application.rest;

import com.thorconsultoria.winthor.sac.domain.application.input.service.UserApplicationService;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;

    @GetMapping("/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        var user = userApplicationService.findByUsername(username);
        return ResponseEntity.ok(user);
    }
}
