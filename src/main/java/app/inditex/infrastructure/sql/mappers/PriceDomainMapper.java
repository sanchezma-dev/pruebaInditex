package app.inditex.infrastructure.sql.mappers;

import app.inditex.application.domain.Price;
import app.inditex.infrastructure.sql.models.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceDomainMapper {

    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "price", target = "finalPrice")
    Price toDomain(PriceEntity entity);
}
