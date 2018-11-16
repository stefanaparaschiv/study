package managementapp.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import managementapp.builder.EmployeeDTO;
import managementapp.exceptions.NotFoundException;
import managementapp.model.Employee;
import managementapp.model.Job;


public interface EmployeeService {

	public List<EmployeeDTO> findByLastName(String lastName);

	public List<EmployeeDTO> getAll();

	public List<EmployeeDTO> findByFullName(String firstName,String lastName);

	public EmployeeDTO findById(Long id) throws NotFoundException;

	public Collection<EmployeeDTO> findByJob(String job);

	public Employee save(EmployeeDTO empDTO);

	public List<EmployeeDTO> findByFirstName(String firstName);

}
