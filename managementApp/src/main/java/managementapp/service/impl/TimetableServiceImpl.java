package managementapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managementapp.builder.TimetableDTO;
import managementapp.model.Timetable;
import managementapp.repository.dao.TimetableDAO;
import managementapp.service.TimetableService;
import managementapp.util.TimetableConvertor;

@Service
public class TimetableServiceImpl implements TimetableService {
	
	private TimetableDAO timetableDAO;

	@Autowired
	public TimetableServiceImpl(TimetableDAO timetableDAO) {
		this.timetableDAO=timetableDAO;
	}

	@Override
	public List<TimetableDTO> findByTimetableName(String name) {
		return TimetableConvertor.convertTimetableListToTimetableDTOList(timetableDAO.findByName(name));
	}

	@Override
	public List<TimetableDTO> getAllTimetables() {
		return TimetableConvertor.convertTimetableListToTimetableDTOList(timetableDAO.findAll());
	}

	@Override
	public List<TimetableDTO> findTimetableWithClosingHourAfter(int hour) {
		return TimetableConvertor.convertTimetableListToTimetableDTOList(timetableDAO.findTimetableWithClosingHourAfter(hour));
	}

}
