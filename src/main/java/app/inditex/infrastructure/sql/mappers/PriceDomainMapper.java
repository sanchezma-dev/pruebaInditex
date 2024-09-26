package app.inditex.infrastructure.sql.mappers;

import app.inditex.application.domain.Price;
import app.inditex.infrastructure.sql.models.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDomainMapper {

    Price toDomain(PriceEntity entity);
}
