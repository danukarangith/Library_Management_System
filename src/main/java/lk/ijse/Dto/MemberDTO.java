package lk.ijse.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MemberDTO {
    private int Id;
    private String name;
    private String Password;
    private String Email;
}
