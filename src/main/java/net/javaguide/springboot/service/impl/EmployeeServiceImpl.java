package net.javaguide.springboot.service.impl;

import org.springframework.stereotype.Service;

import net.javaguide.springboot.model.Employee;
import net.javaguide.springboot.repository.EmployeeRepository;
import net.javaguide.springboot.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService
{

	private final EmployeeRepository employeeRepository;
		
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}




	@Override
	public Employee saveEmployee(Employee employee) {
	
		return employeeRepository.save(employee);
	}

}
