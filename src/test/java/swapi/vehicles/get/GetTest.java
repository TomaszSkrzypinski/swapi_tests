package swapi.vehicles.get;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import swapi.base.BaseTest;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class GetTest extends BaseTest {

    @Test
    public void getAllVehicles(){

        JsonPath json = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + VEHICLES)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .jsonPath();

        assertThat(json.getList("results").size()).isEqualTo(10);
    }

    @Test
    public void getVehicleById(){

        JsonPath json = given()
                .spec(reqSpec)
                .pathParam("vehicleId", 4)
                .when()
                .get(BASE_URL + VEHICLES + "/{vehicleId}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .jsonPath();

        assertThat(json.getString("max_atmosphering_speed")).isEqualTo("30");
        assertThat(json.getString("cargo_capacity")).isEqualTo("50000");
    }
}