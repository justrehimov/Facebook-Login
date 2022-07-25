package io.desofme.studentmicroservice.service;

import io.desofme.studentmicroservice.dto.response.AddressResponse;
import io.desofme.studentmicroservice.feignclients.AddressFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonService {

    private final AddressFeignClient addressFeignClient;

    private Logger logger = LoggerFactory.getLogger(CommonService.class);
    long count = 0;

    @CircuitBreaker(name = "addressService",fallbackMethod = "fallbackgetAddressById")
    public AddressResponse getAddressById(Long addressId){
        logger.info("getAddressById method called {} times", ++count);
        AddressResponse addressResponse = addressFeignClient.getAddressById(addressId);
        return addressResponse;
    }

    public AddressResponse fallbackgetAddressById(Long addressId,Throwable th){
        logger.error("Error = {} occured in getAddressById method", th.getMessage());
        return new AddressResponse();
    }
}
