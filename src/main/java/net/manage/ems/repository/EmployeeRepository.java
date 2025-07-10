package net.manage.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.manage.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{


}
