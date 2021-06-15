package realproject.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import realproject.hrms.business.abstracts.FormValidationService;
import realproject.hrms.business.abstracts.JobSeekerService;
import realproject.hrms.core.utilities.adapter.ImageUploadService;
import realproject.hrms.core.utilities.adapter.RealPersonService;
import realproject.hrms.core.utilities.adapter.VerificationService;
import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.core.utilities.results.ErrorResult;
import realproject.hrms.core.utilities.results.SuccessDataResult;
import realproject.hrms.core.utilities.results.SuccessResult;
import realproject.hrms.dataAccess.abstracts.JobSeekerDao;
import realproject.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao seekerDao;
	private FormValidationService formValidationService;
	private RealPersonService realPersonService;
	private VerificationService verificationService;
	private ImageUploadService imageUploadService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao seekerDao, FormValidationService formValidationService,RealPersonService realPersonService,VerificationService verificationService,ImageUploadService imageUploadService) {
		super();
		this.seekerDao = seekerDao;
		this.formValidationService = formValidationService;
		this.realPersonService = realPersonService;
		this.verificationService = verificationService;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.seekerDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {

		if(!isNationalityIdExists(jobSeeker.getNationalityId())) {
			return new ErrorResult("ilgili tc'ye kayıtlı kullanıcı bulunmaktadır, kaydınız gerçekleştirilemedi!");	
		}
		else if(!isEmailExists(jobSeeker.getEmail())) {
			return new ErrorResult("bu maile ait kayıt bulundu!");
		}
		else if(!this.realPersonService.checkPerson(jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getNationalityId())) {
			return new ErrorResult("kimlik bilgileri doğrulanamadı!");
		}
		else if(!this.verificationService.emailVerification(jobSeeker.getEmail())) {
			return new ErrorResult("email onayı yapılmadı!");
		}
		this.seekerDao.save(jobSeeker);
		return new SuccessResult("Yeni kayıt eklendi");
	}

	@Override
	public boolean isNationalityIdExists(String nationality_id) {
		
		return this.seekerDao.findBynationalityId(nationality_id)==null;
	}
	public boolean isEmailExists(String email) {
		return this.seekerDao.findByemail(email)==null;
	}

	






}
