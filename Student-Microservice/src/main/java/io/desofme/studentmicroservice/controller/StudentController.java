package io.desofme.studentmicroservice.controller;

import io.desofme.studentmicroservice.dto.request.StudentRequest;
import io.desofme.studentmicroservice.dto.response.StudentResponse;
import io.desofme.studentmicroservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentResponse addStudent(@RequestBody StudentRequest studentRequest){
        return studentService.addStudent(studentRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }
}
