package wasteless.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import wasteless.model.*;
import wasteless.service.*;

@Controller
public class LogInController {

    private final UserService userService;

    @Autowired
    public LogInController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String start(Model model){
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    private String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model){

        User user = userService.findUser(username, password);
        if(user!=null)
        {
            model.addAttribute("idUser", user.getIdUser());
            return "groceryList";
        }

        return "login";
    }
}
