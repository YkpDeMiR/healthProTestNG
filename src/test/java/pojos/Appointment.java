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
public class Appointment {
    public String anamnesis;
    public String createdBy;
    public String createdDate;
    public ArrayList<Ctest> ctests;
    public String description;
    public String diagnosis;
    public String endDate;
    public int id;
    public Patient patient;
    public Physician physician;
    public String prescription;
    public String startDate;
    public String status;
    public String treatment;
}
