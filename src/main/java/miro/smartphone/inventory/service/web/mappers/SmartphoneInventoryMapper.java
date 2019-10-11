package miro.smartphone.inventory.service.web.mappers;

import miro.smartphone.inventory.service.domain.SmartphoneInventory;
import miro.smartphone.inventory.service.web.model.SmartphoneInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface SmartphoneInventoryMapper {

    SmartphoneInventory smartphoneInventoryDtoToSmartphoneInventory(SmartphoneInventoryDto smartphoneInventoryDTO);

    SmartphoneInventoryDto smartphoneInventoryToSmartphoneInventoryDto(SmartphoneInventory smartphoneInventory);
}
