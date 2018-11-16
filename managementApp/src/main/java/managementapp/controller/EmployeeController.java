package managementapp.controller;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import managementapp.builder.EmployeeDTO;
import managementapp.exceptions.BadRequestException;
import managementapp.exceptions.NotFoundException;
import managementapp.model.Employee;
import managementapp.model.Job;
import managementapp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public List<EmployeeDTO> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("/search")
	public List<EmployeeDTO> getByName(@RequestParam(name = "lastName", required = false) String lastName,
			@RequestParam(name = "firstName", required = false) String firstName) throws NotFoundException {
		List<EmployeeDTO> empList = null;
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
	public EmployeeDTO getById(@PathVariable(value = "id") Long id) throws NotFoundException {
		return employeeService.findById(id);
	}

	@GetMapping("/search/{job}")
	public Collection<EmployeeDTO> getByJob(@PathVariable(value = "job") String job) throws NotFoundException, BadRequestException {
		if (!Job.containsString(job)) {
			throw new BadRequestException("Incorrect value provided for job. Job does not exist.");
		}
		Collection<EmployeeDTO> empList = employeeService.findByJob(job);
		if (empList == null || empList.size() == 0) {
			throw new NotFoundException("No employees with job" + job + " were found");
		}
		return empList;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Employee createEmployee(@RequestBody EmployeeDTO empDTO) {
		return employeeService.save(empDTO);
	}
}
