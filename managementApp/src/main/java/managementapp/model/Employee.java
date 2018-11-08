// tag::sample[]
package managementapp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    
    @Enumerated(EnumType.STRING)
    private Job job;

    protected Employee() {}

    public Employee(String firstName, String lastName, Job job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job=job;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
}

