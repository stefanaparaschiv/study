package managementapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managementapp.builder.MenuDTO;
import managementapp.builder.TimetableDTO;
import managementapp.model.Menu;
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
	public List<TimetableDTO> findByTimetableName(String name) {
		return convertTimetableListToTimetableDTOList(timetableRepository.findByName(name));
	}

	@Override
	public List<TimetableDTO> getAllTimetables() {
		return convertTimetableListToTimetableDTOList(timetableRepository.findAll());
	}

	@Override
	public List<TimetableDTO> findTimetableWithClosingHourAfter(int hour) {
		return convertTimetableListToTimetableDTOList(timetableRepository.findTimetableWithClosingHourAfter(hour));
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
