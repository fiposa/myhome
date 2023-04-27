package Feliks.ALLSecDb;

import Feliks.ALLSecDb.Model.House;
import Feliks.ALLSecDb.Model.Room;
import Feliks.ALLSecDb.Model.User;
import Feliks.ALLSecDb.Repository.HouseRepository;
import Feliks.ALLSecDb.Repository.RoomRepository;
import Feliks.ALLSecDb.Repository.UserRepository;
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
										HouseRepository houseRepository, RoomRepository roomRepository) {
		return args -> {

			//Если написать не ROLE_ADMIN, а ADMIN, то не будет работать, и в юзере поле д.б. именно role, а не roles

			users.save(new User("fiposa", encoder.encode("pass"), "ROLE_USER", "fiposa@inbox.ru"));
			users.save(new User("admin", encoder.encode("pass"), "ROLE_ADMIN", "admin@ma.ru"));
			users.save(new User("father", encoder.encode("pass"), "ROLE_FATHER, ROLE_ADMIN", "father@mail.ru"));

			houseRepository.save(new House("house1","dddjhdbd12"));
			houseRepository.save(new House("house2","dddjhdbd1222"));

//			roomRepository.save(new Room("room1",23,45,45,
//					true));
//			roomRepository.save(new Room("room2",23,45,45,
//					true));
//			roomRepository.save(new Room("room1",23,45,45,
//					true));
//			roomRepository.save(new Room("room2",23,45,45,
//					true));
			roomRepository.save(new Room("room3",23,45,45,
					true)).setHouse(houseRepository.findHouseByHouseName("house1").orElseThrow());








		};
	}


}
