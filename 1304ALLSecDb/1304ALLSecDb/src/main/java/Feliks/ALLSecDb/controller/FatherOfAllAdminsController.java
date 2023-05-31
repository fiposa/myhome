package Feliks.ALLSecDb.controller;

import Feliks.ALLSecDb.model.User;
import Feliks.ALLSecDb.repository.UserRepository;
import Feliks.ALLSecDb.service.SendEmailService;
import Feliks.ALLSecDb.utils.PersonNotCreatedException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@PreAuthorize("hasRole('FATHER')")
@RequestMapping("/father/")

public class FatherOfAllAdminsController {

    @Autowired
    private SendEmailService sendEmailService;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;//заинжектили энкодер в этот класс, добавили в конструктор


   @Autowired
    public FatherOfAllAdminsController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("")

    public String hello() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getCredentials());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());

        sendEmailService.sendEmail("fiposa@inbox.ru", "Greeting to father", "Father is logged in");







        return "Hello, father of all admins!!!!!!!";
    }


    @GetMapping("allAdmins")//Выводим список всех админов.
    public List<User> viewAllAdmins() {
        return userRepository.findAll().stream().filter(user -> user.getRole()
                .equals("ROLE_ADMIN")).collect(Collectors.toList());
    }

    @GetMapping("all")//Выводим список всех пользователей из базы
    public List<User> viewAll() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return userRepository.findAll().stream().toList();
    }

    @GetMapping("delete/{username}")
    public List<User> deleteUser(@PathVariable String username){
        userRepository.deleteByUsername(username); //создали метод в репозитории

        return userRepository.findAll().stream().toList();
    }


    //ОБЯЗАТЕЛЬНО при пост запросе в постмане проверить, что он шлет json, а не текст, иначе ошиьбка 400 или 415
    @PostMapping //можно было вместо ResponseEntity<HttpStatus> набрать Person, BindingResult - для проверки валидности
    public ResponseEntity<HttpStatus> createPerson(@RequestBody @Valid User user,//после изучения дто поставили тут персондто вместо персон
                                                   BindingResult bindingResult
                                                   ){
        if (bindingResult.hasErrors()){ //если ошибки валидации
            StringBuilder errorMsg = new StringBuilder();//Создаем строку
            List <FieldError> errors = bindingResult.getFieldErrors(); // собираем лист всех ошибок
            for (FieldError error: errors){//конкатинируем строку для
                errorMsg.append(error.getField()).append("-").append(error.getDefaultMessage()).append(";");
            }
            throw new PersonNotCreatedException(errorMsg.toString());
        }
        //Энкодим пароль от полученного юзера перед сохранением в базу
        user.setPassword(passwordEncoder.encode(user.getPassword()));


        userRepository.save(user); // сохраняем человека в базу, если не было ошибок
        return ResponseEntity.ok(HttpStatus.OK); // Чтоб не создавать объект,
        // вернем сообщение, что всё ок(пустое тело, статус 200).
    }

}
