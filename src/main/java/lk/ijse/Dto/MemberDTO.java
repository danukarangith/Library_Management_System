package lk.ijse.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MemberDTO {
    private int Id;
    private String full_name;
    private String username;
    private String Password;
    private String Email;
}
