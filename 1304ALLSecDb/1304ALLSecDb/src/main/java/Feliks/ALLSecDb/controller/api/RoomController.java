package Feliks.ALLSecDb.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @GetMapping("/")
     String HelloApi(){
        return "Welcome to API page!";
    }
    @PostMapping("/")

    public ResponseEntity<HttpStatus> gettingJsonfromOutside(@RequestBody String string,//запрашиваем строку из пост запроса
                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { //если ошибки валидации
            StringBuilder errorMsg = new StringBuilder();//Создаем строку
            List<FieldError> errors = bindingResult.getFieldErrors(); // собираем лист всех ошибок
            for (FieldError error : errors) {//конкатинируем строку для
                errorMsg.append(error.getField()).append("-").append(error.getDefaultMessage()).append(";");
            }
            throw new RuntimeException();
        }
        System.out.println(string);
        // String string2 = objectMapper.readValue(new URL("file:src/test/resources/json_car.json"), Car.class);
        return ResponseEntity.ok(HttpStatus.OK);
    }






}
