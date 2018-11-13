package managementapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import managementapp.model.Employee;
import managementapp.model.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {

	public List<Menu> findByName(String name);
	
	@Query(value = "SELECT * FROM Menu m WHERE m.price <= :priceLimit",nativeQuery = true)
	public List<Menu> findByPriceBelow(int priceLimit);
	
	@Query(value = "SELECT * FROM Menu m WHERE UPPER(m.type) = :type",nativeQuery = true)
	public List<Menu> findByType(String type);	
	
	
}
