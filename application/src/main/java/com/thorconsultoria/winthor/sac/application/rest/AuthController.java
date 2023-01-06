package com.thorconsultoria.winthor.sac.application.rest;

import com.thorconsultoria.winthor.sac.domain.application.dto.auth.TokenValidResponse;
import com.thorconsultoria.winthor.sac.domain.application.input.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SecurityService securityService;

    @GetMapping("/validate-token")
    public ResponseEntity<TokenValidResponse> validateToken(@RequestParam(name = "token") String token) {
       var isTokenValid = securityService.isTokenValid(token);
       return ResponseEntity.ok(new TokenValidResponse(isTokenValid));
    }
}
