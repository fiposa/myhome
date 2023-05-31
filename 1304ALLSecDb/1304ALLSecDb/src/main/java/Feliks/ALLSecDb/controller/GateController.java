package Feliks.ALLSecDb.controller;

import Feliks.ALLSecDb.model.Gate;
import Feliks.ALLSecDb.model.House;
import Feliks.ALLSecDb.service.GateService;
import Feliks.ALLSecDb.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GateController {

    private final GateService gateService;
    private final HouseService houseService;

    @Autowired

    public GateController(GateService gateService, HouseService houseService) {
        this.gateService = gateService;
        this.houseService = houseService;
    }

    @GetMapping("/gates/")
    public String index(Model model) {
        model.addAttribute("gates", gateService.viewAllGates());
        System.out.println("should have seen gates page.");

        return "gates/index";
    }

   // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/gates/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("gate", gateService.findConcreteGate(id));
        return "/gates/show";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/gates/new")
    public String newGate (@ModelAttribute ("gate") Gate gate, @ModelAttribute ("house") House house,
                           Model model){
        model.addAttribute("houses", houseService.findAll());

        return "/gates/new";
    }
    @PostMapping("/gates")
    public String create (@ModelAttribute ("gate") Gate gate){
        gateService.save(gate);
        return "redirect:/gates/";

    }


}

