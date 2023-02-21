package net.amit.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.amit.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByFirstName(String firstName);

}
