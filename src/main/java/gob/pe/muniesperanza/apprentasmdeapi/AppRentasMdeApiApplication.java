package gob.pe.muniesperanza.apprentasmdeapi;

import gob.pe.muniesperanza.apprentasmdeapi.service.FileService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AppRentasMdeApiApplication  implements CommandLineRunner {
	@Resource
	FileService storageService;

	public static void main(String[] args) {

		SpringApplication.run(AppRentasMdeApiApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
//    storageService.deleteAll();
		storageService.init();
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("*").allowedOrigins("http://localhost:3000");
//			}
//		};
//	}

}
