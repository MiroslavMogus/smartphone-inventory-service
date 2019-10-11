package miro.common.events;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends SmartphoneEvent {
    public NewInventoryEvent(SmartphoneDto smartphoneDto) {
        super(smartphoneDto);
    }
}
