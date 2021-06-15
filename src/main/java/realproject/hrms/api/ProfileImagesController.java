package realproject.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import realproject.hrms.business.abstracts.ProfileImageService;
import realproject.hrms.core.utilities.results.ErrorDataResult;
import realproject.hrms.entities.concretes.ProfileImage;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
public class ProfileImagesController {
    private ProfileImageService profileImageService;

    @Autowired
    public ProfileImagesController(ProfileImageService profileImageService) {
        this.profileImageService = profileImageService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody ProfileImage profileImage) throws IOException {
        return ResponseEntity.ok(this.profileImageService.add(profileImage));
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
