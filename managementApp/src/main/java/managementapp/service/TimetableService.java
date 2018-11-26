package managementapp.service;

import java.util.List;

import managementapp.dto.TimetableDTO;
import managementapp.model.Timetable;

public interface TimetableService {

	public List<TimetableDTO> findByTimetableName(String name);

	public List<TimetableDTO> getAllTimetables();
	
	public List<TimetableDTO> findTimetableWithClosingHourAfter(int hour);
	
}
