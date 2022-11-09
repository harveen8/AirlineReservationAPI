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
public class User {
    @Id
    int userId;
    String email;
    String password;
    String name;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    List<Reservation> reservationList; //linked with the review table

}
