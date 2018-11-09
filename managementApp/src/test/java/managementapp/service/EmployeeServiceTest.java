package managementapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import managementapp.model.Employee;
import managementapp.model.Job;
import managementapp.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:test-service-context.xml")
public class EmployeeServiceTest {

	 @MockBean
	 private EmployeeRepository employeeRepository;
	 
	 @Autowired
	 private EmployeeService employeeService;

	 @Test
	 public void testFindByJob()
	 {
		 Collection<Employee> employees=new ArrayList<Employee>();
		 employees.add(new Employee("John", "Doe", Job.VENDOR));
		 Mockito.when(employeeRepository.findByJob(ArgumentMatchers.anyString())).thenReturn(employees);
		 Collection<Employee> results = employeeService.findByJob("VENDOR");
		 assertEquals(results.size(),1);
		 assertTrue(results.equals(employees));
	 }
	 
}
