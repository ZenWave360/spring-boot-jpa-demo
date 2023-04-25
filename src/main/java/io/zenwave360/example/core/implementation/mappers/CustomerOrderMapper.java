package io.zenwave360.example.core.implementation.mappers;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.dtos.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerOrderMapper {

  CustomerOrder asEntity(CustomerOrderInput input);

  @Mapping(target = "id", ignore = true)
  CustomerOrder update(@MappingTarget CustomerOrder entity, CustomerOrderInput input);

  @AfterMapping
  default void manageRelationships(@MappingTarget CustomerOrder entity) {
    entity.getOrderedItems().forEach(orderedItems -> orderedItems.setCustomerOrder(entity));
  }
}
