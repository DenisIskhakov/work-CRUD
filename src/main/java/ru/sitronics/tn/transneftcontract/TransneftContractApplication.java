package ru.sitronics.tn.transneftcontract;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@OpenAPIDefinition
//@EnableWebMvc
@EnableCaching
public class TransneftContractApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransneftContractApplication.class, args);
    }

}
