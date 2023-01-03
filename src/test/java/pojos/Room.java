package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class Room{
    public String createdBy;
    public String createdDate;
    public String description;
    public int id;
    public int price;
    public int roomNumber;
    public String roomType;
    public boolean status;
}