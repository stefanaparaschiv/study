package managementapp.util;

import java.util.ArrayList;
import java.util.List;

import managementapp.builder.TimetableDTO;
import managementapp.model.Timetable;

public class TimetableConvertor {

	public static TimetableDTO convertToTimetableDTO(Timetable timetable) {
		TimetableDTO timetableDTO = new TimetableDTO.Builder(timetable.getId())
				.withClosingHours(timetable.getClosingHours()).withOpeningHours(timetable.getOpeningHours())
				.withName(timetable.getName()).build();
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
