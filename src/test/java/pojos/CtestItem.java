package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class CtestItem{
    public String createdBy;
    public String createdDate;
    public String defaultValMax;
    public String defaultValMin;
    public String description;
    public int id;
    public String name;
    public int price;
}