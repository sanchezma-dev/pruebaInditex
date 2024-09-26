package app.inditex.infrastructure.apirest.mappers;

import app.inditex.application.domain.Price;
import app.inditex.model.PricesResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesRestMapper {

    PricesResponse toRest(Price price);
}
