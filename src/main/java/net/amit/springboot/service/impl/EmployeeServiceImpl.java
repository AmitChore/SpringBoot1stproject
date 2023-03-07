package net.amit.springboot.service.impl;

//import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
///import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.amit.springboot.exception.ResourceAlreadyExistException;
import net.amit.springboot.exception.ResourceNotFoundException;
import net.amit.springboot.model.Employee;
import net.amit.springboot.repository.EmployeeRepository;
import net.amit.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

//	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//		super();
//		this.employeeRepository = employeeRepository;
//
//	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Optional<Employee> savedEmployee = employeeRepository.findById(employee.getId());
        if(savedEmployee.isPresent()){
            throw new ResourceAlreadyExistException("id" );
        }
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {

System.out.println("Actual method");
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
System.out.println("Actual method");
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", "id"));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// first check wether employee with given id is present present in database
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", "id"));

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		// save Existing Employee to database
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// check whether a employee exist n data base or not
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", "id"));
		employeeRepository.deleteById(id);

	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		// System.out.println(employeeRepository.findByFirstName(firstName));
		return employeeRepository.findByFirstName(firstName);

	}

}
