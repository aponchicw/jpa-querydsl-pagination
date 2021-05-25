package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class CrudJpaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudJpaExampleApplication.class, args);
    }

}
