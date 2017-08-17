package ua.in.SmartHome.service.model.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import ua.in.SmartHome.model.Equipment;
import ua.in.SmartHome.service.model.AbstractService;
import ua.in.SmartHome.service.model.EquipmentService;

@Transactional
public class EquipmentServiceImpl extends AbstractService<Equipment> implements EquipmentService {
}
