package Feliks.ALLSecDb.Service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @PreAuthorize("hasRole('ADMIN')")

    public void adminWrite(){
        System.out.println("Only admin can write it");
    }
}
