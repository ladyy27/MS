package tesis.MatriculasMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableEurekaClient
//@EnableWebMvc
@SpringBootApplication
@EnableDiscoveryClient
public class MatriculasMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatriculasMsApplication.class, args);
    }

}


