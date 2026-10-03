package in.kumar.dto.hybrid;

import in.kumar.dto.EmployeeDto;
import in.kumar.external.AccountDto;
import in.kumar.external.PlotDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.Valid;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeFullDto {

    @Valid
    @NonNull
    private EmployeeDto employeeDto;

    @Valid
    @NonNull
    private AccountDto accountDto;

    @Valid
    @NonNull
    private PlotDto plotDto;
}
