package managementapp.service;

import java.util.List;
import java.util.Optional;

import managementapp.model.Menu;

public interface MenuService {
	
	public List<Menu> findByMenuName(String name);
	
	public List<Menu> findByPriceBelowLimit(int i);
	
	public Iterable<Menu> getAll();
	
	public List<Menu> findByType(String type);

	public Menu save(Menu menu);
	
	public Optional<Menu> findById(Long id);

	public List<Menu> findDietMenusBelow(int kaloriesLimit);

}
