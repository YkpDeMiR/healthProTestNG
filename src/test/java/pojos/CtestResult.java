package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class CtestResult{
    public String createdBy;
    public String createdDate;
    public String ctest;
    public CtestItem ctestItem;
    public String date;
    public String description;
    public int id;
    public String result;
}