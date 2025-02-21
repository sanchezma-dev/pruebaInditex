package app.inditex.e2e;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
    }

    @Test
    public void getProductPrice_01() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("applicationDate", "2020-06-14T10:00:00.000")
                .queryParam("product", 35455)
                .queryParam("brand", 1)
                .when()
                .get("/app/inditex/v1/productPrices")
                .then()
                .statusCode(200)
                .body("productId", equalTo(35455))
                .body("brandId", equalTo(1))
                .body("priceList", notNullValue())
                .body("price", notNullValue());
    }

    @Test
    public void getProductPrice_02() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("applicationDate", "2020-06-14T16:00:00.000")
                .queryParam("product", 35455)
                .queryParam("brand", 1)
                .when()
                .get("/app/inditex/v1/productPrices")
                .then()
                .statusCode(200)
                .body("productId", equalTo(35455))
                .body("brandId", equalTo(1))
                .body("priceList", notNullValue())
                .body("price", notNullValue());
    }

    @Test
    public void getProductPrice_03() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("applicationDate", "2020-06-14T21:00:00.000")
                .queryParam("product", 35455)
                .queryParam("brand", 1)
                .when()
                .get("/app/inditex/v1/productPrices")
                .then()
                .statusCode(200)
                .body("productId", equalTo(35455))
                .body("brandId", equalTo(1))
                .body("priceList", notNullValue())
                .body("price", notNullValue());
    }

    @Test
    public void getProductPrice_04() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("applicationDate", "2020-06-15T10:00:00.000")
                .queryParam("product", 35455)
                .queryParam("brand", 1)
                .when()
                .get("/app/inditex/v1/productPrices")
                .then()
                .statusCode(200)
                .body("productId", equalTo(35455))
                .body("brandId", equalTo(1))
                .body("priceList", notNullValue())
                .body("price", notNullValue());
    }

    @Test
    public void getProductPrice_05() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("applicationDate", "2020-06-16T21:00:00.000")
                .queryParam("product", 35455)
                .queryParam("brand", 1)
                .when()
                .get("/app/inditex/v1/productPrices")
                .then()
                .statusCode(200)
                .body("productId", equalTo(35455))
                .body("brandId", equalTo(1))
                .body("priceList", notNullValue())
                .body("price", notNullValue());
    }
}
