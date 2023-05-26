package Feliks.ALLSecDb.service;

import Feliks.ALLSecDb.model.Room;
import Feliks.ALLSecDb.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class RoomService {

    private final RoomRepository roomRepository;
    private final Room room;

    public RoomService(RoomRepository roomRepository, Room room) {
        this.roomRepository = roomRepository;
        this.room = room;
    }

    public Optional<Room>  changeValue(Integer Co2LevelMaxValue, Integer Co2LevelMinValue,
                                       Optional<Room> room){
        room.get().setCo2LevelMax(Co2LevelMaxValue);
        room.get().setCo2LevelMin(Co2LevelMinValue);

        return room;
    }



}
