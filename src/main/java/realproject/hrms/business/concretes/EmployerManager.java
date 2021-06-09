package realproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import realproject.hrms.business.abstracts.EmployerService;
import realproject.hrms.business.abstracts.FormValidationService;
import realproject.hrms.core.utilities.EmailValidManager;
import realproject.hrms.core.utilities.adapter.VerificationService;
import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.core.utilities.results.ErrorResult;
import realproject.hrms.core.utilities.results.SuccessResult;
import realproject.hrms.core.utilities.results.SuccessDataResult;
import realproject.hrms.dataAccess.abstracts.EmployerDao;
import realproject.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private FormValidationService formValidationService;
	private VerificationService verificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, FormValidationService formValidationService, VerificationService verificationService) {
		super();
		this.employerDao = employerDao;
		this.formValidationService = formValidationService;
		this.verificationService = verificationService;
	}


	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"data listelendi");
	}


	@Override
	public Result add(Employer employer) {
		if(!isEmailExists(employer.getEmail())) {
			return new ErrorResult("bu maile kayıtlı bir şirket hesabı bulunmaktadır!");
		}
		else if (!EmailValidManager.isEmailEqualsWebAdress(employer.getWebsite(),employer.getEmail())){
			return new ErrorResult("web adresi ile email aynı alan adına sahip değil!");
		}
		else if(!this.verificationService.emailVerification(employer.getEmail())) {
			return new ErrorResult("email aktivitasyonu yapılmadı!");
		}
		this.employerDao.save(employer);
		return new SuccessResult("yeni kayıt eklendi");
	}
	
	public boolean isEmailExists(String email) {
		return this.employerDao.findByemail(email)==null;
	}

}
