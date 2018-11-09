package managementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import managementapp.exceptions.BadRequestException;
import managementapp.model.Employee;
import managementapp.model.Menu;
import managementapp.model.Type;
import managementapp.service.MenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {

	private MenuService menuService;

	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@GetMapping
	public Iterable<Menu> getAll() {
		return menuService.getAll();
	}

	@GetMapping("/{name}")
	public List<Menu> findByName(@PathVariable(value = "name") String name) {
		return menuService.findByMenuName(name);
	}

	@GetMapping("/price")
	public List<Menu> findByPriceBelow(
			@RequestParam(name = "price", required = false, defaultValue = "1000") Long price) {
		return menuService.findByPriceBelowLimit(price);
	}

	@GetMapping("/type/{type}")
	public List<Menu> findByType(@PathVariable(value = "type") String type) throws BadRequestException {
		if (!Type.containsString(type)) {
			throw new BadRequestException("Incorrect value provided for menu type");
		}
		return menuService.findByType(type);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Menu createMenu(@RequestBody Menu menu) {
		return menuService.create(menu);
	}
}
