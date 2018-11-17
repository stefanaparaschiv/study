package managementapp.repository;

import org.springframework.data.repository.CrudRepository;

import managementapp.model.Timetable;

public interface TimetableRepository extends CrudRepository<Timetable, Long> {

}
