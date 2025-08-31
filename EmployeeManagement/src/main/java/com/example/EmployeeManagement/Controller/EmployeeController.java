package com.example.EmployeeManagement.Controller;

import com.example.EmployeeManagement.Entity.Employee;
import com.example.EmployeeManagement.Mapper.EmployeeMapper;
import com.example.EmployeeManagement.Service.EmployeeService;
import com.example.EmployeeManagement.dto.EmployeeDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        System.out.println("Found employees: " + employees.size());
        return employees.stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Employee e = service.getEmployeeById(id);
        return ResponseEntity.ok(EmployeeMapper.toDTO(e));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO dto) {
        Employee saved = service.createEmployee(EmployeeMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(EmployeeMapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO dto) {
        Employee updated = service.updateEmployee(id, EmployeeMapper.toEntity(dto));
        return ResponseEntity.ok(EmployeeMapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
