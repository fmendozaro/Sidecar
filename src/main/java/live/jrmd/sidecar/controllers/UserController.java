package live.jrmd.sidecar.controllers;

import live.jrmd.sidecar.models.User;
import live.jrmd.sidecar.repositories.POIRepository;
import live.jrmd.sidecar.repositories.RouteRepository;
import live.jrmd.sidecar.repositories.UserRepository;
import live.jrmd.sidecar.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    private final UserRepository userDao;
    private final RouteRepository routeDao;
    private final POIRepository poiDao;
    private final UsersRepository users;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, RouteRepository routeDao, POIRepository poiDao, UsersRepository users, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.routeDao = routeDao;
        this.poiDao = poiDao;
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/logout")
    public String logout(){
        //remove session user
        return "redirect:/index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }
}
