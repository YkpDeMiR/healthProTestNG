package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class Patient{
    public String adress;
    public ArrayList<String> appointments;
    public String birthDate;
    public String bloodGroup;
    public Country country;
    public String createdBy;
    public String createdDate;
    public Cstate cstate;
    public String description;
    public String email;
    public String firstName;
    public String gender;
    public int id;
    public ArrayList<InPatient> inPatients;
    public String lastName;
    public String phone;
    public String ssn;
    public User user;
}