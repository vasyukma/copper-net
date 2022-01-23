package vasyuk.maksim.copper_net.dto.node;

import lombok.Value;

public enum NodeDto {
    ;
    public enum Common {
        ;
        @Value
        public static class Creater implements NodeDtoCommon {
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
        public static class RootCreater implements NodeDtoRoot {
            Long id;
            String shortName;
            String longName;
            String description;
            Long typeId;
        }
    }
}