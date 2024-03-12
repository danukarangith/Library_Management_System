package lk.ijse.Entity;

import lk.ijse.Dto.BranchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Branch")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Branch {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "Branch_Id" )
    private int Id;

    @Column( name = "Branch_Name" )
    private String Name;

    @Column( name = "Branch_Location" )
    private String Location;

    @Column( name = "Email" )
    private String Email;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public BranchDto toDto() {
        return new BranchDto(
                this.Id,
                this.Name,
                this.Location,
                this.Email
        );
    }
}
