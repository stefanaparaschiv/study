package managementapp.builder;

public class TimetableDTO {

	private Long id;

	private String name;

	private String openingHours;

	private String closingHours;

	private TimetableDTO() {

	}

	public static class Builder {

		private Long id;

		private String name;

		private String openingHours;

		private String closingHours;

		public Builder(Long id) {
			this.id = id;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withLastName(String openingHours) {
			this.openingHours = openingHours;
			return this;
		}

		public Builder withJob(String closingHours) {
			this.closingHours = closingHours;
			return this;
		}

		public TimetableDTO build() {
			TimetableDTO dto = new TimetableDTO();
			dto.id = this.id;
			dto.name = this.name;
			dto.openingHours = this.openingHours;
			dto.closingHours = this.closingHours;
			return dto;
		}
	}

}
