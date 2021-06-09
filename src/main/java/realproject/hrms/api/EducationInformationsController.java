package realproject.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import realproject.hrms.business.abstracts.EducationInformationService;
import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.ErrorDataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.entities.concretes.EducationInformation;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/educations")
public class EducationInformationsController {

    private EducationInformationService educationInformationService;

    @Autowired
    public EducationInformationsController(EducationInformationService educationInformationService) {
        this.educationInformationService = educationInformationService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody EducationInformation educationInformation){
        return ResponseEntity.ok(this.educationInformationService.add(educationInformation));
    }
    @GetMapping("/getAll")
    public DataResult<List<EducationInformation>> getAll(){
        return this.educationInformationService.getAll();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<>();
        for (FieldError fieldError:exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors,"Doğrulama hataları");
        return errors;
    }


}
