package br.com.izifinance.izianalyse.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.izifinance.izianalyse.model.User;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.izifinance.izianalyse"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(apInfo())
				
				.ignoredParameterTypes(User.class)
				.globalOperationParameters(
					Arrays.asList(new ParameterBuilder()
							.name("Authorization")
							.description("Header para facilitar o envio de Authorization Bearer")
							.modelRef(new ModelRef("string"))
							.parameterType("header")
							.required(false)
							.build()));
				
				
			
	}
	
	private ApiInfo apInfo() {
		Contact contato = new Contact("IziFinance", "https://izifinance.com/", "thiagoconsultor1@gmail.com");
		return new ApiInfoBuilder()
				.title("IziAnalyze - Api para analise de cadastros ao  IziBank")
				.description("interactive user api documentation")
				.version("BETA")
				.contact(contato)
				.build();
	}
}
