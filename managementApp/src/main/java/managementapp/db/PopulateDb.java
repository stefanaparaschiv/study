package managementapp.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import managementapp.model.Employee;
import managementapp.model.Job;
import managementapp.model.Menu;
import managementapp.model.Type;
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
		List<String> ingredients = createIngredientsList();
		List<String> kidsIngredients = createKidsIngredientsList();
		empRepo.save(new Employee("Ioana", "Popa", Job.COOK));
		empRepo.save(new Employee("Ana", "Popa", Job.VENDOR));
		empRepo.save(new Employee("Andrei", "Mihai", Job.COOK));
		empRepo.save(new Employee("David", "Luca", Job.VENDOR));
		empRepo.save(new Employee("George", "Morosac", Job.VENDOR));
		menuRepo.save(new Menu("Kids", 10L, Type.REGULAR, kidsIngredients));
		menuRepo.save(new Menu("Menu of the day", 30L, Type.VEGETARIAN, ingredients));

	}

	private List<String> createIngredientsList() {
		List<String> ingredients = new ArrayList<String>();
		ingredients.add("meat");
		ingredients.add("tomato salad");
		ingredients.add("fries");
		return ingredients;
	}

	private List<String> createKidsIngredientsList() {
		List<String> ingredients = new ArrayList<String>();
		ingredients.add("burger");
		ingredients.add("cookie");
		return ingredients;
	}

}
