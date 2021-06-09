package realproject.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import realproject.hrms.business.abstracts.JobBoardService;
import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.ErrorDataResult;
import realproject.hrms.entities.concretes.JobBoard;
import realproject.hrms.entities.dtos.JobBoardDto;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobboards")
@CrossOrigin()
public class JobBoardsController {

    private JobBoardService jobBoardService;

    @Autowired
    public JobBoardsController(JobBoardService jobBoardService){
        this.jobBoardService = jobBoardService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobBoard jobBoard){
        return ResponseEntity.ok(this.jobBoardService.add(jobBoard));
    }
    @GetMapping("/getall")
    public DataResult<List<JobBoardDto>> getAll(){
        return this.jobBoardService.getAll();
    }
    @GetMapping("/getallbyCompany")
    public DataResult<List<JobBoardDto>> getallbyCompany(@RequestParam String companyName){
        return this.jobBoardService.getAll(companyName);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors,"doğrulama hataları");
        return errors;
    }

}
