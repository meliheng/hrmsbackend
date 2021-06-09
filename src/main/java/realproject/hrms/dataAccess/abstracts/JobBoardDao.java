package realproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import realproject.hrms.entities.concretes.JobBoard;
import realproject.hrms.entities.dtos.JobBoardDto;

import java.util.List;

public interface JobBoardDao extends JpaRepository<JobBoard,Integer> {

    @Query("Select new realproject.hrms.entities.dtos.JobBoardDto (b.jobId, c.companyName, p.jobname, b.numberOfPerson, b.createdDate, b.lastApplyDate) From Employer c Inner Join c.jobBoards b Inner Join b.jobPosition p Order By b.createdDate")
    List<JobBoardDto> getJobBoardWithEmployerDetails();

    @Query("Select new realproject.hrms.entities.dtos.JobBoardDto (b.jobId, c.companyName, p.jobname, b.numberOfPerson, b.createdDate, b.lastApplyDate) From Employer c Inner Join c.jobBoards b Inner Join b.jobPosition p Where c.companyName =:companyName and b.isActive=true Order By b.createdDate")
    List<JobBoardDto> getJobBoardWithEmployerDetails(String companyName);
}
