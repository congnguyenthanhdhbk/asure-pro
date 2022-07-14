package org.asurepro.controllers;

import org.asurepro.models.ERole;
import org.asurepro.payload.response.MessageResponse;
import org.asurepro.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
  private final UserRepository userRepository;

  public StudentController(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping()
  @PreAuthorize("hasRole('STUDENT') or hasRole('MENTOR')")
  public ResponseEntity<?> viewStudents(@RequestParam(name = "role") final String role,
                                        @RequestParam(name = "page", defaultValue = "1") final int page,
                                        @RequestParam(value = "size", defaultValue = "10") final int size) {
    switch (role) {
      case "mentor":
      case "student":
        return ResponseEntity.ok(userRepository.findAll(PageRequest.of(page, size)));
      default:
        return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping()
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> removeUser(final long id) {
    userRepository.deleteById(id);
    return ResponseEntity.ok(new MessageResponse("user have been deleting"));
  }
}
