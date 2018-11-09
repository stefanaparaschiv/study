package managementapp.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managementapp.model.Employee;
import managementapp.model.Job;
import managementapp.repository.EmployeeRepository;
import managementapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
       this.employeeRepository=employeeRepository;
    }

	@Override
	public List<Employee> findByLastName(String lastName) {
		return employeeRepository.findByLastName(lastName);
	}

	@Override
	public Iterable<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> findByFullName(String firstName,String lastName) {
		return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public Collection<Employee> findByJob(String job) {
		return employeeRepository.findByJob(job);
	}

	@Override
	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee create(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> findByFirstName(String lastName) {
		return employeeRepository.findByFirstName(lastName);
	}

}
