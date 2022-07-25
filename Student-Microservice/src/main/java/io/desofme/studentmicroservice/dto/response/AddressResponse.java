package io.desofme.studentmicroservice.dto.response;

import lombok.Data;

@Data
public class AddressResponse {
    private Long id;
    private String street;
    private String city;
}
