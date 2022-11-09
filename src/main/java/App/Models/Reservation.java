package App.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    int reservationId;
    String departureCity;
    String arrivalCity;
    Date departure;
    Date arrival;
    int price;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "airline_airline_id")
    Airline airline;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_user_id")
    User user;

}
