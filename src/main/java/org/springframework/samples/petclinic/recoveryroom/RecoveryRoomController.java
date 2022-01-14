package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RecoveryRoomController {
    
	@Autowired
    RecoveryRoomService roomService;
    
    @GetMapping("/recoveryroom/create")
	public String createRoom(Map<String, Object> model) {
    	RecoveryRoom recoveryRoom = new RecoveryRoom();
    	List<RecoveryRoomType> roomTypes = roomService.getAllRecoveryRoomTypes();
		model.put("recoveryRoom", recoveryRoom);
		model.put("roomTypes", roomTypes);
        return "recoveryroom/createOrUpdateRecoveryRoomForm";
	}
    
    @PostMapping(value = "/recoveryroom/create")
	public String createProduct(@Valid RecoveryRoom room, BindingResult result,ModelMap model) {
		if (result.hasErrors()) {
			return "recoveryroom/createOrUpdateRecoveryRoomForm"; 
		} else {
			this.roomService.save(room);
			return "welcome";
		}
	}
}
