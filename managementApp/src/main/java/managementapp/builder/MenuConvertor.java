package managementapp.builder;

import java.util.ArrayList;
import java.util.List;

import managementapp.dto.MenuDTO;
import managementapp.model.Menu;

public class MenuConvertor {

	public static MenuDTO convertToMenuDTO(Menu menu) {
		MenuDTO menuDTO = new MenuDTO();
		menuDTO.setId(menu.getId());
		menuDTO.setCourses(menu.getCourses());
		menuDTO.setName(menu.getName());
		menuDTO.setPrice(menu.getPrice());
		menuDTO.setType(menu.getType());
		return menuDTO;
	}

	public static List<MenuDTO> convertMenuListToMenuDTOList(Iterable<Menu> menus) {
		List<MenuDTO> menuDTOs = new ArrayList<MenuDTO>();
		for (Menu menu : menus) {
			menuDTOs.add(convertToMenuDTO(menu));
		}
		return menuDTOs;
	}

	public static Menu convertMenuDTOToMenu(MenuDTO menuDTO) {
		Menu menu = new Menu(menuDTO.getName(), menuDTO.getPrice(), menuDTO.getType(),
				menuDTO.getCourses());
		menu.setId(menuDTO.getId());
		return menu;
	}

}
