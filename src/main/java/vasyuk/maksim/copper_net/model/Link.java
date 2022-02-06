package vasyuk.maksim.copper_net.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
//    @UniqueElements
    private String name;
//    @NotNull
//    private String shortName;
//    @NotNull
//    private String longName;
    @NotNull
    private String cableBrand;
    @NotNull
    private Integer cabinetLength;
    @NotNull
    private Integer metalStructursLength;
    @NotNull
    private Integer cableChannelLength;
    @NotNull
    private Integer reserveLength;
    @NotNull
    private Integer parts;
    @NotNull
    private Integer Length;
    @NotNull
    private String description;
}
