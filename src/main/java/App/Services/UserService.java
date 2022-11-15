package App.Services;

import App.DTO.validateUser;
import App.Models.Users;
import App.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Component
@CrossOrigin
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public boolean addUser(Users u){
        if(checkCredentials(u.getEmail(),u.getPassword())!=-1){
            return false;
        }else {
            userRepository.save(u);
            return true;
        }
    }
    public Users getUserById(int id){
        return userRepository.getReferenceById(id);
    }

    public int checkCredentials(validateUser u){
        List<Users> allUsers = userRepository.findAll();
        for(int i =0; i< allUsers.size(); i++){
            if(allUsers.get(i).getEmail().equals(u.getEmail())&&
                    allUsers.get(i).getPassword().equals(u.getPassword())){
                return allUsers.get(i).getUserId();            }
        }
        return -1;
    }
    public int checkCredentials(String email, String pass){
        List<Users> allUsers = userRepository.findAll();
        for(int i =0; i< allUsers.size(); i++){
            if(allUsers.get(i).getEmail().equals(email)  && allUsers.get(i).getPassword().equals(pass)){
                return allUsers.get(i).getUserId();
            }
        }
        return -1;
    }
}
