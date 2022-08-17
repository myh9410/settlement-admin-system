package system.admin.settlement.config.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Profile("!test")
@EnableJpaAuditing
@Configuration
@RequiredArgsConstructor
public class DataSourceConfiguration {

}
