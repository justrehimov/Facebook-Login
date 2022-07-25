package io.desofme.studentmicroservice;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class StudentMicroserviceApplication {

    @Value("${address.service.url}")
    private String addressServiceUrl;

    public static void main(String[] args) {
        SpringApplication.run(StudentMicroserviceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl(addressServiceUrl)
                .build();
    }

}
