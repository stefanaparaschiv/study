// tag::sample[]
package managementapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Employee.TABLE_NAME)
public class Employee {

	public static final String TABLE_NAME = "EMPLOYEE";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Enumerated(EnumType.STRING)
	@Column(name = "JOB")
	private Job job;

	public Employee() {
	}

	public Employee(String firstName, String lastName, Job job) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
	}

	@Override
	public String toString() {
		return String.format("Employee[id=%d, firstName='%s', lastName='%s', job='%s']", id, firstName, lastName, job);
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
