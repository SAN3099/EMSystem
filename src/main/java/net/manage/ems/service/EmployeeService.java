package net.manage.ems.service;

import java.util.List;

import net.manage.ems.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    
    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();
}
