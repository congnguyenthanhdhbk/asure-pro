package org.asurepro.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
  @GetMapping()
  @PreAuthorize("hasRole('STUDENT') or hasRole('MENTOR') or hasRole('ADMIN')")
  public String viewStudents() {
    return "views Content.";
  }

  @PostMapping()
  @PreAuthorize("hasRole('ADMIN')")
  public String addStudent() {
    return "add student";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
