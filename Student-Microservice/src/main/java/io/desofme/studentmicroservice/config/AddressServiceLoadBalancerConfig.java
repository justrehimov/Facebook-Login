//package io.desofme.studentmicroservice.config;
//
//import feign.Feign;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//
//
//@LoadBalancerClient(value = "ADDRESS-SERVICE")
//public class AddressServiceLoadBalancerConfig {
//
//    @LoadBalanced
//    @Bean
//    public Feign.Builder feignBuilder () {
//        return Feign.builder();
//    }
//
//}
/* Api Gateway will do load balancing for us */