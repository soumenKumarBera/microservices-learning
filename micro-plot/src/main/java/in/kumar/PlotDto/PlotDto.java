package in.kumar.PlotDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.Message;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlotDto {

    @NotBlank(message = "Area cannot be empty or blank")
    @Size(min = 2, max = 30, message = "Area must be between 2 to 30 chars")
    private String area;

    @NotBlank(message = "coloneyName cannot be empty or blank")
    @Size(min = 2, max = 100, message = "Bank Name must be between 2 to 100 chars")
    private String coloneyName;

    @NotBlank(message = "cityName cannot be empty or blank")
    @Size(min = 2, max = 100, message = "cityName must be between 2 to 100 chars")
    private String cityName;

    @Min(value = 100000 , message = "Pincode must be at exactly 6 digit" )
    @Max(value = 999999 , message = "Pincode must be at exactly 6 digit" )
    private int pinCode;

    @NotBlank(message = "employeeId cannot be empty or blank")
    private String employeeId;

}
