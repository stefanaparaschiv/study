package managementapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import managementapp.model.Employee;
import managementapp.model.Menu;
import managementapp.model.Type;

public interface MenuService {
	
	public List<Menu> findByMenuName(String name);
	
	public List<Menu> findByPriceBelowLimit(int i);
	
	public Iterable<Menu> getAll();
	
	public List<Menu> findByType(String type);

	public Menu create(Menu menu);

}
