package app.inditex.application.ports.out;

import app.inditex.application.domain.Brand;

public interface BrandRepositoryPort {

    Brand findBrand(Integer brandId);
}
