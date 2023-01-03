package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class InPatient{
    public String appointment;
    public String createdBy;
    public String createdDate;
    public String description;
    public String endDate;
    public int id;
    public String patient;
    public Room room;
    public String startDate;
    public String status;
}