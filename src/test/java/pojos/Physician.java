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
public class Physician {
    public String adress;
    public ArrayList<String> appointments;
    public String birthDate;
    public String bloodGroup;
    public Country country;
    public String createdBy;
    public String createdDate;
    public Cstate cstate;
    public String description;
    public int examFee;
    public String firstName;
    public String gender;
    public int id;
    public String image;
    public String imageContentType;
    public String lastName;
    public String phone;
    public String speciality;
    public String ssn;
    public User user;
}
