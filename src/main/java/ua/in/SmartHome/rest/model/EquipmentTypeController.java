package ua.in.SmartHome.rest.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ua.in.SmartHome.model.EquipmentType;
import ua.in.SmartHome.service.model.EquipmentTypeService;

@RestController
public class EquipmentTypeController {

	@Autowired
	private EquipmentTypeService equipmentTypeService;

	@PostMapping("/equipmentTypes")
    public EquipmentType putEquipmentType(@RequestBody EquipmentType equipmentType){
        return equipmentTypeService.create(equipmentType);
    }

    @GetMapping("/equipmentTypes")
    public List<EquipmentType> getEquipmentTypes(){
        List<EquipmentType> equipmentTypes = equipmentTypeService.readAll();
        System.out.println(equipmentTypes);
    	return equipmentTypes;
    }

    @PutMapping("/equipmentTypes")
    public Map<String, Object> updateTrip(@RequestBody EquipmentType equipmentType){
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("equipmentType", equipmentTypeService.update(equipmentType));
        response.put("success", true);
        return response;
    }

    @DeleteMapping("/equipmentTypes/{id}")
    public void deleteTrip(@PathVariable int id){
    	equipmentTypeService.delete(id);
}
}
