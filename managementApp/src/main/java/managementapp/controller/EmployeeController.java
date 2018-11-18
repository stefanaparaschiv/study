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
import managementapp.exceptions.BusinessException;
import managementapp.exceptions.ValidationException;
import managementapp.model.Employee;
import managementapp.service.EmployeeService;
import managemntApp.util.Validator;

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
		LOGGER.info("Getting all employees");
		return employeeService.getAll();
	}

	@GetMapping("/search")
	public List<EmployeeDTO> getByName(@RequestParam(name = "lastName", required = false) String lastName,
			@RequestParam(name = "firstName", required = false) String firstName) throws BusinessException {
		LOGGER.info("Search employee with last name {} and first name {}", lastName, firstName);
		return employeeService.findByName(firstName,lastName);
	}

	@GetMapping("/{id}")
	public EmployeeDTO getById(@PathVariable(value = "id") Long id) throws BusinessException {
		LOGGER.info("Search employee with id {}", id);
		return employeeService.findById(id);
	}

	@GetMapping("/search/{job}")
	public Collection<EmployeeDTO> getByJob(@PathVariable(value = "job") String job) throws BusinessException, ValidationException {
		LOGGER.info("Search employees with job {}", job);
		Validator.validateJob(job);
		return employeeService.findByJob(job);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Employee createEmployee(@RequestBody EmployeeDTO empDTO) {
		LOGGER.info("Create employee");
		return employeeService.save(empDTO);
	}
}
