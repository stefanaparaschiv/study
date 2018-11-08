package managementapp.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import managementapp.model.Employee;
import managementapp.model.util.Job;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

	List<Employee> findByLastName(String lastName);

	@Query(value = "SELECT * FROM EMPLOYEE e WHERE UPPER(e.job) = :job", nativeQuery = true)
	Collection<Employee> findByJob(String job);
}
