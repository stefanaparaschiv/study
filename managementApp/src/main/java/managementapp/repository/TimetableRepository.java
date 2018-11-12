package managementapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import managementapp.model.Timetable;

public interface TimetableRepository extends CrudRepository<Timetable, Long> {

	public List<Timetable> findByName(String name);
	
}
