package vasyuk.maksim.copper_net.dto;

import lombok.Value;

@Value
public class CableListItemDto {
    private LinkDto link;
    private String roomName;
    private String socketNumber;
    private String telecommunicationsClosetNumber;
    private String patchPanelNumber;
    private String portNumber; 
}
