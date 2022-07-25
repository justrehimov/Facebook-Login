package io.desofme.studentmicroservice.feignclients;

import io.desofme.studentmicroservice.dto.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "API-GATEWAY")
public interface AddressFeignClient {

    @GetMapping("/ADDRESS-SERVICE/api/address/{id}")
    AddressResponse getAddressById(@PathVariable("id") Long id);

}
