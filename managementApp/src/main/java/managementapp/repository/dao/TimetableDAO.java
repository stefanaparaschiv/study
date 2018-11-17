package managementapp.repository.dao;

import java.util.List;

import managementapp.model.Timetable;

public interface TimetableDAO {
	
	public List<Timetable> findTimetableWithClosingHourAfter(int hour);

	public Iterable<Timetable> findByName(String name);

	public Iterable<Timetable> findAll();

}
