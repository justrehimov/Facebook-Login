package io.desofme.studentmicroservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonProperty("address")
    private AddressResponse addressResponse;
}
