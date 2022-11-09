package App.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Airline {
    @Id
    @Column
    int airlineId;
    @Column
    String airlineName;

    @OneToMany(mappedBy = "airline")
    @JsonManagedReference
    List<Reservation> reservationList;
}

