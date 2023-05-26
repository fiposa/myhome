package Feliks.ALLSecDb.service;

import Feliks.ALLSecDb.repository.GatesRepository;
import org.springframework.stereotype.Service;

@Service
public class GateService {

    public final GatesRepository gatesRepository;

    public GateService(GatesRepository gatesRepository) {
        this.gatesRepository = gatesRepository;
    }
}
