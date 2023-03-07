package net.amit.springboot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import net.amit.springboot.model.Employee;
import net.amit.springboot.repository.EmployeeRepository;
import net.amit.springboot.service.impl.EmployeeServiceImpl;



@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootElevenApplicationTests {
	

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Test
	public void getAllEmployeeTest()
	{
		System.out.println("asd");
		
		
	
	}
	

	@Test
	public void saveEmployeeTest()
	{
		assertEquals(employeeRepository, employeeRepository);
		
		
	
	}
	
	

	@Test
	void contextLoads() {
	}

}
