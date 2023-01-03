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
public class Registrant {

        public String login;
        public String firstName;
        public String lastName;
        public String ssn;
        public String email;
        public Object imageUrl;
        public boolean activated;
        public String langKey;
        public String createdBy;
        public String createdDate;
        public String lastModifiedBy;
        public String lastModifiedDate;
        public ArrayList<String> authorities;
}
