package net.amit.springboot;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import net.amit.springboot.model.Employee;
import net.amit.springboot.service.EmployeeService;

@ExtendWith(value = {MockitoExtension.class})
@TestInstance(value = Lifecycle.PER_CLASS)
public class ServiceimplTest2 {

	@Mock
	private EmployeeService employeeService;
	
//	@BeforeAll
//	public  void setup() {
//		MockitoAnnotations.openMocks(this);
//	}
//	
	
	
	@Test
  public void getEmployeeById() {
		// employeeService = mock(EmployeeService.class);
		//MockitoAnnotations.openMocks(this);
	
		Employee employee = getEmployee();
		when(employeeService.getEmployeeById(1)).thenReturn(employee);
	//	System.out.println(employeeService.getEmployeeById(1).toString());
		assertEquals("Khemesh",employeeService.getEmployeeById(1).getFirstName() );
		//assertSame(employee.getEmail(), employee);
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
