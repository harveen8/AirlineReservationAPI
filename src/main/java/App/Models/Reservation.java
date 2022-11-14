package App.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Reservation {
    @Id
    @Column
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
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
    @JoinColumn(name = "arline")
    Airline airline;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "users")
    Users users;

}
