package in.kumar.exception;

import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
public class EmployeeServiceException extends RuntimeException{

    private final   HttpStatus httpStatus;

    public EmployeeServiceException(String message, HttpStatus httpStatus , FeignException e) {
        super(message, e);
        this.httpStatus = httpStatus;
    }


}
