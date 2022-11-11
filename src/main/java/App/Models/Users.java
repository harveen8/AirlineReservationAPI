package App.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @Column
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    int userId;
    @Column
    String email;
    @Column
    String password;
    @Column
    String name;

    @OneToMany(mappedBy = "users")
    List<Reservation> reservationList; //linked with the review table

}

