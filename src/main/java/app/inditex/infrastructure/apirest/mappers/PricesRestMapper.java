package app.inditex.infrastructure.apirest.mappers;

import app.inditex.application.domain.Price;
import app.inditex.model.PricesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricesRestMapper {

    @Mapping(source = "finalPrice", target = "price")
    PricesResponse toRest(Price price);
}
