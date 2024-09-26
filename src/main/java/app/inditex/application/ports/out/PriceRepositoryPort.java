package app.inditex.application.ports.out;

import app.inditex.application.domain.Price;

import java.time.LocalDateTime;

public interface PriceRepositoryPort {

    Price findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brand);
}
