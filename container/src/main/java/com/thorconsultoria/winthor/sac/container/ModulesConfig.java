package com.thorconsultoria.winthor.sac.container;

import com.thorconsultoria.winthor.sac.application.ApplicationModule;
import com.thorconsultoria.winthor.sac.dataaccess.DataAccessModule;
import com.thorconsultoria.winthor.sac.domain.application.service.DomainApplicationServiceModule;
import com.thorconsultoria.winthor.sac.security.SecurityModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ApplicationModule.class,
         DataAccessModule.class,
         SecurityModule.class,
         DomainApplicationServiceModule.class})
public class ModulesConfig {
}
