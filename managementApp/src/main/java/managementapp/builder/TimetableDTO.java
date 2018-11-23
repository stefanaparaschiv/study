package managementapp.builder;

import org.springframework.stereotype.Component;

@Component
public class TimetableDTO {

	private Long id;

	private String name;

	private String openingHours;

	private String closingHours;

	private TimetableDTO() {
		super();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getClosingHours() {
		return closingHours;
	}

	public void setClosingHours(String closingHours) {
		this.closingHours = closingHours;
	}
	
	

}
