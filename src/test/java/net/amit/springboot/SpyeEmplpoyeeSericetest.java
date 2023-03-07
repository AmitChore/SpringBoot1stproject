package net.amit.springboot;

import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.SpyBean;

import net.amit.springboot.model.Employee;
import net.amit.springboot.repository.EmployeeRepository;
import net.amit.springboot.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
@TestInstance(value = Lifecycle.PER_CLASS)
public class SpyeEmplpoyeeSericetest {

     @Spy
	 private EmployeeServiceImpl employeeService ;
     
     @SpyBean
     private EmployeeRepository employeeRepository;

     
     @BeforeAll
     public void setup()
     {
    	employeeRepository = mock(EmployeeRepository.class);
    	 MockitoAnnotations.openMocks(this);
     }
 	

	@Test
	public void testGetEmployeeById() {

		Employee employee = employeeService.getEmployeeById(1);
		System.out.println(employee);
	}
}
