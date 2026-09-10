package in.kumar.exception;

import in.kumar.payload.ApiResponse;
import org.hibernate.mapping.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Map<Objects, Objects>>> handleGenericException(Exception exception){
       ApiResponse<Map<Objects, Objects>> apiResponse = new ApiResponse<>("ERROR", "SOMETHING WRONG", Collections.EMPTY_MAP);

       return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // FOR VALIDATION EXCEPTION
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity< ApiResponse<Map<String, String>>> handleValidationException(MethodArgumentNotValidException exception){


        Map<String, String> error = new HashMap<>();

        //........APPROCH I........

//        //all validation error are catching and store list
//        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
//
//        for (FieldError fr: fieldErrors){
//            error.put(fr.getField(), fr.getDefaultMessage());
//        }


        //........APPROCH II........
        exception.getBindingResult().getFieldErrors().forEach(errors-> error.put(errors.getField(), errors.getDefaultMessage()));

        ApiResponse<Map<String, String>> apiResponse = new ApiResponse<>("ERROR", "VALIDATION FAILED", error);


        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);

    }

}
