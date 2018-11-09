package managementapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Menu> findByPriceBelowLimit(Long priceLimit) {
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
	public Menu create(Menu menu) {
		return menuRepository.save(menu);
	}

}
