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
public class Ctest{
    public String appointment;
    public String createdBy;
    public String createdDate;
    public ArrayList<CtestResult> ctestResults;
    public String date;
    public String description;
    public int id;
    public String name;
}