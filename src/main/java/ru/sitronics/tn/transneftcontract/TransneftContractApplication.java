package ru.sitronics.tn.transneftcontract;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
//@EnableWebMvc
public class TransneftContractApplication {

    public static void main(String[] args) {

        SpringApplication.run(TransneftContractApplication.class, args);
    }

}
