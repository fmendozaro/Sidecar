package live.jrmd.sidecar.controllers;

import live.jrmd.sidecar.models.Event;
import live.jrmd.sidecar.repositories.EventRepository;
import live.jrmd.sidecar.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventController {
    private final EventRepository eventDao;
    private final UserRepository userDao;

    public EventController(EventRepository eventDao, UserRepository userDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
    }

    @GetMapping("/events")
    public String showAllEvents(Model model){
        model.addAttribute("events", eventDao.findAll());
        return "events/index";
    }
    @GetMapping("/searchEvents")
    public String search(@RequestParam(name = "term") String term, Model model){
        term = "%"+term+"%";
        List searchEvents = eventDao.findAllByNameIsLike(term);
        model.addAttribute("routes", searchEvents);
        return "events/index";
    }
}
