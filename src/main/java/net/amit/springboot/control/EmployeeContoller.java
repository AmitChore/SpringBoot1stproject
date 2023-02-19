package net.amit.springboot.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.amit.springboot.model.Employee;
import net.amit.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeContoller {

	
	private EmployeeService employeeService;

	public EmployeeContoller(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
		
	}
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		System.out.println(employee.getFirstName()+employee.getLastName());
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	
	}
	
}
