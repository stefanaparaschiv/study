package managementapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import managementapp.model.Employee;
import managementapp.model.Menu;
import managementapp.repository.MenuRepository;
import managementapp.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	private MenuRepository menuRepository;

	public MenuServiceImpl(MenuRepository menuRepository) {
       this.menuRepository=menuRepository;
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

}
