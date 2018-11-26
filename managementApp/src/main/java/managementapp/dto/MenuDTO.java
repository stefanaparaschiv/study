package managementapp.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import managementapp.model.Course;
import managementapp.model.Type;

@Component
public class MenuDTO {

	private Long id;

	private String name;

	private Integer price;

	private Type type;

	private List<Course> courses;

	public MenuDTO() {
		super();
	}
	
	public MenuDTO(MenuDTO menu) {
		super();
		id=menu.id;
		name=menu.name;
		price=menu.price;
		type=menu.type;
		courses=menu.courses;
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	

}
