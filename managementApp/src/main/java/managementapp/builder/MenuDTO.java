package managementapp.builder;

import java.util.List;

import managementapp.model.Course;
import managementapp.model.Type;

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
			MenuDTO dto = new MenuDTO();
			dto.id = this.id;
			dto.name = this.name;
			dto.price = this.price;
			dto.type = this.type;
			dto.courses = this.courses;
			return dto;
		}
	}
}
