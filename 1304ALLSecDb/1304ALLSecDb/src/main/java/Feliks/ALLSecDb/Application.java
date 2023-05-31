package Feliks.ALLSecDb;

import Feliks.ALLSecDb.model.Gate;
import Feliks.ALLSecDb.model.House;
import Feliks.ALLSecDb.model.Room;
import Feliks.ALLSecDb.model.User;
import Feliks.ALLSecDb.repository.GatesRepository;
import Feliks.ALLSecDb.repository.HouseRepository;
import Feliks.ALLSecDb.repository.RoomRepository;
import Feliks.ALLSecDb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication




public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder,
										HouseRepository houseRepository, RoomRepository roomRepository,
										GatesRepository gatesRepository) {
		return args -> {

//			houseRepository.save(new House("House1",null,
//					"Pervomayka917", null,null));
//			houseRepository.save(new House("House2",null,
//					"Lenina525", null,null));

			/*gatesRepository.save(new Gate("Vrata1",false,
					houseRepository.findById(1).orElse(null) ));

			gatesRepository.save(new Gate("Vrata2",true,
					houseRepository.findById(2).orElse(null) ));*/



			//Если написать не ROLE_ADMIN, а ADMIN, то не будет работать, и в юзере поле д.б. именно role, а не roles

			//users.save(new User("fiposa", encoder.encode("pass"), "ROLE_USER", "fiposa@inbox.ru"));
			//users.save(new User("admin", encoder.encode("pass"), "ROLE_ADMIN", "admin@ma.ru"));
			//users.save(new User("father", encoder.encode("pass"), "ROLE_FATHER, ROLE_ADMIN", "father@mail.ru"));

			//houseRepository.save(new House("house1","dddjhdbd12"));
			//houseRepository.save(new House("house2","dddjhdbd1222"));

			//roomRepository.save(new Room("room25",23,45,45,true,houseRepository.findHouseByHouseName("house2").orElseThrow()));
//			roomRepository.save(new Room("room2",23,45,45,
//					true));
//			roomRepository.save(new Room("room1",23,45,45,
//					true));
//			roomRepository.save(new Room("room2",23,45,45,
//					true));
//			roomRepository.save(new Room("room3",23,45,45,
//					true)).setHouse(houseRepository.findHouseByHouseName("house1").orElseThrow());








		};
	}


}
