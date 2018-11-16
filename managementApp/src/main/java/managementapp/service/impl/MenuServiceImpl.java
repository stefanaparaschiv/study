package managementapp.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Menu> findByMenuName(String name) {
		return menuRepository.findByName(name);
	}

	@Override
	public List<Menu> findByPriceBelowLimit(int priceLimit) {
		return menuRepository.findByPriceBelow(priceLimit);
	}

	@Override
	public Iterable<Menu> getAll() {
		return menuRepository.findAll();
	}

	@Override
	public List<Menu> findByType(String type) {
		return menuRepository.findByType(type);
	}

	@Override
	public Menu save(Menu menu) {
		return menuRepository.save(menu);
	}

	@Override
	public Optional<Menu> findById(Long id) {
		return menuRepository.findById(id);
	}

	@Override
	public List<Menu> findDietMenusBelow(int kaloriesLimit) {
		Iterable<Menu> menus = this.getAll();
		int kalories = 0;
		List<Menu> dietMenus = new ArrayList<Menu>();
		for (Menu menu : menus) {
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
