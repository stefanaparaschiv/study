package managementapp.builder;

import java.util.ArrayList;
import java.util.List;

import managementapp.dto.TimetableDTO;
import managementapp.model.Timetable;

public class TimetableConvertor {

	public static TimetableDTO convertToTimetableDTO(Timetable timetable) {
		TimetableDTO timetableDTO = new TimetableDTO();
		timetableDTO.setId(timetable.getId());
		timetableDTO.setName(timetable.getName());
		timetableDTO.setOpeningHours(timetable.getOpeningHours());
		return timetableDTO;
	}

	public static List<TimetableDTO> convertTimetableListToTimetableDTOList(Iterable<Timetable> timetables) {
		List<TimetableDTO> timetableDTOs = new ArrayList<TimetableDTO>();
		for (Timetable timetable : timetables) {
			timetableDTOs.add(convertToTimetableDTO(timetable));
		}
		return timetableDTOs;
	}

}
