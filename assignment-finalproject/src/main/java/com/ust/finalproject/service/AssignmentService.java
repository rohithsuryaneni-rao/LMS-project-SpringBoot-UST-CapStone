package com.ust.finalproject.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ust.finalproject.model.Assignment;
import com.ust.finalproject.repository.AssignmentRepository;
@Service
public class AssignmentService 
{
	@Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private RestTemplate restTemplate; 
    public Assignment submitAssignment(Assignment assignment) 
    {
        String enrollmentServiceUrl="http://localhost:8003/enrollment/enrollmentID/";
        List<Integer> isValidEnrollment=restTemplate.getForObject(enrollmentServiceUrl+assignment.getEnrollmentID(), List.class);
        if (isValidEnrollment==null) 
        {
            throw new RuntimeException("Invalid enrollment ID: Student is not enrolled in the course.");
        }
        return assignmentRepository.save(assignment);
    }
}