package system.admin.settlement.config.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.InvalidPropertiesFormatException;

@Profile("!test")
@EnableJpaAuditing
@Configuration
@RequiredArgsConstructor
public class DataSourceConfiguration {
    private final static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private final static String PACKAGE = "system.admin.settlement";

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean managerFactoryBean (
            DbProperties dbProperties,
            @Qualifier("dataSource") DataSource dataSource
    ) {
        EntityManagerFactoryBuilder builder = new EntityManagerFactoryBuilder(
                new HibernateJpaVendorAdapter(),
                dbProperties.getJpaProperties().getProperties(),
                null
        );

        return builder
                .dataSource(dataSource)
                .properties(dbProperties.getJpaProperties().getProperties())
                .persistenceUnit("managerFactoryBean")
                .packages(PACKAGE)
                .build();
    }

    @Bean
    public DataSource dataSource(
            DbProperties dbProperties,
            JpaProperties jpaProperties
    ) throws InvalidPropertiesFormatException {

        dbProperties = getDbProperties(dbProperties, jpaProperties);


        return DataSourceBuilder
                .create()
                .url(dbProperties.getConnectionString())
                .username(dbProperties.getUsername())
                .password(dbProperties.getPassword())
                .driverClassName(DRIVER_CLASS_NAME)
                .build();
    }

    private DbProperties getDbProperties(DbProperties dbProperties, JpaProperties jpaProperties) {
        dbProperties.setJpaProperties(jpaProperties);

        return dbProperties;
    }


}
