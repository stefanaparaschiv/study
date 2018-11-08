package managementapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {

	public Menu(String name, Long price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public Menu() {
		super();
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
    private String name;
    
    private Long price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
    
}
