package managementapp.util;

import java.util.ArrayList;
import java.util.List;

import managementapp.builder.MenuDTO;
import managementapp.model.Menu;

public class MenuConvertor {

	public static MenuDTO convertToMenuDTO(Menu menu) {
		MenuDTO menuDTO = new MenuDTO.Builder(menu.getId()).withCourses(menu.getCourses()).withName(menu.getName())
				.withPrice(menu.getPrice()).withType(menu.getType()).build();
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
		return new Menu(menuDTO.getId(), menuDTO.getName(), menuDTO.getPrice(), menuDTO.getType(),
				menuDTO.getCourses());
	}

}
