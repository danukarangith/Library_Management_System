package lk.ijse.Entity;


import lk.ijse.Dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Book")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Book_Id")
    private int id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Autor")
    private String autor;

    @Column(name = "Dis")
    private String dis;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "Available")
    private String available;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "book")
    private List<Book_Transaction> details = new ArrayList<>();

    public Books(int id, String title, String autor, String dis, String genre, String available, Admin admin) {
        this.id = id;
        this.title = title;
        this.autor = autor;
        this.dis = dis;
        this.genre = genre;
        this.available = available;
        this.admin = admin;
    }
}
