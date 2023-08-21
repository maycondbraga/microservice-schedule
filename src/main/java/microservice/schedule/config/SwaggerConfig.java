package microservice.schedule.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo(){
        return new Info()
                .title("Patient Scheduling App")
                .description("App for scheduling patient appointments")
                .version("v0.0.1")
                .contact(new Contact().name("Maycon Braga").email("maycondbraga.s@gmail.com").url("https://github.com/maycondbraga"))
                .license(new License().name("MIT License").url("https://github.com/maycondbraga/microservice-schedule/blob/main/LICENSE"));
    }
}
