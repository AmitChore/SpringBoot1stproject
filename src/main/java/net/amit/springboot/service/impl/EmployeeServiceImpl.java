package net.amit.springboot.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import net.amit.springboot.exception.ResourceNotFoundException;
import net.amit.springboot.model.Employee;
import net.amit.springboot.repository.EmployeeRepository;
import net.amit.springboot.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
		
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
	return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
//	Optional<Employee> employee = employeeRepository.findById(id);
//	if(employee.isPresent()) {
//		return employee.get();	
//	}else {
//		throw new ResourceNotFoundException("Employee", "id", "id");
//	}
	
	return employeeRepository.findById(id).orElseThrow(()-> 
			new ResourceNotFoundException("Employee", "Id", "id"));
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//first check wether employee with given id is present  present in database 
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", "id"));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		// save Existing Employee to database
		employeeRepository.save(existingEmployee);	
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
	//check whether a employee exist n data base or not
	employeeRepository.findById(id).orElseThrow(
			() -> new ResourceNotFoundException("Employee", "Id", "id"));	
		employeeRepository.deleteById(id);
		
	}

	
	
	
}
