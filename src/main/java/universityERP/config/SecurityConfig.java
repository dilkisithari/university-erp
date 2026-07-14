package universityERP.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final List<String> allowedOrigins;

    public SecurityConfig(
            @Value("${app.cors.allowed-origins:http://localhost:5500,http://127.0.0.1:5500,http://localhost:3000,http://127.0.0.1:3000,http://localhost:63342,http://127.0.0.1:63342,https://brave-stone-0d138c700.7.azurestaticapps.net}")
                    String allowedOriginsCsv) {
        this.allowedOrigins =
                Arrays.stream(allowedOriginsCsv.split(","))
                        .map(String::trim)
                        .filter(origin -> !origin.isEmpty())
                        .toList();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Team already disables CSRF for development. Keep that so session-cookie
        // fetch() login/logout from the plain HTML frontend are not rejected with 403.
        http
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()   // Allow all for development
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(allowedOrigins);
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", config);
        return source;
    }
}
