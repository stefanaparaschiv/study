package managementapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import managementapp.model.Menu;
import managementapp.model.Type;

@RunWith(SpringRunner.class)
@DataJpaTest

public class MenuRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private MenuRepository menuRepository;

	private Menu menu;
	private Menu kidsMenu;

	@Before
	public void setUp() {

		menu = new Menu("Kids", 10, Type.REGULAR);
		kidsMenu = new Menu("Kids", 10, Type.REGULAR);
		entityManager.persist(menu);
		entityManager.persist(kidsMenu);

	}

	@Test
	public void testFindByName() {

		List<Menu> findByName = menuRepository.findByName(menu.getName());

		assertThat(findByName).extracting(Menu::getName).containsOnly(menu.getName());
	}

	@Test
	public void testFindByType() {

		List<Menu> findByName = menuRepository.findByType("REGULAR");

		assertThat(findByName).extracting(Menu::getType).containsOnly(kidsMenu.getType());
	}

}
