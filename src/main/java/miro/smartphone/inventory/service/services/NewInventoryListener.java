package miro.smartphone.inventory.service.services;

import miro.smartphone.inventory.service.config.JmsConfig;
import miro.smartphone.inventory.service.domain.SmartphoneInventory;
import miro.smartphone.inventory.service.repositories.SmartphoneInventoryRepository;
import miro.common.events.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class NewInventoryListener {

    private final SmartphoneInventoryRepository smartphoneInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event){

        log.debug("Got Inventory: " + event.toString());

        smartphoneInventoryRepository.save(SmartphoneInventory.builder()
                .smartphoneId(event.getSmartphoneDto().getId())
                .upc(event.getSmartphoneDto().getUpc())
                .quantityOnHand(event.getSmartphoneDto().getQuantityOnHand())
                .build());
    }

}
