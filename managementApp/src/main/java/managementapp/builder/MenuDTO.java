package managementapp.builder;

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

	private MenuDTO() {

	}

	public static class Builder {

		private Long id;

		private String name;

		private Integer price;

		private Type type;

		private List<Course> courses;

		public Builder(Long id) {
			this.id = id;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withType(Type type) {
			this.type = type;
			return this;
		}

		public Builder withPrice(Integer price) {
			this.price = price;
			return this;
		}

		public Builder withCourses(List<Course> courses) {
			this.courses = courses;
			return this;
		}

		public MenuDTO build() {
			MenuDTO menuDto = new MenuDTO();
			menuDto.id = this.id;
			menuDto.name = this.name;
			menuDto.price = this.price;
			menuDto.type = this.type;
			menuDto.courses = this.courses;
			return menuDto;
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
