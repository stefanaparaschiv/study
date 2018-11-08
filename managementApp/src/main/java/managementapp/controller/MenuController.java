package managementapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import managementapp.model.Menu;
import managementapp.service.MenuService;

@RestController
public class MenuController {

	private MenuService menuService;

	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@GetMapping("/menus")
	public Iterable<Menu> getAll() {
		return menuService.getAll();
	}

	@GetMapping("/menu/{name}")
	public List<Menu> findByName(@PathVariable(value = "name") String name) {
		return menuService.findByMenuName(name);
	}

	@GetMapping("/menu")
	public List<Menu> findByPriceBelow(
			@RequestParam(name = "price", required = false, defaultValue = "1000") Long price) {
		return menuService.findByPriceBelowLimit(price);
	}

}
