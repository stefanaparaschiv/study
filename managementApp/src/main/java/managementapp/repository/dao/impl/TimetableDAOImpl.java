package managementapp.repository.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managementapp.model.Timetable;
import managementapp.repository.dao.TimetableDAO;

@Service
public class TimetableDAOImpl implements TimetableDAO {

	private EntityManager em;

	@Autowired
	public TimetableDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public List<Timetable> findTimetableWithClosingHourAfter(int hour) {
		Query q = em.createNativeQuery("SELECT * FROM Timetable t WHERE CAST(LEFT(t.CLOSING_HOURS, 2) AS INT) >=?","TimetableMapping");
		q.setParameter(1, hour);		
		List<Timetable> results = q.getResultList();
		return results;
	}

	@Override
	public Iterable<Timetable> findByName(String name) {
		Query q = em.createNativeQuery("SELECT * FROM Timetable t WHERE t.name=?","TimetableMapping");
		q.setParameter(1, name);		
		List<Timetable> results = q.getResultList();
		return results;
	}

	@Override
	public Iterable<Timetable> findAll() {
		Query q = em.createNativeQuery("SELECT * FROM Timetable","TimetableMapping");		
		List<Timetable> results = q.getResultList();
		return results;
	}

}
