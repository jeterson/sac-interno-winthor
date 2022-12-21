package com.thorconsultoria.winthor.sac.dataaccess.user;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.thorconsultoria.winthor.sac.dataaccess"})
@EntityScan(basePackages = {"com.thorconsultoria.winthor.sac.dataaccess"})
@ComponentScan(basePackages = "com.thorconsultoria.winthor.sac.dataaccess")
public class DataAccessModule {
}
