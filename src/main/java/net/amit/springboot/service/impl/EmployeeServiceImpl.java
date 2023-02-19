package net.amit.springboot.service.impl;

import org.springframework.stereotype.Service;

import net.amit.springboot.model.Employee;
import net.amit.springboot.repository.EmployeeRepository;
import net.amit.springboot.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
		System.out.println(employeeRepository);
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
