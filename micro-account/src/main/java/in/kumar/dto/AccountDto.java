package in.kumar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {


    @NotBlank(message = "accNo. cannot be empty or blank")
    @Pattern(regexp = "\\d{16}", message = "Account no must be exactly 16 digits")
    private String accNo;

    @NotBlank(message = "Bank name cannot be empty or blank")
    @Size(min = 2, max = 30, message = "Bank Name must be between 2 to 30 chars")
    private String bankName;

    @NotBlank(message = "Address cannot be empty or blank")
    @Size(min = 2, max = 300, message = "Bank Name must be between 2 to 300 chars")
    private String address;

    @NotBlank(message = "Ifsc cannot be empty or blank")
    private String ifsc;

    @NotBlank(message = "EmployeeId cannot be empty or blank")
    private String employeeId;
}
