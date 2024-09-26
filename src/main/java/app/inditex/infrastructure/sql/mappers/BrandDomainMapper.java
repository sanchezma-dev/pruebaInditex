package app.inditex.infrastructure.sql.mappers;

import app.inditex.application.domain.Brand;
import app.inditex.infrastructure.sql.models.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandDomainMapper {

    Brand toDomain(BrandEntity entity);

    BrandEntity toBrandEntity(Brand brand);
}
