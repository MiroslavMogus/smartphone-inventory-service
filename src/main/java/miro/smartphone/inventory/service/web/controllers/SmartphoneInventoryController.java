package miro.smartphone.inventory.service.web.controllers;

import miro.smartphone.inventory.service.repositories.SmartphoneInventoryRepository;
import miro.smartphone.inventory.service.web.mappers.SmartphoneInventoryMapper;
import miro.smartphone.inventory.service.web.model.SmartphoneInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@RestController
public class SmartphoneInventoryController {

    private final SmartphoneInventoryRepository smartphoneInventoryRepository;
    private final SmartphoneInventoryMapper smartphoneInventoryMapper;

    @GetMapping("api/v1/smartphone/{smartphoneId}/inventory")
    List<SmartphoneInventoryDto> listSmartphonesById(@PathVariable UUID smartphoneId){
        log.debug("Finding Inventory for smartphoneId:" + smartphoneId);

        return smartphoneInventoryRepository.findAllBySmartphoneId(smartphoneId)
                .stream()
                .map(smartphoneInventoryMapper::smartphoneInventoryToSmartphoneInventoryDto)
                .collect(Collectors.toList());
    }
}
