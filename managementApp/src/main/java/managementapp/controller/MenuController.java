package managementapp.controller;

import java.util.List;

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
import managementapp.exceptions.BadRequestException;
import managementapp.exceptions.NotFoundException;
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
	public List<MenuDTO> getAll() {
		return menuService.getAll();
	}

	@GetMapping("/{name}")
	public List<MenuDTO> findByName(@PathVariable(value = "name") String name) {
		return menuService.findByMenuName(name);
	}

	@GetMapping("/price")
	public List<MenuDTO> findByPriceBelow(
			@RequestParam(name = "limit", required = true) int limit) {
		return menuService.findByPriceBelowLimit(limit);
	}

	@GetMapping("/type/{type}")
	public List<MenuDTO> findByType(@PathVariable(value = "type") String type) throws BadRequestException {
		if (!Type.containsString(type)) {
			throw new BadRequestException("Incorrect value provided for menu type");
		}
		return menuService.findByType(type);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Menu createMenu(@RequestBody MenuDTO menu) {
		return menuService.save(menu);
	}

	@PutMapping("/update/{id}")
	public @ResponseBody Menu updateMenu(@RequestBody MenuDTO menu, @PathVariable("id") Long id)
			throws BadRequestException, NotFoundException {
		if (menu.getId() != id) {
			throw new BadRequestException("Path id and menu id do not match");
		}
		MenuDTO searchedMenu = menuService.findById(id);
	    searchedMenu.setCourses(menu.getCourses());
		searchedMenu.setName(menu.getName());
		searchedMenu.setPrice(menu.getPrice());
		searchedMenu.setType(menu.getType());
		return menuService.save(searchedMenu);
	}

	@GetMapping("/diet")
	public List<MenuDTO> findDietMenusBelow(@RequestParam(name = "kaloriesLimit", required = true) int kaloriesLimit) {
		return menuService.findDietMenusBelow(kaloriesLimit);
	}

}
