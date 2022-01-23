package vasyuk.maksim.copper_net.dto.node_type;

import lombok.Value;

public enum NodeTypeDto {
    ;
    public enum Common {
        ;
        @Value
        public static class Creator implements NodeTypeDtoCommon {
            Long id;
            String shortName;
            String longName;
            String description;
        }
    }
}
