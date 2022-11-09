package App.Controllers;

import App.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

}
