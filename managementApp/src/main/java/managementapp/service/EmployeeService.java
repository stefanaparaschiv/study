package managementapp.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import managementapp.model.Employee;
import managementapp.model.Job;


public interface EmployeeService {

	public List<Employee> findByLastName(String lastName);

	public Iterable<Employee> getAll();

	public List<Employee> findByFullName(String firstName,String lastName);

	public Optional<Employee> findById(Long id);

	public Collection<Employee> findByJob(String job);

}
