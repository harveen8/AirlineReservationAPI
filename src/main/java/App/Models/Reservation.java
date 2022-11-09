package App.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @Column
    int reservationId;
    @Column
    String departureCity;
    @Column
    String arrivalCity;
    @Column
    Date departure;
    @Column
    Date arrival;
    @Column
    int price;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "airlineId")
    Airline airline;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "userId")
    Users users;

}
