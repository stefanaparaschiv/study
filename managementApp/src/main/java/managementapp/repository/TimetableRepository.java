package managementapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import managementapp.model.Timetable;

public interface TimetableRepository extends CrudRepository<Timetable, Long> {

	public List<Timetable> findByName(String name);

	@Query(value = "SELECT * FROM Timetable t WHERE CAST(LEFT(t.CLOSING_HOURS, 2) AS INT) >=:hour", nativeQuery = true)
	public List<Timetable> findTimetableWithClosingHourAfter(int hour);

}
