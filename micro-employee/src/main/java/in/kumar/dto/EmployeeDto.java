package in.kumar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @NotBlank(message = "Name cannot be empty or blank")
    @Size(min =2, max = 30, message = "Name must be between 2  to 30 chars")
    private String name;

    @NotBlank(message = "Address cannot be empty or blank")
    @Size(min =5, max = 300, message = "Address must be between 5  to 300 chars")
    private String address;

    @DecimalMin(value = "1000.0", message = "Salary must be at least 1000.0")
    @DecimalMax(value = "10000.0", message = "Salary must not exceed  10000.0")
    private double salary;
}
