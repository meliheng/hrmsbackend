package realproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import realproject.hrms.business.abstracts.JobPositionService;
import realproject.hrms.core.utilities.results.ErrorResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.core.utilities.results.SuccessResult;
import realproject.hrms.dataAccess.abstracts.JobPositionDao;
import realproject.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return this.jobPositionDao.findAll();
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (this.jobPositionDao.findByjobname(jobPosition.getJobname())!=null){
			System.out.println(jobPosition.getJobname());
			return new ErrorResult("bu adda kayıtlı bir iş alanı bulunmaktadır!");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("yeni iş pozisyonu eklendi");
	}

}
