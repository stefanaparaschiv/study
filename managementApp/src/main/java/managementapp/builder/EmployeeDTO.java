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
			EmployeeDTO dto = new EmployeeDTO(); 
	        dto.id=this.id;
	        dto.firstName=this.firstName;
	        dto.lastName=this.lastName;
	        dto.job=this.job;
			return dto;
		}
	}

}
