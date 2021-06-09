package realproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realproject.hrms.business.abstracts.JobBoardService;
import realproject.hrms.core.utilities.results.*;
import realproject.hrms.dataAccess.abstracts.JobBoardDao;
import realproject.hrms.entities.concretes.JobBoard;
import realproject.hrms.entities.dtos.JobBoardDto;

import java.util.List;

@Service
public class JobBoardManager implements JobBoardService {

    private JobBoardDao jobBoardDao;

    @Autowired
    public JobBoardManager(JobBoardDao jobBoardDao){
        this.jobBoardDao = jobBoardDao;
    }
    @Override
    public Result add(JobBoard jobBoard) {
        this.jobBoardDao.save(jobBoard);
        return new SuccessResult("yeni iş ilanı eklendi");
    }

    @Override
    public DataResult<List<JobBoardDto>> getAll() {
        return new SuccessDataResult<>(this.jobBoardDao.getJobBoardWithEmployerDetails(),"data listelendi");
    }

    @Override
    public DataResult<List<JobBoardDto>> getAll(String companyName) {
        if ((long) this.jobBoardDao.getJobBoardWithEmployerDetails(companyName).size() !=0)
        return new SuccessDataResult<>(this.jobBoardDao.getJobBoardWithEmployerDetails(companyName),"data listelendi");
        else return new ErrorDataResult<>(null,"bu şirkete ait iş ilanı bulunmamaktadır!");
    }
}
