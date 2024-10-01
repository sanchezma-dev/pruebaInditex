package app.inditex.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerAdapterTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Should get Price the price of the product")
    public void getPriceOk() throws Exception {
        mvc.perform(get("/app/inditex/v1/productPrices")
                        .param("applicationDate", "2020-06-14T10:00:00.000")
                        .param("product", "35455")
                        .param("brand", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                          "productId": 35455,
                          "brandId": 1,
                          "priceList": 1,
                          "startDate": "2020-06-14T00:00:00",
                          "endDate": "2020-12-31T23:59:59",
                          "price": "35.5"
                        }
                        """));
    }

    @Test
    @DisplayName("Should get a exception: 404")
    public void getPriceNotFound() throws Exception {
        mvc.perform(get("/app/inditex/v1/productPrices")
                        .param("applicationDate", "2020-06-14T10:00:00.000")
                        .param("product", "12")
                        .param("brand", "1"))
                .andExpect(status().isNotFound());
    }
}
