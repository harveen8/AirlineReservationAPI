package App.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Airline {
    @Id
    int airlineId;
    String airlineName;
    List<String> locations;

    @OneToMany(mappedBy = "airline")
    @JsonManagedReference
    List<Reservation> reservationList; //li
}

