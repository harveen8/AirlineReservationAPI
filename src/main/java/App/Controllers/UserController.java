package App.Controllers;

import App.DTO.validateUser;
import App.Models.Users;
import App.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/user/check")
    public int validateUser(@RequestBody validateUser v){
        return userService.checkCredentials(v);
    }

    @PostMapping("/user")
    public boolean addUser(@RequestBody Users u){
        return userService.addUser(u);
    }

    @GetMapping("/user/{id}")
    public Users getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }



}
