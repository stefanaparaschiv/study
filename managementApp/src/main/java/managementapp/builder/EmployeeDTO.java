package managementapp.builder;

import managementapp.model.Job;

public class EmployeeDTO {
	
	private Long id;

	private String firstName;

	private String lastName;

	private Job job;
	
	private EmployeeDTO() {
		
	}

	public static class Builder {

		private Long id;

		private String firstName;

		private String lastName;

		private Job job;

		public Builder(Long id) {
            this.id = id;
        }

		public Builder withFirstName(String firstName) {
			this.firstName=firstName;
			return this; 
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withJob(Job job) {
			this.job = job;
			return this;
		}

		public EmployeeDTO build() {
			EmployeeDTO menuDto = new EmployeeDTO(); 
	        menuDto.id=this.id;
	        menuDto.firstName=this.firstName;
	        menuDto.lastName=this.lastName;
	        menuDto.job=this.job;
			return menuDto;
		}
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
