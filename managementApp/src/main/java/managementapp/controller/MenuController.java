package managementapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import managementapp.builder.MenuDTO;
import managementapp.exceptions.BusinessException;
import managementapp.exceptions.ValidationException;
import managementapp.model.Menu;
import managementapp.service.MenuService;
import managementapp.util.Validator;

@RestController
@RequestMapping("/menus")
public class MenuController {

	private MenuService menuService;

	static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@GetMapping
	public List<MenuDTO> getAll() {
		LOGGER.info("Getting all menus");
		return menuService.getAll();
	}

	@GetMapping("/{name}")
	public List<MenuDTO> findByName(@PathVariable(value = "name") String name) {
		LOGGER.info("Search menus with name {}", name);
		return menuService.findByMenuName(name);
	}

	@GetMapping("/price")
	public List<MenuDTO> findByPriceBelow(@RequestParam(name = "limit", required = true) int limit) {
		LOGGER.info("Search menus with price below {}", limit);
		return menuService.findByPriceBelowLimit(limit);
	}

	@GetMapping("/type/{type}")
	public List<MenuDTO> findByType(@PathVariable(value = "type") String type) throws ValidationException {
		LOGGER.info("Search menus with type {}", type);
		Validator.validateType(type);
		return menuService.findByType(type);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Menu createMenu(@RequestBody MenuDTO menu) {
		LOGGER.info("Create menu");
		return menuService.save(menu);
	}

	@PutMapping("/update/{id}")
	public @ResponseBody Menu updateMenu(@RequestBody MenuDTO menu, @PathVariable("id") Long id)
			throws ValidationException, BusinessException {
		LOGGER.info("Update menu with id {}", id);
		Validator.validateMenuId(menu, id);
		MenuDTO searchedMenu = menuService.findById(id);
		searchedMenu = new MenuDTO.Builder(menu.getId()).withCourses(menu.getCourses()).withName(menu.getName())
				.withPrice(menu.getPrice()).withType(menu.getType()).build();
		return menuService.save(searchedMenu);
	}

	@GetMapping("/diet")
	public List<MenuDTO> findDietMenusBelow(@RequestParam(name = "kaloriesLimit", required = true) int kaloriesLimit) {
		LOGGER.info("Search menus with kalories below {}", kaloriesLimit);
		return menuService.findDietMenusBelow(kaloriesLimit);
	}

}
