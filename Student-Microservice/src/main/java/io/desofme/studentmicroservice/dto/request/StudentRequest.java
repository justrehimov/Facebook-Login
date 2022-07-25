package io.desofme.studentmicroservice.dto.request;

import lombok.Data;

@Data
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Long addressId;
}
