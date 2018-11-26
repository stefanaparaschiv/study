package managementapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Menu.TABLE_NAME)
public class Menu {

	public static final String TABLE_NAME = "MENU";
	
	public Menu(String name, Integer price, Type type) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public Menu(String name, Integer price, Type type, List<Course> courses) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.courses = courses;
	}
	
	public Menu() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private Integer price;

	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	private Type type;

	@OneToMany(cascade=CascadeType.ALL)
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
