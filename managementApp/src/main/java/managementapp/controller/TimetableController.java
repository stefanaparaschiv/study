package managementapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import managementapp.builder.TimetableDTO;
import managementapp.service.TimetableService;

@RestController
@RequestMapping("/timetables")
public class TimetableController {

	static final Logger LOGGER = LoggerFactory.getLogger(TimetableController.class);

	private TimetableService timetableService;

	@Autowired
	public TimetableController(TimetableService timetableService) {
		this.timetableService = timetableService;
	}

	@GetMapping("/{name}")
	public List<TimetableDTO> findByName(@PathVariable(value = "name") String name) {
		LOGGER.info("Search timetables with name {}", name);
		return timetableService.findByTimetableName(name);
	}

	@GetMapping()
	public List<TimetableDTO> findAll() {
		LOGGER.info("Get all timetables");
		return timetableService.getAllTimetables();
	}

	@GetMapping("/search")
	public List<TimetableDTO> findTimetablesWithClosingHourAfter(
			@RequestParam(name = "hour", required = true) int hour) {
		LOGGER.info("Search timetables with closing hour after {}", hour);
		return timetableService.findTimetableWithClosingHourAfter(hour);
	}

}
