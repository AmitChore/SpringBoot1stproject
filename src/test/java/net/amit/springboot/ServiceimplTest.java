package net.amit.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.amit.springboot.model.Employee;
import net.amit.springboot.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
public class ServiceimplTest {
	public long i;
	
	@Mock
	private EmployeeService employeeService;

	Logger logger = LoggerFactory.getLogger(ServiceimplTest.class);
//
//	@BeforeEach
//	public void setup() {
//		//MockitoAnnotations.openMocks(this);
	//or	
	// employeeService = mock(EmployeeService.class);
//	}

	@Test
	@DisplayName(value = "Employee Service Test for getting All Employee  ")
	public void testGetAllEmployee() {		
		List<Employee> employees = getEmployee();
		when(employeeService.getAllEmployee()).thenReturn(employees);
		logger.info(employeeService.getAllEmployee().toString());
		assertEquals(2, employees.size());
	}

	@Test
	@DisplayName(value = "Employee Service Test for gettin Employee by id ")
	public void testGetEmployeeById() {
		i =2;
		List<Employee> employees = getEmployee();
		when(employeeService.getEmployeeById(i)).thenReturn(employees.get((int)i-1));
		logger.info(employeeService.getEmployeeById(i).toString());
		assertEquals("Khemesh", employeeService.getEmployeeById(i).getFirstName());
	}

	@Test
	@DisplayName(value = "Employee Service Test for update Employee by id ")
	public void testUpdateEmployeeById() {
		i=1;
		List<Employee> employees = getEmployee();
		when(employeeService.getEmployeeById(i)).thenReturn(employees.get((int)i-1));
		Employee existingEmployee = employeeService.getEmployeeById(i);
		existingEmployee.setId(i);
		existingEmployee.setFirstName("Amit");
		existingEmployee.setLastName("Chore");
		existingEmployee.setEmail("amitchore@gmail.com");
		System.out.println(existingEmployee);
		employees.add((int)i-1, existingEmployee);
		System.out.println(employees);
		assertEquals("Amit", existingEmployee.getFirstName());

	}
	
	@Test
	@DisplayName(value = "Employee Service Test for delete Employee by id ")
	public void testDeleteById() {
		i = 2;
		List <Employee> employees = getEmployee();
		int originalSize = employees.size();
		employees.remove((int) i-1);
	//	when(employeeService.getEmployeeById(i)).thenReturn(employees.remove((int) i-1));
		logger.info(employees.toString());
		assertEquals(originalSize-1, employees.size());
		//return employees;
	}
	
	
	

	private List<Employee> getEmployee() {
		ArrayList<Employee> employees = new ArrayList<>();
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setFirstName("Khemesh");
		employee1.setLastName("Rathod");
		employee1.setEmail("khemesh@gmail.com");
		logger.info("Adding new Employee" + employee1);
		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setFirstName("Ramesh");
		employee2.setLastName("Dandore");
		employee2.setEmail("Ramesh@gmail.com");
		logger.info("Adding new Employee" + employee2);
//		saveEmployee();
		employees.add(employee1);
		employees.add(employee2);
		return employees;
	}

	
}
