package in.kumar.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plot {

    @Id
    private String id;

    @Column( length = 30)
    private String area;

    @Column(length = 100)
    private String coloneyName;

    @Column(length = 100)
    private String cityName;

    private int pinCode;

    private String datetime;

    private String employeeId;
}
