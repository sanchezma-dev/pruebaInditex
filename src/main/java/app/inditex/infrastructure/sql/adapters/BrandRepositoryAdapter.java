package app.inditex.infrastructure.sql.adapters;

import app.inditex.application.domain.Brand;
import app.inditex.application.ports.out.BrandRepositoryPort;
import app.inditex.infrastructure.sql.mappers.BrandDomainMapper;
import app.inditex.infrastructure.sql.repository.BrandJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandRepositoryAdapter implements BrandRepositoryPort {

    private final BrandJPARepository repository;
    private final BrandDomainMapper mapper;

    @Override
    public Brand findBrand(Integer brandId) {
        return mapper.toDomain(repository.findById(brandId).orElse(null));
    }
}
