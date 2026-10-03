package in.kumar.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlotResponse {

    private String id;


    private String area;


    private String coloneyName;


    private String cityName;

    private int pinCode;

    private String datetime;

    private String employeeId;
}
