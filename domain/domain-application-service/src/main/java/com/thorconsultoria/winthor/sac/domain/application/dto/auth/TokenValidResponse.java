package com.thorconsultoria.winthor.sac.domain.application.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenValidResponse {
    private boolean valid;
}
