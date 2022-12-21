package com.thorconsultoria.winthor.sac.domain.application.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =
        { "com.thorconsultoria.winthor.sac.domain.application",
          "com.thorconsultoria.winthor.sac.domain.application.service" })
public class DomainApplicationServiceModule {
}
