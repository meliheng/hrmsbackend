package realproject.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import realproject.hrms.business.abstracts.SocialMediaLinkService;
import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.ErrorDataResult;
import realproject.hrms.entities.concretes.SocialMediaLink;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/socialmedialinks")
public class SocialMediaLinksController {
    private SocialMediaLinkService socialMediaLinkService;

    @Autowired
    public SocialMediaLinksController(SocialMediaLinkService socialMediaLinkService) {
        this.socialMediaLinkService = socialMediaLinkService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody SocialMediaLink socialMediaLink){
        return ResponseEntity.ok(this.socialMediaLinkService.add(socialMediaLink));
    }
    @GetMapping("/getAll")
    public DataResult<List<SocialMediaLink>> getAll(){
        return this.socialMediaLinkService.getAll();
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
