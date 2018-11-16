package managementapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

import managementapp.model.Timetable;
import managementapp.repository.TimetableRepository;
import managementapp.service.impl.TimetableServiceImpl;

@RunWith(SpringRunner.class)
public class TimetableServiceTest {

	private static TimetableRepository timetableRepository = mock(TimetableRepository.class);

	@TestConfiguration
	static class ContextConfiguration {

		@Bean
		public TimetableServiceImpl timetableService() {
			return new TimetableServiceImpl(timetableRepository);
		}
	}

	@Autowired
	private TimetableService timetableService;

	@Test
	public void testFindByName() {
		List<Timetable> timetables = new ArrayList<Timetable>();
		timetables.add(new Timetable("09.00", "18.00", "Holiday"));
		Mockito.when(timetableRepository.findByName(ArgumentMatchers.anyString())).thenReturn(timetables);
		List<Timetable> results = timetableService.findByTimetableName("Holiday");
		assertEquals(results.size(), 1);
		assertTrue(results.equals(timetables));
	}

}
