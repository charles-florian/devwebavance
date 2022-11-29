package be.heh.projet_dev_web.adaptater.in;

import be.heh.projet_dev_web.port.in.UserListUseCase;
import lombok.RequiredArgsConstructor;
import be.heh.projet_dev_web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    ModelAndView m = new ModelAndView();
    private final UserListUseCase userlistusecase;



    private List<User> users;

    @GetMapping("/")
    public ModelAndView Users(Model model){
        //users =userlistusecase.getUserList();
        //model.addAttribute("user",users);
        m.setViewName("userList");
        return m;


    }
}
