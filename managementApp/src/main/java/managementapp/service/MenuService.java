package managementapp.service;

import java.util.List;
import java.util.Optional;

import managementapp.builder.MenuDTO;
import managementapp.exceptions.NotFoundException;
import managementapp.model.Menu;

public interface MenuService {
	
	public List<MenuDTO> findByMenuName(String name);
	
	public List<MenuDTO> findByPriceBelowLimit(int i);
	
	public List<MenuDTO> getAll();
	
	public List<MenuDTO> findByType(String type);

	public Menu save(MenuDTO menuDto);
	
	public MenuDTO findById(Long id) throws NotFoundException;

	public List<MenuDTO> findDietMenusBelow(int kaloriesLimit);

}
