package io.desofme.addressservice.dto.request;

import lombok.Data;

@Data
public class AddressRequest {
    private String street;
    private String city;
}
