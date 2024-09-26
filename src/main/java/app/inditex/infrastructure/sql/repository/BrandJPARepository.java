package app.inditex.infrastructure.sql.repository;

import app.inditex.infrastructure.sql.models.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandJPARepository extends JpaRepository<BrandEntity, Integer> {


}

