package managementapp.builder;

import java.util.ArrayList;
import java.util.List;

import managementapp.dto.EmployeeDTO;
import managementapp.model.Employee;

public class EmployeeConvertor {

	public static EmployeeDTO convertToEmployeeDTO(Employee emp) {
		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.setId(emp.getId());
		empDTO.setFirstName(emp.getLastName());
		empDTO.setJob(emp.getJob());
		empDTO.setLastName(emp.getLastName());
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
		Employee emp = new Employee(empDTO.getFirstName(), empDTO.getLastName(), empDTO.getJob());
		emp.setId(empDTO.getId());
		return emp;
	}
	
}
