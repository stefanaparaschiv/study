package managementapp.service;

import java.util.List;

import managementapp.model.Course;

public interface CourseService {
	
	public List<Course> findDietCorsesBelow(int kalories);

}
