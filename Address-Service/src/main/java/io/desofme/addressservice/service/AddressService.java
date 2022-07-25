package io.desofme.addressservice.service;

import io.desofme.addressservice.dto.request.AddressRequest;
import io.desofme.addressservice.dto.response.AddressResponse;
import io.desofme.addressservice.entity.Address;
import io.desofme.addressservice.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    public AddressResponse addAddress(AddressRequest addressRequest) {
        log.info("Adding address to database");
        Address address = modelMapper.map(addressRequest, Address.class);
        return modelMapper.map(addressRepo.save(address), AddressResponse.class);
    }

    public AddressResponse getAddressById(Long id) {
        log.info("Pulling address from database id:{}",id);
        Address address = addressRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(address, AddressResponse.class);
    }
}
