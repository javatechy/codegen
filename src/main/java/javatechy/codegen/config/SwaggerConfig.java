package javatechy.codegen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("javatechy.codegen.controller"))
            .build()
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Deepak Kumar", "", "deepak.kumar@fabhotels.com");

        ApiInfo apiInfo = new ApiInfo("Ticketing Micro Service", "Ticketing Service by Fab", "V1.0", "https://www.fabhotels.com/terms-conditions", contact, "Fabhotels Internal License", "https://www.fabhotels.com/privacy-policy");

        return apiInfo;
    }
}
