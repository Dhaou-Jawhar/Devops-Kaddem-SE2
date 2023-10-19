package tn.esprit.spring.kaddem.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {return new OpenAPI().info(infoAPI());}
    public Info infoAPI() {
        return new Info().title("Dhaou Jawhar 💎").description("Swagger KADDEM 5SE2 📚") .contact(contactAPI());}

    public Contact contactAPI() {
        Contact contact = new Contact().name("Jawhar Contact") .email("jawher.dhaou@esprit.tn").url("https://dhaou-jawhar.github.io");
        return contact;
    }

    @Bean
    public GroupedOpenApi etudiantPublicApi() {
        return GroupedOpenApi.builder().group("Etudiant 👨‍🎓 Management")
                .pathsToMatch("/etudiant/**")
                .pathsToExclude("**")
                .build();}
    @Bean
    public GroupedOpenApi universityPublicApi() {
        return GroupedOpenApi.builder().group("University 🏫 Management")
                .pathsToMatch("/universite/**")
                .pathsToExclude("**")
                .build();}
    @Bean
    public GroupedOpenApi departementPublicApi() {
        return GroupedOpenApi.builder().group("Departement 🏢 Management")
                .pathsToMatch("/departement/**")
                .pathsToExclude("**")
                .build();}
    @Bean
    public GroupedOpenApi contratPublicApi() {
        return GroupedOpenApi.builder().group("Contrat 📝 Management")
                .pathsToMatch("/contrat/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi equipePublicApi() {
        return GroupedOpenApi.builder().group("Equipe 👩‍👩‍👦‍👦 Management")
                .pathsToMatch("/equipe/**")
                .pathsToExclude("**")
                .build();
    }
}
