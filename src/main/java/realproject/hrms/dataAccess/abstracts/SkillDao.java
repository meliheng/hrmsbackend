package realproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill,Integer> {
}
