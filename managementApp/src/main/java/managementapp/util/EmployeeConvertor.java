package managementapp.util;

import java.util.ArrayList;
import java.util.List;

import managementapp.builder.EmployeeDTO;
import managementapp.model.Employee;

public class EmployeeConvertor {

	public static EmployeeDTO convertToEmployeeDTO(Employee emp) {
		EmployeeDTO empDTO = new EmployeeDTO.Builder(emp.getId()).withFirstName(emp.getFirstName())
				.withLastName(emp.getLastName()).withJob(emp.getJob()).build();
		return empDTO;
	}

	public static List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(Iterable<Employee> employees) {
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		for (Employee emp : employees) {
			employeeDTOs.add(convertToEmployeeDTO(emp));
		}
		return employeeDTOs;
	}

	public static Employee convertEmployeeDTOToEmployee(EmployeeDTO empDTO) {
		return new Employee(empDTO.getId(), empDTO.getFirstName(), empDTO.getLastName(), empDTO.getJob());
	}
	
}
