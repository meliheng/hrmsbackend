package realproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.hrms.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter,Integer> {
    CoverLetter findByJobSeeker_Id(int jobSeekerId);
}
