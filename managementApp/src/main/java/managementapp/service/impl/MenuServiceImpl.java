package managementapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managementapp.builder.EmployeeDTO;
import managementapp.builder.MenuDTO;
import managementapp.exceptions.NotFoundException;
import managementapp.model.Course;
import managementapp.model.Employee;
import managementapp.model.Menu;
import managementapp.repository.MenuRepository;
import managementapp.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	private MenuRepository menuRepository;

	@Autowired
	public MenuServiceImpl(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	@Override
	public List<MenuDTO> findByMenuName(String name) {
		return convertMenuListToMenuDTOList(menuRepository.findByName(name));
	}

	@Override
	public List<MenuDTO> findByPriceBelowLimit(int priceLimit) {
		return convertMenuListToMenuDTOList(menuRepository.findByPriceBelow(priceLimit));
	}

	@Override
	public List<MenuDTO> getAll() {
		return convertMenuListToMenuDTOList(menuRepository.findAll());
	}

	@Override
	public List<MenuDTO> findByType(String type) {
		return convertMenuListToMenuDTOList(menuRepository.findByType(type));
	}

	@Override
	public Menu save(MenuDTO menuDTO) {
		return menuRepository.save(convertMenuDTOToMenu(menuDTO));
	}

	@Override
	public MenuDTO findById(Long id) throws NotFoundException {
		Optional<Menu> searchedMenu = menuRepository.findById(id);
		if (!searchedMenu.isPresent()) {
			throw new NotFoundException("No menu with id=" + id + " was found");
		}
		return convertToMenuDTO(searchedMenu.get());
	}

	@Override
	public List<MenuDTO> findDietMenusBelow(int kaloriesLimit) {
		List<MenuDTO> menus = this.getAll();
		int kalories = 0;
		List<MenuDTO> dietMenus = new ArrayList<MenuDTO>();
		for (MenuDTO menu : menus) {
			for (Course course : menu.getCourses()) {
				kalories += course.getKalories();
			}
			if (kalories <= kaloriesLimit) {
				dietMenus.add(menu);
			}
			kalories = 0;
		}
		return dietMenus;
	}
	
	private MenuDTO convertToMenuDTO(Menu menu) {
		MenuDTO menuDTO = new MenuDTO.Builder(menu.getId())
		        .withCourses(menu.getCourses()).withName(menu.getName()).withPrice(menu.getPrice()).withType(menu.getType())
		        .build();
		return menuDTO;
	}
	
	private List<MenuDTO> convertMenuListToMenuDTOList(Iterable<Menu> menus) {
		List<MenuDTO> menuDTOs=new ArrayList<MenuDTO>();
		for(Menu menu:menus)
		{
			menuDTOs.add(convertToMenuDTO(menu));
		}
		return menuDTOs;
	}
	
	private Menu convertMenuDTOToMenu(MenuDTO menuDTO) {
		return new Menu(menuDTO.getId(),menuDTO.getName(),menuDTO.getPrice(),menuDTO.getType(),menuDTO.getCourses());
	}

}
