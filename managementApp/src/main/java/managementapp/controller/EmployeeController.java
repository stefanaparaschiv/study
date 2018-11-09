package managementapp.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import managementapp.exceptions.BadRequestException;
import managementapp.exceptions.NotFoundException;
import managementapp.model.Employee;
import managementapp.model.Job;
import managementapp.model.Type;
import managementapp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public Iterable<Employee> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("/search")
	public List<Employee> getByName(@RequestParam(name = "lastName", required = false) String lastName,
			@RequestParam(name = "firstName", required = false) String firstName) throws NotFoundException {
		List<Employee> empList = null;
		if (firstName == null && lastName != null) {
			empList = employeeService.findByLastName(lastName);
		} else if (lastName == null && firstName != null) {
			empList = employeeService.findByFirstName(firstName);
		} else if (firstName != null && lastName != null) {
			empList = employeeService.findByFullName(firstName, lastName);
		}
		if (empList == null || empList.size() == 0) {
			throw new NotFoundException("No employees were found");
		}
		return empList;
	}

	@GetMapping("/{id}")
	public Optional<Employee> getById(@PathVariable(value = "id") Long id) throws NotFoundException {
		Optional<Employee> emp = employeeService.findById(id);
		if (!emp.isPresent()) {
			throw new NotFoundException("No employee with id=" + id + " was found");
		}
		return emp;
	}

	@GetMapping("/search/{job}")
	public Collection<Employee> getByJob(@PathVariable(value = "job") String job) throws NotFoundException, BadRequestException {
		if (!Job.containsString(job)) {
			throw new BadRequestException("Incorrect value provided for job. Job does not exist.");
		}
		Collection<Employee> empList = employeeService.findByJob(job);
		if (empList == null || empList.size() == 0) {
			throw new NotFoundException("No employees with job" + job + " were found");
		}
		return empList;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Employee createEmployee(@RequestBody Employee emp) {
		return employeeService.create(emp);
	}
}
