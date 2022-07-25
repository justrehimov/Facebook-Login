package io.desofme.addressservice.controller;

import io.desofme.addressservice.dto.request.AddressRequest;
import io.desofme.addressservice.dto.response.AddressResponse;
import io.desofme.addressservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public AddressResponse addAddress(@RequestBody AddressRequest addressRequest){
        return addressService.addAddress(addressRequest);
    }

    @GetMapping("/{id}")
    public AddressResponse getAddressById(@PathVariable("id") Long id){
        return addressService.getAddressById(id);
    }

}
