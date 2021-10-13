package com.neo.saving.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
   @Value("${info.build.version:1.0.0}")
   private String buildVersion;

   @Bean
   public Docket documentation() {
      return new Docket(DocumentationType.SWAGGER_2)
              .select()
              .apis(RequestHandlerSelectors.basePackage("com.neo.saving"))
              .build()
              .pathMapping("/")
              .apiInfo(metadata());
   }

   private ApiInfo metadata() {
      return new ApiInfoBuilder()
              .title("API documentation")
              .description("Use this documentation as a reference how to interact with API")
              .version(buildVersion)
              .build();
   }

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {

      registry
              .addResourceHandler("swagger-ui.html")
              .addResourceLocations("classpath:/META-INF/resources/");

      registry
              .addResourceHandler("/webjars/**")
              .addResourceLocations("classpath:/META-INF/resources/webjars/");
   }

}
