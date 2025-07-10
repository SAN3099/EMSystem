package net.manage.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.manage.ems.dto.EmployeeDto;
import net.manage.ems.entity.Employee;
import net.manage.ems.exception.ResourceNotFoundException;
import net.manage.ems.mapper.EmployeeMapper;
import net.manage.ems.repository.EmployeeRepository;
import net.manage.ems.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(()-> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
                
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());

    }
}
