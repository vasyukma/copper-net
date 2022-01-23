package vasyuk.maksim.copper_net.dto.node;

import lombok.Value;

public enum NodeDtoEnum {
    ;
    public enum Common {
        ;
        @Value
        public static class New implements NodeDto {
            Long id;
            String shortName;
            String longName;
            String description;
            Long typeId;
            Long parentId;
        }
    }

    public enum Special {
        ;
        @Value
        public static class Root implements NodeDtoRoot {
            Long id;
            String shortName;
            String longName;
            String description;
            Long typeId;
        }
    }
}