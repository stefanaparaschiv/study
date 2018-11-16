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
@Table(name = Timetable.TABLE_NAME)
public class Timetable {

		public static final String TABLE_NAME = "TIMETABLE";
		
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name="NAME")
	    private String name;
	    
		@Column(name = "OPENING_HOURS")
	    private String openingHours;
		
		@Column(name = "CLOSING_HOURS")
	    private String closingHours;
		
		public Timetable() {
			super();
		}

		public Timetable(String openingHours, String closingHours, String name) {
			super();
			this.openingHours = openingHours;
			this.closingHours = closingHours;	
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		
		
}