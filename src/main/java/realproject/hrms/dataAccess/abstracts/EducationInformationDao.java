package realproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.hrms.entities.concretes.EducationInformation;

public interface EducationInformationDao extends JpaRepository<EducationInformation,Integer> {
}
