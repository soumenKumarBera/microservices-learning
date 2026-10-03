package in.kumar.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private String id;


    private String accNo;


    private String bankName;


    private String address;

    private String ifsc;

    private String datetime;

    private String employeeId;
}
