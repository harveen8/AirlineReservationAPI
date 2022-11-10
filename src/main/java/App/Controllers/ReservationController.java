package App.Controllers;

import App.Models.Reservation;
import App.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReservationController {
    ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService=reservationService;
    }

    @PostMapping("/reservation/{userId}/{airlineId}")
    public Reservation addReservation(@PathVariable("userId") int userId,
                                      @PathVariable("airlineId") int airlineId,
                                      @RequestBody Reservation r){
        return reservationService.addReservation(r, userId, airlineId);
    }
    @GetMapping("/reservation/{id}")
    public Reservation getReservationById(@PathVariable("id") int id){
        return reservationService.getReservationById(id);
    }
    @GetMapping("/reservation")
    public List<Reservation> allReservation(){
        return reservationService.allReservations();
    }
}
