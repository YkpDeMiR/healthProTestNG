package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class AppointmentRequest {

    public String appoSpeciality;
    public String birthDate;
    public String email;
    public String firstName;
    public String gender;
    public String lastName;
    public String phone;
    public String snumber;
    public String ssn;
    public String startDate;

}
