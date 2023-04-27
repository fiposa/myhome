package Feliks.ALLSecDb.Config;

import Feliks.ALLSecDb.Service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final MyUserDetailsService myUserDetailsService;

    public SecurityConfig(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())//если не задисейблить, то не будет пропускать пост запросы от постмана
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/").permitAll()//можно вообще всем
                        //.requestMatchers("/all").hasAnyRole("ADMIN","USER","GOD")//Можно любому из этих
                        //.requestMatchers("/admin").hasRole("ADMIN")//тут не надо писать ROLE_ADMIN, а если писать hasAuthority, то как в таблице, так и тут
                        //.requestMatchers("/user").hasRole("USER")
                        //.requestMatchers("/god").hasRole("GOD") УБРАЛ ФИЛЬТРАЦИЮ В КОНТРОЛЛЕР (АННОТАЦИИ)
                        .anyRequest().permitAll())//можно только залогиненным
                .userDetailsService(myUserDetailsService)
                .headers(headers->headers.frameOptions().sameOrigin())
                .httpBasic(withDefaults())
                .build();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance(); Это чтоб не шифровался пароль
        return new  BCryptPasswordEncoder();
    }

}
