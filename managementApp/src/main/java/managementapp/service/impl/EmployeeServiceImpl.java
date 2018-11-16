package managementapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managementapp.builder.EmployeeDTO;
import managementapp.exceptions.BusinessException;
import managementapp.model.Employee;
import managementapp.repository.EmployeeRepository;
import managementapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<EmployeeDTO> findByLastName(String lastName) {
		return convertEmployeeListToEmployeeDTOList(employeeRepository.findByLastName(lastName));
	}

	@Override
	public List<EmployeeDTO> getAll() {
		return convertEmployeeListToEmployeeDTOList(employeeRepository.findAll());
	}

	@Override
	public List<EmployeeDTO> findByFullName(String firstName, String lastName) {
		return convertEmployeeListToEmployeeDTOList(employeeRepository.findByFirstNameAndLastName(firstName, lastName));
	}

	@Override
	public List<EmployeeDTO> findByJob(String job) throws BusinessException {
		List<Employee> employees = new ArrayList<Employee>(employeeRepository.findByJob(job));
		if (employees == null || employees.size() == 0) {
			throw new BusinessException("No employees with job" + job + " were found");
		}
		return convertEmployeeListToEmployeeDTOList(employees);
	}

	@Override
	public EmployeeDTO findById(Long id) throws BusinessException {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (!emp.isPresent()) {
			throw new BusinessException("No employee with id=" + id + " was found");
		}
		return convertToEmployeeDTO(emp.get());
	}

	@Override
	public Employee save(EmployeeDTO empDTO) {
		return employeeRepository.save(convertEmployeeDTOToEmployee(empDTO));
	}

	@Override
	public List<EmployeeDTO> findByFirstName(String firstName) {
		return convertEmployeeListToEmployeeDTOList(employeeRepository.findByFirstName(firstName));
	}

	private EmployeeDTO convertToEmployeeDTO(Employee emp) {
		EmployeeDTO empDTO = new EmployeeDTO.Builder(emp.getId()).withFirstName(emp.getFirstName())
				.withLastName(emp.getLastName()).withJob(emp.getJob()).build();
		return empDTO;
	}

	private List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(Iterable<Employee> employees) {
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		for (Employee emp : employees) {
			employeeDTOs.add(convertToEmployeeDTO(emp));
		}
		return employeeDTOs;
	}

	private Employee convertEmployeeDTOToEmployee(EmployeeDTO empDTO) {
		return new Employee(empDTO.getId(), empDTO.getFirstName(), empDTO.getLastName(), empDTO.getJob());
	}

	@Override
	public List<EmployeeDTO> findByName(String firstName, String lastName) throws BusinessException {
		List<EmployeeDTO> empList = null;
		if (firstName == null && lastName != null) {
			empList = this.findByLastName(lastName);
		} else if (lastName == null && firstName != null) {
			empList = this.findByFirstName(firstName);
		} else if (firstName != null && lastName != null) {
			empList = this.findByFullName(firstName, lastName);
		}
		if (empList == null || empList.size() == 0) {
			throw new BusinessException("No employees were found");
		}
		return empList;
	}

}
