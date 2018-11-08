package managementapp.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import managementapp.exceptions.NotFoundException;
import managementapp.model.Employee;
import managementapp.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public Iterable<Employee> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("/employee")
	public List<Employee> getByLastName(@RequestParam(name = "lastName", required = true) String lastName)
			throws NotFoundException {
		List<Employee> empList = employeeService.findByLastName(lastName);
		if (empList == null || empList.size() == 0) {
			throw new NotFoundException("No employees with last name=" + lastName + " were found");
		}
		return empList;
	}

	@GetMapping("/employee/name")
	public List<Employee> getByFullName(@RequestParam(name = "lastName", required = true) String lastName,
			@RequestParam(name = "firstName", required = true) String firstName) throws NotFoundException {
		List<Employee> empList = employeeService.findByFullName(firstName, lastName);
		if (empList == null || empList.size() == 0) {
			throw new NotFoundException("No employees with name=" + firstName +""+ lastName + " were found");
		}
		return empList;
	}

	@GetMapping("/employee/{id}")
	public Optional<Employee> getById(@PathVariable(value = "id") Long id) throws NotFoundException {
		Optional<Employee> emp = employeeService.findById(id);
		if (!emp.isPresent()) {
			throw new NotFoundException("No employee with id=" + id + " was found");
		}
		return emp;
	}

	@GetMapping("/employees/{job}")
	public Collection<Employee> getByJob(@PathVariable(value = "job") String job) throws NotFoundException {
		Collection<Employee> empList = employeeService.findByJob(job);
		if (empList == null || empList.size() == 0) {
			throw new NotFoundException("No employees with job" + job + " were found");
		}
		return empList;
	}
	
}
