package managementapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import managementapp.builder.MenuDTO;
import managementapp.model.Menu;
import managementapp.model.Type;
import managementapp.repository.MenuRepository;
import managementapp.service.impl.MenuServiceImpl;


@RunWith(SpringRunner.class)
public class MenuServiceTest {

	private static MenuRepository menuRepository=mock(MenuRepository.class);

	@TestConfiguration
	static class ContextConfiguration {

		@Bean
		public MenuService menuService() {
			return new MenuServiceImpl(menuRepository);
		}
	}

	@Autowired
	private MenuService menuService;

	@Test
	public void testFindBelowPriceLimit() {
		List<Menu> menus = new ArrayList<Menu>();
		menus.add(new Menu("Monday", 10, Type.VEGETARIAN));
		Mockito.when(menuRepository.findByPriceBelow(ArgumentMatchers.anyInt())).thenReturn(menus);
		List<MenuDTO> results = menuService.findByPriceBelowLimit(30);
		assertEquals(results.size(), 1);
	}
	
	@Test
	public void testFindByType() {
		List<Menu> menus = new ArrayList<Menu>();
		menus.add(new Menu("Monday", 10, Type.VEGETARIAN));
		Mockito.when(menuRepository.findByType(ArgumentMatchers.anyString())).thenReturn(menus);
		List<MenuDTO> results = menuService.findByType("REGULAR");
		assertEquals(results.size(), 1);
	}

}
