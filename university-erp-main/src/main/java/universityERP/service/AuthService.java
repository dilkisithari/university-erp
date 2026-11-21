package universityERP.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public static final String SESSION_AUTHENTICATED = "UNI_ERP_AUTHENTICATED";
    public static final String SESSION_USERNAME = "UNI_ERP_USERNAME";

    private final String configuredUsername;
    private final String configuredPassword;

    public AuthService(
            @Value("${app.auth.username:admin}") String configuredUsername,
            @Value("${app.auth.password:admin123}") String configuredPassword) {
        this.configuredUsername = configuredUsername;
        this.configuredPassword = configuredPassword;
    }

    public boolean credentialsMatch(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return configuredUsername.equals(username.trim()) && configuredPassword.equals(password);
    }
}
