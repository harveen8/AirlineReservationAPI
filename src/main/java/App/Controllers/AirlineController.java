package App.Controllers;

import App.Models.Airline;
import App.Services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AirlineController {
    AirlineService airlineService;
    @Autowired
    public AirlineController(AirlineService airlineService){
        this.airlineService=airlineService;
    }

    @GetMapping("/airline")
    public List<Airline> allAirlines(){
        return airlineService.allAirlines();
    }

    @GetMapping("/airline/{id}")
    public Airline getAirline(@PathVariable("id") int id){
        return airlineService.getAirlineById(id);
    }

    @PostMapping(value="/airline")
    public Airline addAirline(@RequestBody Airline airline){
        return airlineService.addAirline(airline);
    }
}
