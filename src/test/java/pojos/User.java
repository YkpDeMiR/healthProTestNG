package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class User {


        public String createdBy;
        public String createdDate;
        public int id;
        public String login;
        public String firstName;
        public String lastName;
        public String email;
        public boolean activated;
        public String langKey;
        public String imageUrl;
        public String resetDate;
        public String ssn;

}
