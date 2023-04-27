package Feliks.ALLSecDb.Controller;

import Feliks.ALLSecDb.Service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private SendEmailService sendEmailService;


    @RequestMapping("signup")
    public String signup(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());

        sendEmailService.sendEmail("fiposa@inbox.ru", "dddddd","dddddd");

        return "signup successful. Sending email to fiposa@inbox.ru";

    }



}
