package com.thorconsultoria.winthor.sac.domain.application.service;

import com.thorconsultoria.winthor.sac.domain.application.input.service.UserApplicationService;
import com.thorconsultoria.winthor.sac.domain.application.service.user.UserApplicationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =
        { "com.thorconsultoria.winthor.sac.domain.application",
          "com.thorconsultoria.winthor.sac.domain.application.service" })
public class DomainApplicationServiceModule {

}
