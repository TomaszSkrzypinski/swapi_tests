package swapi.species.get;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import swapi.base.BaseTest;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetTest extends BaseTest {

    @Test
    public void getAllSpecies(){

        JsonPath json = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + SPECIES)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .jsonPath();

        assertThat(json.getList("results").size()).isEqualTo(10);
    }

    @Test
    public void getSpecieById(){

        JsonPath json = given()
                .spec(reqSpec)
                .pathParam("specieId", 4)
                .when()
                .get(BASE_URL + SPECIES + "/{specieId}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .jsonPath();

        assertThat(json.getString("skin_colors")).isEqualTo("green, blue");
        assertThat(json.getString("language")).isEqualTo("Galatic Basic");
    }
}