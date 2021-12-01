import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@Builder
@Data
public class CustomerDetails {
    private String email;
    private String password;
    private String repeatPassword;
    private SecurityQuestion secutyQues;
    private String securityAns;
}
