package managementapp.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import managementapp.model.Course;


public interface CourseRepository extends CrudRepository<Course, Long> {
	
	@Query(value = "SELECT * FROM COURSE c WHERE c.kalories <= :limit", nativeQuery = true)
	List<Course> findDietCourses(int limit);

}
