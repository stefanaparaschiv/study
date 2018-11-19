package managementapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managementapp.builder.EmployeeDTO;
import managementapp.controller.EmployeeController;
import managementapp.exceptions.BusinessException;
import managementapp.model.Employee;
import managementapp.repository.EmployeeRepository;
import managementapp.service.EmployeeService;
import managementapp.util.EmployeeConvertor;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<EmployeeDTO> findByLastName(String lastName) {
		return EmployeeConvertor.convertEmployeeListToEmployeeDTOList(employeeRepository.findByLastName(lastName));
	}

	@Override
	public List<EmployeeDTO> getAll() {
		return EmployeeConvertor.convertEmployeeListToEmployeeDTOList(employeeRepository.findAll());
	}

	@Override
	public List<EmployeeDTO> findByFullName(String firstName, String lastName) {
		return EmployeeConvertor.convertEmployeeListToEmployeeDTOList(employeeRepository.findByFirstNameAndLastName(firstName, lastName));
	}

	@Override
	public List<EmployeeDTO> findByJob(String job) throws BusinessException {
		List<Employee> employees = new ArrayList<Employee>(employeeRepository.findByJob(job));
		if (employees == null || employees.size() == 0) {
			throw new BusinessException("No employees with job" + job + " were found");
		}
		return EmployeeConvertor.convertEmployeeListToEmployeeDTOList(employees);
	}

	@Override
	public EmployeeDTO findById(Long id) throws BusinessException {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (!emp.isPresent()) {
			throw new BusinessException("No employee with id=" + id + " was found");
		}
		return EmployeeConvertor.convertToEmployeeDTO(emp.get());
	}

	@Override
	public EmployeeDTO save(EmployeeDTO empDTO) {
		return EmployeeConvertor.convertToEmployeeDTO(employeeRepository.save(EmployeeConvertor.convertEmployeeDTOToEmployee(empDTO)));
	}

	@Override
	public List<EmployeeDTO> findByFirstName(String firstName) {
		return EmployeeConvertor.convertEmployeeListToEmployeeDTOList(employeeRepository.findByFirstName(firstName));
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
