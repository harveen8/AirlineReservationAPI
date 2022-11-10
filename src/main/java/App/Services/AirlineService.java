package App.Services;

import App.Models.Airline;
import App.Repositories.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Component
@CrossOrigin
public class AirlineService {
    public AirlineRepository airlineRepository;
    @Autowired
    public AirlineService(AirlineRepository airlineRepository){
        this.airlineRepository=airlineRepository;
    }

    public List<Airline> allAirlines(){
        return airlineRepository.findAll();
    }

    public Airline addAirline(Airline a){
        return airlineRepository.save(a);
    }

    public Airline getAirlineById(int id){
        return airlineRepository.getReferenceById(id);
    }



}
