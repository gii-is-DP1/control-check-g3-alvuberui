package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	RecoveryRoomRepository roomRepository;
	
	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
    public List<RecoveryRoom> getAll(){
        return roomRepository.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return roomRepository.getRecoveryRoomType(typeName);
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return roomRepository.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return null;       
    }

    
}
