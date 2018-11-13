package managementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import managementapp.model.Timetable;
import managementapp.service.MenuService;
import managementapp.service.TimetableService;

@RestController
@RequestMapping("/timetables")
public class TimetableController {

	private TimetableService timetableService;
	
	@Autowired
	public TimetableController(TimetableService timetableService) {
		this.timetableService = timetableService;
	}
	
	@GetMapping("/{name}")
	public List<Timetable> findByName(@PathVariable(value = "name") String name) {
		return timetableService.findByName(name);
	}
	
	@GetMapping()
	public Iterable<Timetable> findAll() {
		return timetableService.getAll();
	}
	
	@GetMapping("/search")
	public List<Timetable> findTimetablesWithClosingHourAfter(@RequestParam(name = "hour", required = true) int hour) {
		return timetableService.findTimetableWithClosingHourAfter(hour);
	}
	
}
