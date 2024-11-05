package com.ust.finalproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ust.finalproject.model.Assignment;
import com.ust.finalproject.service.AssignmentService;
@RestController
@RequestMapping("/assignment")
public class AssignmentController 
{
	@Autowired
    private AssignmentService assignmentService; 
	@PostMapping("/submit")
    public ResponseEntity<Assignment> submitAssignment(@RequestBody Assignment assignment) 
	{
        Assignment savedAssignment = assignmentService.submitAssignment(assignment);
        return ResponseEntity.ok(savedAssignment);
    }
}