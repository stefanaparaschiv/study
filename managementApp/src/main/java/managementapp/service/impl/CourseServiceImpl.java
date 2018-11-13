package managementapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import managementapp.model.Course;
import managementapp.repository.CourseRepository;
import managementapp.service.CourseService;

public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;

	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public List<Course> findDietCorsesBelow(int kalories) {
		return courseRepository.findDietCourses(kalories);
	}

}
