package miro.smartphone.inventory.service.web.mappers;

import javax.annotation.processing.Generated;
import miro.smartphone.inventory.service.domain.SmartphoneInventory;
import miro.smartphone.inventory.service.domain.SmartphoneInventory.SmartphoneInventoryBuilder;
import miro.smartphone.inventory.service.web.model.SmartphoneInventoryDto;
import miro.smartphone.inventory.service.web.model.SmartphoneInventoryDto.SmartphoneInventoryDtoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-11T15:51:47+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (JetBrains s.r.o)"
)
@Component
public class SmartphoneInventoryMapperImpl implements SmartphoneInventoryMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public SmartphoneInventory smartphoneInventoryDtoToSmartphoneInventory(SmartphoneInventoryDto smartphoneInventoryDTO) {
        if ( smartphoneInventoryDTO == null ) {
            return null;
        }

        SmartphoneInventoryBuilder smartphoneInventory = SmartphoneInventory.builder();

        smartphoneInventory.id( smartphoneInventoryDTO.getId() );
        smartphoneInventory.createdDate( dateMapper.asTimestamp( smartphoneInventoryDTO.getCreatedDate() ) );
        smartphoneInventory.lastModifiedDate( dateMapper.asTimestamp( smartphoneInventoryDTO.getLastModifiedDate() ) );
        smartphoneInventory.smartphoneId( smartphoneInventoryDTO.getSmartphoneId() );
        smartphoneInventory.upc( smartphoneInventoryDTO.getUpc() );
        smartphoneInventory.quantityOnHand( smartphoneInventoryDTO.getQuantityOnHand() );

        return smartphoneInventory.build();
    }

    @Override
    public SmartphoneInventoryDto smartphoneInventoryToSmartphoneInventoryDto(SmartphoneInventory smartphoneInventory) {
        if ( smartphoneInventory == null ) {
            return null;
        }

        SmartphoneInventoryDtoBuilder smartphoneInventoryDto = SmartphoneInventoryDto.builder();

        smartphoneInventoryDto.id( smartphoneInventory.getId() );
        smartphoneInventoryDto.createdDate( dateMapper.asOffsetDateTime( smartphoneInventory.getCreatedDate() ) );
        smartphoneInventoryDto.lastModifiedDate( dateMapper.asOffsetDateTime( smartphoneInventory.getLastModifiedDate() ) );
        smartphoneInventoryDto.smartphoneId( smartphoneInventory.getSmartphoneId() );
        smartphoneInventoryDto.upc( smartphoneInventory.getUpc() );
        smartphoneInventoryDto.quantityOnHand( smartphoneInventory.getQuantityOnHand() );

        return smartphoneInventoryDto.build();
    }
}
