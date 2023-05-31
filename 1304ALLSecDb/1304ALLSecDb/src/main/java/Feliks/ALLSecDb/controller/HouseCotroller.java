package Feliks.ALLSecDb.controller;

import Feliks.ALLSecDb.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

//@PreAuthorize("hasRole('USER')")
//@RequestMapping("/house/")

public class HouseCotroller {


    private final HouseService houseService;
    @Autowired

    public HouseCotroller(HouseService houseService) {
        this.houseService = houseService;
    }
    @GetMapping("/house/")
    public String index(Model model) {
        model.addAttribute("houses", houseService.findAll());
        System.out.println("should have seen houses page.");

        return "house/index";
    }

    //@PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/house/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("house", houseService.showConcreteHouse(id));
        return "/house/show";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/house/create")
    public String create (){
        return "/house/create";
    }


}
