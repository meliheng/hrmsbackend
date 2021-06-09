package realproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import realproject.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	Employer findByemail(String email);
}
