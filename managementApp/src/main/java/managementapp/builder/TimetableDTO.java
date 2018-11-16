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

		public Builder withOpeningHours(String openingHours) {
			this.openingHours = openingHours;
			return this;
		}

		public Builder withClosingHours(String closingHours) {
			this.closingHours = closingHours;
			return this;
		}

		public TimetableDTO build() {
			TimetableDTO timetableDTO = new TimetableDTO();
			timetableDTO.id = this.id;
			timetableDTO.name = this.name;
			timetableDTO.openingHours = this.openingHours;
			timetableDTO.closingHours = this.closingHours;
			return timetableDTO;
		}
	}

}
