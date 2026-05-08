package ar.com.smg.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI(@Value(
            "${app.openapi.server-url:http://localhost:8080}") String serverUrl) {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("SMG Backend-HL7 API")
                                .description("Servicios HL7 para el Sistema de Gestión de "
                                        + "Prestaciones Médicas")
                                .version("1.0.0")
                                .contact(new Contact()
                                        .name("Equipo SMG Backend")
                                        .email("backend@smg.com"))
                                .license(
                                        new License().name("Uso interno").url("https://intranet")))
                .addServersItem(
                        new Server().url(serverUrl).description("Servidor activo"));
    }
}