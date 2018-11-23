package managementapp.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import managementapp.model.Timetable;
import managementapp.repository.dao.TimetableDAO;

@Component
public class TimetableDAOImpl implements TimetableDAO {

	private EntityManager em;

	@Autowired
	public TimetableDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public List<Timetable> findTimetableWithClosingHourAfter(int hour) {
		List<Timetable> timetables=new ArrayList<Timetable>();
		Query query = em.createNativeQuery("SELECT * FROM Timetable t WHERE CAST(LEFT(t.CLOSING_HOURS, 2) AS INT) >=?");
		query.setParameter(1, hour);
		List<Object[]> results = query.getResultList();
		results.stream().forEach((record) -> {
			Timetable timetable= new Timetable(Long.parseLong(record[0].toString()),String.valueOf(record[2]),String.valueOf(record[3]),String.valueOf(record[1]));
			timetables.add(timetable);
		});
		return timetables;
	}
	

	@Override
	public Iterable<Timetable> findByName(String name) {
		Query query = em.createNativeQuery("SELECT * FROM Timetable t WHERE t.name=?","TimetableMapping");
		query.setParameter(1, name);		
		List<Timetable> results = query.getResultList();
		return results;
	}

	@Override
	public Iterable<Timetable> findAll() {
		Query query = em.createNativeQuery("SELECT * FROM Timetable","TimetableMapping");		
		List<Timetable> results = query.getResultList();
		return results;
	}

}
