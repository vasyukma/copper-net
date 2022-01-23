package vasyuk.maksim.copper_net.dto.node_type;

import org.mapstruct.Mapper;

import vasyuk.maksim.copper_net.repository.model.NodeType;

@Mapper
public interface NodeTypeMapper {
//  @Mapping(source = "make", target = "manufacturer")
//  @Mapping(source = "numberOfSeats", target = "seatCount")
  NodeTypeDto carToCarDto(NodeType entity);
}       


//@Mapper
//public interface CarMapper {
//
//    @Mapping(source = "make", target = "manufacturer")
//    @Mapping(source = "numberOfSeats", target = "seatCount")
//    CarDto carToCarDto(Car car);
//
//    @Mapping(source = "name", target = "fullName")
//    PersonDto personToPersonDto(Person person);
//}