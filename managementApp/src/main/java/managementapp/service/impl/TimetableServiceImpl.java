package managementapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managementapp.model.Timetable;
import managementapp.repository.TimetableRepository;
import managementapp.service.TimetableService;

@Service
public class TimetableServiceImpl implements TimetableService {

	private TimetableRepository timetableRepository;

	@Autowired
	public TimetableServiceImpl(TimetableRepository timetableRepository) {
		this.timetableRepository = timetableRepository;
	}

	@Override
	public List<Timetable> findByTimetableName(String name) {
		return timetableRepository.findByName(name);
	}

	@Override
	public Iterable<Timetable> getAllTimetables() {
		return timetableRepository.findAll();
	}

	@Override
	public List<Timetable> findTimetableWithClosingHourAfter(int hour) {
		return timetableRepository.findTimetableWithClosingHourAfter(hour);
	}

}
