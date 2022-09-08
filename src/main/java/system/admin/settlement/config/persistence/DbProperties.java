package system.admin.settlement.config.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.InvalidPropertiesFormatException;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.datasource.settlement")
public class DbProperties {
    private String hostname;
    private String username;
    private String password;

    private final String dbname = "settlement";
    private final int port = 3306;
    private final String zoneId = "Asia/Seoul";
    private final String characterEncoding = "UTF-8";
    private final String zeroDateTimeBehavior = "convertToNull";
    private JpaProperties jpaProperties;

    public String getConnectionString() throws InvalidPropertiesFormatException {
        if (!isValid()) {
            throw new InvalidPropertiesFormatException(
                    this.toString()
            );
        }

        StringBuilder connectionStringBuilder = new StringBuilder();

        connectionStringBuilder
                .append("jdbc:mysql://")
                .append(hostname)
                .append(":").append(port)
                .append("/").append(dbname)
                .append("?")
                .append("serverTimezone=").append(zoneId)
                .append("&characterEncoding=").append(characterEncoding)
                .append("&zeroDateTimeBehavior=").append(zeroDateTimeBehavior);

        return connectionStringBuilder.toString();
    }

    public boolean isValid() {
        if (hostname.isBlank() || hostname == null) {
            return false;
        }

        if (username.isBlank() || username == null) {
            return false;
        }

        if (password.isBlank() || password == null) {
            return false;
        }

        return true;
    }

}
