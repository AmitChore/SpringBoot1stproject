package net.amit.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.amit.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
