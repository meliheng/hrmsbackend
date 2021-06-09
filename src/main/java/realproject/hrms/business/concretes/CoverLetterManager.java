package realproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realproject.hrms.business.abstracts.CoverLetterService;
import realproject.hrms.core.utilities.results.*;
import realproject.hrms.dataAccess.abstracts.CoverLetterDao;
import realproject.hrms.entities.concretes.CoverLetter;

import java.util.List;

@Service
public class CoverLetterManager implements CoverLetterService {

    private CoverLetterDao coverLetterDao;

    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao) {
        this.coverLetterDao = coverLetterDao;
    }

    @Override
    public Result add(CoverLetter coverLetter) {
        if (this.coverLetterDao.findByJobSeeker_Id(coverLetter.getJobSeeker().getId())!=null){
            return new ErrorResult("hakkında yazınız bulunmaktadır");
        }
        this.coverLetterDao.save(coverLetter);
        return new SuccessResult("hakkında yazısı eklendi");



    }

    @Override
    public DataResult<List<CoverLetter>> getAll() {
        if ((long) this.coverLetterDao.findAll().size() !=0){
            return new SuccessDataResult<>(this.coverLetterDao.findAll(),"data listelendi");
        }
        return new ErrorDataResult<>(null,"hakkımda yazınız bulunmamaktadır");
    }
}
