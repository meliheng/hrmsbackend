package realproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.hrms.entities.concretes.ProfileImage;

public interface ProfileImageDao extends JpaRepository<ProfileImage,Integer> {
}
