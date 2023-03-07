package net.amit.springboot;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import net.amit.springboot.model.Employee;
import net.amit.springboot.service.EmployeeService;
//import net.amit.springboot.service.impl.EmployeeServiceImpl;

@ExtendWith(value = {MockitoExtension.class})
@TestInstance(Lifecycle.PER_CLASS)
public class ServiceImplTest3 {
	@Mock
	private EmployeeService employeeService;
	
//	@BeforeAll
//	public void setup() {
//		System.out.println("setup");
//		 MockitoAnnotations.openMocks(this);
		 
//	}
	
	@Test
	public void  testGetEmployeeById() {
		 //employeeService = Mockito.mock(EmployeeService.class);
		 
		// MockitoAnnotations.openMocks(employeeService);
		 
		 Employee employee = getEmployee();
		 when(employeeService.getEmployeeById(1)).thenReturn(employee);
		 System.out.println(employeeService.getEmployeeById(1));
		 assertEquals("Khemesh", employeeService.getEmployeeById(1).getFirstName());
		 assertAll("testGetEmployeeById",()-> assertEquals("Khemesh", employeeService.getEmployeeById(1).getFirstName()),()-> assertEquals("Rathod", employeeService.getEmployeeById(1).getLastName()));
	}
	
	private Employee getEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstName("Khemesh");
		employee.setLastName("Rathod");
		employee.setEmail("khemesh@gmail.com");
		return employee;
	}

	
}
