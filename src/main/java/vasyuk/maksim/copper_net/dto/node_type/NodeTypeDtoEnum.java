package vasyuk.maksim.copper_net.dto.node_type;

import lombok.Value;

public enum NodeTypeDtoEnum {
    ;
    public enum Common {
        ;
        @Value
        public static class New implements NodeTypeDtoDep {
            Long id;
            String shortName;
            String longName;
            String description;
        }
    }
}
