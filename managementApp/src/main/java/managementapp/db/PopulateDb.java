package managementapp.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import managementapp.model.Employee;
import managementapp.model.Menu;
import managementapp.model.util.Job;
import managementapp.repository.EmployeeRepository;
import managementapp.repository.MenuRepository;

@Component
public class PopulateDb implements ApplicationRunner {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private MenuRepository menuRepo;

	@Override
	public void run(ApplicationArguments args) {
		empRepo.save(new Employee("Ioana", "Popa", Job.COOK));
		empRepo.save(new Employee("Ana", "Popa", Job.VENDOR));
		empRepo.save(new Employee("Andrei", "Mihai", Job.COOK));
		empRepo.save(new Employee("David", "Luca", Job.VENDOR));
		empRepo.save(new Employee("George", "Morosac", Job.VENDOR));
		menuRepo.save(new Menu("Kids", 10L));
		menuRepo.save(new Menu("Menu of the day", 30L));

	}

}
