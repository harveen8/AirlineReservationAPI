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
    int userId;
    @Column
    String email;
    @Column
    String password;
    @Column
    String name;

    @OneToMany(mappedBy = "users")
    @JsonManagedReference
    List<Reservation> reservationList; //linked with the review table

}

