package managementapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import managementapp.model.Timetable;

@RunWith(SpringRunner.class)
@DataJpaTest

public class TimetableRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TimetableRepository timetableRepository;

	@Before
	public void setUp() {

		entityManager.persist(new Timetable("09.00", "18.00", "Monday-Friday"));
		entityManager.persist(new Timetable("12.00", "15.00", "Holiday"));

	}

	@Test
	public void testFindByName() {

		List<Timetable> findByName = timetableRepository.findByName("Holiday");

		assertThat(findByName).extracting(Timetable::getName).containsOnly("Holiday");
	}

}
