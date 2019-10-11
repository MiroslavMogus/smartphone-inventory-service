package miro.smartphone.inventory.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import miro.smartphone.inventory.service.domain.SmartphoneInventory;
import miro.smartphone.inventory.service.repositories.SmartphoneInventoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

public class SmartphoneInventoryControllerTest {

    public static final UUID SMARTPHONE_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final String SMARTPHONE_1_UPC = "0631234200036";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    SmartphoneInventoryRepository smartphoneInventoryRepository;

    @Test
    void saveNewSmartphone() throws Exception {

        smartphoneInventoryRepository.save(SmartphoneInventory
                .builder()
                .smartphoneId(SMARTPHONE_1_UUID)
                .upc(SMARTPHONE_1_UPC)
                .quantityOnHand(50)
                .build());

    }
}
