package App.Services;

import App.Models.Airline;
import App.Models.Reservation;
import App.Models.Users;
import App.Repositories.AirlineRepository;
import App.Repositories.ReservationRepository;
import App.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Component
@CrossOrigin
public class ReservationService {
    public ReservationRepository reservationRepository;
    public AirlineRepository airlineRepository;
    public UserRepository userRepository;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository, AirlineRepository airlineRepository, UserRepository userRepository){
        this.reservationRepository=reservationRepository;
        this.airlineRepository=airlineRepository;
        this.userRepository=userRepository;
    }

    public List<Reservation> allReservations(){
        return reservationRepository.findAll();
    }

    public Reservation addReservation(Reservation r, int userId, int airlineId){
        Users u = userRepository.getReferenceById(userId);
        Airline a = airlineRepository.getReferenceById(airlineId);
        r.setAirline(a);
        r.setUsers(u);
       return reservationRepository.save(r);
    }

    public Reservation getReservationById(int id){
        return reservationRepository.getReferenceById(id);
    }

}
