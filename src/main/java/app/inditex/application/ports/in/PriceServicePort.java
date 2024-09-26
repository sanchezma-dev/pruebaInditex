package app.inditex.application.ports.in;

import app.inditex.application.domain.Price;

import java.time.LocalDateTime;

public interface PriceServicePort {

    Price getProductPrices(LocalDateTime applicationDate, Integer productId, Integer brandId);

}
