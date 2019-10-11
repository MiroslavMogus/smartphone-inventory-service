package miro.smartphone.inventory.service.bootstrap;

import miro.smartphone.inventory.service.domain.SmartphoneInventory;
import miro.smartphone.inventory.service.repositories.SmartphoneInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class SmartphoneInventoryBootstrap implements CommandLineRunner {

    public static final String SMARTPHONE_1_UPC = "0631234200036";
    public static final String SMARTPHONE_2_UPC = "0631234300019";
    public static final String SMARTPHONE_3_UPC = "0083783375213";
    public static final UUID SMARTPHONE_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID SMARTPHONE_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID SMARTPHONE_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

    private final SmartphoneInventoryRepository smartphoneInventoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if(smartphoneInventoryRepository.count() == 0){
            loadInitialInv();
        }
    }

    private void loadInitialInv() {
        smartphoneInventoryRepository.save(SmartphoneInventory
                .builder()
                .smartphoneId(SMARTPHONE_1_UUID)
                .upc(SMARTPHONE_1_UPC)
                .quantityOnHand(50)
                .build());

        smartphoneInventoryRepository.save(SmartphoneInventory
                .builder()
                .smartphoneId(SMARTPHONE_2_UUID)
                .upc(SMARTPHONE_2_UPC)
                .quantityOnHand(50)
                .build());

        smartphoneInventoryRepository.saveAndFlush(SmartphoneInventory
                .builder()
                .smartphoneId(SMARTPHONE_3_UUID)
                .upc(SMARTPHONE_3_UPC)
                .quantityOnHand(50)
                .build());

        log.debug("Loaded Inventory. Record count: " + smartphoneInventoryRepository.count());
    }
}
