package managementapp.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import managementapp.model.Course;
import managementapp.model.Employee;
import managementapp.model.Job;
import managementapp.model.Menu;
import managementapp.model.Timetable;
import managementapp.model.Type;
import managementapp.repository.EmployeeRepository;
import managementapp.repository.MenuRepository;
import managementapp.repository.TimetableRepository;

@Component
public class PopulateDb implements ApplicationRunner {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private MenuRepository menuRepo;

	@Autowired
	private TimetableRepository timetableRepo;

	private Menu menu;

	private Menu kidsMenu;

	@Override
	public void run(ApplicationArguments args) {
		List<Course> courses = createCourseList();
		List<Course> kidsCourses = createKidsCourseList();
		menu = new Menu("Kids", 10, Type.REGULAR, kidsCourses);
		kidsMenu = new Menu("Menu of the day", 30, Type.VEGETARIAN, courses);
		empRepo.save(new Employee("Ioana", "Popa", Job.COOK));
		empRepo.save(new Employee("Ana", "Popa", Job.VENDOR));
		empRepo.save(new Employee("Andrei", "Mihai", Job.COOK));
		empRepo.save(new Employee("David", "Luca", Job.VENDOR));
		empRepo.save(new Employee("George", "Morosac", Job.VENDOR));
		menuRepo.save(new Menu("Kids", 10, Type.REGULAR, kidsCourses));
		menuRepo.save(new Menu("Menu of the day", 30, Type.VEGETARIAN, courses));
		timetableRepo.save(new Timetable("09.00", "18.00", "Monday-Friday"));
		timetableRepo.save(new Timetable("11.00", "16.00", "Holiday"));
	}

	private List<Course> createCourseList() {
		Course course = new Course("tomato soup", 100);
		Course mainCourse = new Course("halloumi burger", 300);
		List<Course> courses = new ArrayList<Course>();
		courses.add(course);
		courses.add(mainCourse);
		return courses;
	}

	private List<Course> createKidsCourseList() {
		Course course = new Course("chicken soup", 100);
		Course mainCourse = new Course("pizza", 400);
		Course desert = new Course("chocolate cake", 300);
		List<Course> courses = new ArrayList<Course>();
		courses.add(course);
		courses.add(mainCourse);
		courses.add(desert);
		return courses;
	}

}
