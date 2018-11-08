package managementapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import managementapp.model.Employee;
import managementapp.model.Job;
import managementapp.model.Menu;

@RunWith(SpringRunner.class)
@DataJpaTest

public class MenuRepositoryTest {
	
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void testFindByName() {
        
    	Menu menu = new Menu("Kids",10L);
    	 
        entityManager.persist(menu);

        List<Menu> findByName = menuRepository.findByName(menu.getName());

        assertThat(findByName).extracting(Menu::getName).containsOnly(menu.getName());
    }
    
}
