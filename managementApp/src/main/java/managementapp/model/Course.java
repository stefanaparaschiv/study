package managementapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Course.TABLE_NAME)
public class Course {

	public static final String TABLE_NAME = "COURSE";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String courseName;

	@Column(name = "KALORIES")
	private int kalories;

	public Course(String courseName, int kalories) {
		super();
		this.courseName = courseName;
		this.kalories = kalories;
	}
	
	public Course()
	{
		super();
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getKalories() {
		return kalories;
	}

	public void setKalories(int kalories) {
		this.kalories = kalories;
	}

}
