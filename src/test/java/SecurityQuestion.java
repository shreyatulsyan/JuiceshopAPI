import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class SecurityQuestion {
    private int id;
    private String question;
    private String createdAt;
    private String updatedAt;

}
