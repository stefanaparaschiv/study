package managementapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managementapp.builder.TimetableDTO;
import managementapp.model.Timetable;
import managementapp.repository.dao.TimetableDAO;
import managementapp.service.TimetableService;

@Service
public class TimetableServiceImpl implements TimetableService {
	
	private TimetableDAO timetableDAO;

	@Autowired
	public TimetableServiceImpl(TimetableDAO timetableDAO) {
		this.timetableDAO=timetableDAO;
	}

	@Override
	public List<TimetableDTO> findByTimetableName(String name) {
		return convertTimetableListToTimetableDTOList(timetableDAO.findByName(name));
	}

	@Override
	public List<TimetableDTO> getAllTimetables() {
		return convertTimetableListToTimetableDTOList(timetableDAO.findAll());
	}

	@Override
	public List<TimetableDTO> findTimetableWithClosingHourAfter(int hour) {
		return convertTimetableListToTimetableDTOList(timetableDAO.findTimetableWithClosingHourAfter(hour));
	}

	private TimetableDTO convertToTimetableDTO(Timetable timetable) {
		TimetableDTO timetableDTO = new TimetableDTO.Builder(timetable.getId()).withClosingHours(timetable.getClosingHours()).withOpeningHours(timetable.getOpeningHours()).withName(timetable.getName())	       
		        .build();
		return timetableDTO;
	}

	private List<TimetableDTO> convertTimetableListToTimetableDTOList(Iterable<Timetable> timetables) {
		List<TimetableDTO> timetableDTOs = new ArrayList<TimetableDTO>();
		for (Timetable timetable : timetables) {
			timetableDTOs.add(convertToTimetableDTO(timetable));
		}
		return timetableDTOs;
	}

}
