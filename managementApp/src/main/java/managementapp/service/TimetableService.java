package managementapp.service;

import java.util.List;

import managementapp.model.Timetable;

public interface TimetableService {

	public List<Timetable> findByName(String name);

	public Iterable<Timetable> getAll();
	
	public List<Timetable> findTimetableWithClosingHourAfter(int hour);
	
}
