package pl.edu.pbs.pai_lect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class PaiLectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaiLectApplication.class, args);
    }

}
