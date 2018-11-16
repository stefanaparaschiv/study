package managementapp.service;

import java.util.List;

import managementapp.model.Timetable;

public interface TimetableService {

	public List<Timetable> findByTimetableName(String name);

	public Iterable<Timetable> getAllTimetables();
	
	public List<Timetable> findTimetableWithClosingHourAfter(int hour);
	
}
