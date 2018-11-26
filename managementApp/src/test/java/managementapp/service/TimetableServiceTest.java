package managementapp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import managementapp.dto.TimetableDTO;
import managementapp.model.Timetable;
import managementapp.repository.dao.TimetableDAO;
import managementapp.service.impl.TimetableServiceImpl;

@RunWith(SpringRunner.class)
public class TimetableServiceTest {

	private static TimetableDAO timetableDAO = mock(TimetableDAO.class);

	@TestConfiguration
	static class ContextConfiguration {

		@Bean
		public TimetableServiceImpl timetableService() {
			return new TimetableServiceImpl(timetableDAO);
		}
	}

	@Autowired
	private TimetableService timetableService;

	@Test
	public void testFindByName() {
		List<Timetable> timetables = new ArrayList<Timetable>();
		timetables.add(new Timetable("09.00", "18.00", "Holiday"));
		Mockito.when(timetableDAO.findByName(ArgumentMatchers.anyString())).thenReturn(timetables);
		List<TimetableDTO> results = timetableService.findByTimetableName("Holiday");
		assertEquals(results.size(), 1);
	}

}
