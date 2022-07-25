package io.desofme.studentmicroservice.service;

import io.desofme.studentmicroservice.dto.request.StudentRequest;
import io.desofme.studentmicroservice.dto.response.AddressResponse;
import io.desofme.studentmicroservice.dto.response.StudentResponse;
import io.desofme.studentmicroservice.entity.Student;
import io.desofme.studentmicroservice.feignclients.AddressFeignClient;
import io.desofme.studentmicroservice.repo.StudentRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    private final WebClient webClient;
    private final CommonService commonService;
    private final AddressFeignClient addressFeignClient;
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        //AddressResponse addressResponse = getAddressById(student.getAddressId());
        AddressResponse addressResponse = commonService.getAddressById(student.getAddressId());
        StudentResponse studentResponse = modelMapper.map(student, StudentResponse.class);
        studentResponse.setAddressResponse(addressResponse);
        return studentResponse;
    }

    public StudentResponse addStudent(StudentRequest studentRequest) {
        log.info("Student adding to database");
        Student student = modelMapper.map(studentRequest, Student.class);
        StudentResponse studentResponse = modelMapper.map(studentRepo.save(student), StudentResponse.class);
        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
        //studentResponse.setAddressResponse(addressFeignClient.getAddressById(student.getAddressId()));

        return studentResponse;
    }

//    @CircuitBreaker(name = "addressService",fallbackMethod = "fallbackgetAddressById")
//    public AddressResponse getAddressById(Long addressId){
////        Mono<AddressResponse> addressResponseMono = webClient.get()
////                .uri("/"+addressId)
////                .retrieve()
////                .bodyToMono(AddressResponse.class);
////        return addressResponseMono.block();
//        AddressResponse addressResponse = addressFeignClient.getAddressById(addressId);
//        return addressResponse;
//    }
//
//    public AddressResponse fallbackgetAddressById(Long addressId){
//        return new AddressResponse();
//    }
}
