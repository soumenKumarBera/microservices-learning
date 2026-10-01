package in.kumar.exception;

import feign.FeignException;
import in.kumar.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Map<Objects, Objects>>> handleGenericException(Exception exception){
        ApiResponse<Map<Objects, Objects>> apiResponse = new ApiResponse<>("ERROR", exception.getMessage(), Collections.EMPTY_MAP);

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

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Map<Objects, Objects>>> handleResourceNotFoundException(ResourceNotFoundException exception){
        ApiResponse<Map<Objects, Objects>> apiResponse = new ApiResponse<>("ERROR", exception.getMessage(), Collections.EMPTY_MAP);

        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(DuplicateResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Map<Objects, Objects>>> handleDuplicateResourceNotFoundException(DuplicateResourceNotFoundException exception){
        ApiResponse<Map<Objects, Objects>> apiResponse = new ApiResponse<>("ERROR", exception.getMessage(), Collections.EMPTY_MAP);

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);

    }

//    @ExceptionHandler(FeignException.class)
//    public ResponseEntity<ApiResponse<Map<Objects, Objects>>> handleFeignException(FeignException exception){
//
//        String url =  exception.request().url(); //get request url
//
//        String employeeId = url.substring(url.lastIndexOf("/") + 1);
//
//        HttpStatus httpStatus = HttpStatus.resolve(exception.status());
//
//
//        String message;
//        if(httpStatus == null ){
//            message = "Error while communicating with Employee";
//
//        }else {
//            message = "Employee not fond Id: " + employeeId;
//
//        }
//
//
//
//        ApiResponse<Map<Objects, Objects>> apiResponse = new ApiResponse<>("ERROR", message, Collections.EMPTY_MAP);
//
//        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }

    @ExceptionHandler(EmployeeServiceException.class)
    public ResponseEntity<ApiResponse<Map<Object, Object>>> handelServiceException(EmployeeServiceException exception){

        ApiResponse<Map<Object, Object>> apiResponse = new ApiResponse<>("ERROR", exception.getMessage(),Collections.EMPTY_MAP);

        return new ResponseEntity<>(apiResponse, exception.getHttpStatus());


    }

}
