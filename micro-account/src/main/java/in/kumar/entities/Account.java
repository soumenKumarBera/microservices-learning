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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    private String id;

    @Column(unique = true, length = 16)
    private String accNo;

    @Column(length = 16)
    private String bankName;

    @Column(length = 300)
    private String address;

    private String ifsc;

    private String datetime;

    private String employeeId;


}
