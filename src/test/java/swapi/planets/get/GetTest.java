package swapi.planets.get;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import swapi.base.BaseTest;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetTest extends BaseTest {

    @Test
    public void getAllPlanets(){

        JsonPath json = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + PLANETS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .jsonPath();

        assertThat(json.getList("results").size()).isEqualTo(10);
    }

    @Test
    public void getPlanetById(){

        JsonPath json = given()
                .spec(reqSpec)
                .pathParam("planetId", 1)
                .when()
                .get(BASE_URL + PLANETS + "/{planetId}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .jsonPath();

        assertThat(json.getString("edited")).isEqualTo("2014-12-20T20:58:18.411000Z");
        assertThat(json.getString("rotation_period")).isEqualTo("23");
    }
}