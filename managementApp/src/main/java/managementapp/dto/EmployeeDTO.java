package managementapp.dto;

import org.springframework.stereotype.Component;

import managementapp.model.Job;

@Component
public class EmployeeDTO {

	private Long id;

	private String firstName;

	private String lastName;

	private Job job;

	public EmployeeDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}
