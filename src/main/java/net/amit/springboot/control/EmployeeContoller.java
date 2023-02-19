package net.amit.springboot.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//ctreat employee rest API
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		System.out.println(employee.getFirstName()+employee.getLastName());
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	
	}
	//build get all employees rest api
	
	@GetMapping
	public List<Employee>  getAllEmployee(){
		return employeeService.getAllEmployee(); 
	}
	
	//build get employee by id rest API
	//http://loalhost:8080/api/employees/1
	@GetMapping("{id}")
	public  ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeid){
		
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeid), HttpStatus.OK);
	}
	//build update employee rest api
	//http://loalhost:8080/api/employees/1
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable ("id") long id
																,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	}
	//build delete employee Rest API
	//http://loalhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		//delete employee from data base
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee delete successfully.",HttpStatus.OK);
	}
}
