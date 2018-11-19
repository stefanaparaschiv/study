package managementapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import managementapp.builder.MenuDTO;
import managementapp.exceptions.BusinessException;
import managementapp.model.Course;
import managementapp.model.Menu;
import managementapp.repository.MenuRepository;
import managementapp.service.MenuService;
import managementapp.util.MenuConvertor;

@Service
public class MenuServiceImpl implements MenuService {

	private MenuRepository menuRepository;

	@Autowired
	public MenuServiceImpl(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	@Override
	public List<MenuDTO> findByMenuName(String name) {
		return MenuConvertor.convertMenuListToMenuDTOList(menuRepository.findByName(name));
	}

	@Override
	public List<MenuDTO> findByPriceBelowLimit(int priceLimit) {
		return MenuConvertor.convertMenuListToMenuDTOList(menuRepository.findByPriceBelow(priceLimit));
	}

	@Override
	public List<MenuDTO> getAll() {
		return MenuConvertor.convertMenuListToMenuDTOList(menuRepository.findAll());
	}

	@Override
	public List<MenuDTO> findByType(String type) {
		return MenuConvertor.convertMenuListToMenuDTOList(menuRepository.findByType(type));
	}

	@Override
	public MenuDTO save(MenuDTO menuDTO) {
		return MenuConvertor.convertToMenuDTO(menuRepository.save(MenuConvertor.convertMenuDTOToMenu(menuDTO)));
	}

	@Override
	public MenuDTO findById(Long id) throws BusinessException {
		Optional<Menu> searchedMenu = menuRepository.findById(id);
		if (!searchedMenu.isPresent()) {
			throw new BusinessException("No menu with id=" + id + " was found");
		}
		return MenuConvertor.convertToMenuDTO(searchedMenu.get());
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

}
