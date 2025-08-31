package com.example.EmployeeManagement.Mapper;

import com.example.EmployeeManagement.Entity.Employee;
import com.example.EmployeeManagement.dto.EmployeeDTO;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeDTO dto) {
        if (dto == null) return null;
        Employee e = new Employee();
        e.setId(dto.getId());
        e.setFirstName(dto.getFirstName());
        e.setLastName(dto.getLastName());
        e.setEmail(dto.getEmail());
        e.setDepartment(dto.getDepartment());
        e.setSalary(dto.getSalary());
        e.setHireDate(dto.getHireDate());
        return e;
    }

    public static EmployeeDTO toDTO(Employee entity) {
        if (entity == null) return null;
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setDepartment(entity.getDepartment());
        dto.setSalary(entity.getSalary());
        dto.setHireDate(entity.getHireDate());
        return dto;
    }
}
