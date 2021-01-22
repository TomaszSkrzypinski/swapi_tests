package swapi.people.get;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import swapi.base.BaseTest;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetTest extends BaseTest {

    @Test
    public void getAllPeople(){

        JsonPath json = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + PEOPLE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .jsonPath();

        assertThat(json.getList("results").size()).isEqualTo(10);
    }

    @Test
    public void getPeopleById(){

        JsonPath json = given()
                .spec(reqSpec)
                .pathParam("peopleId", 1)
                .when()
                .get(BASE_URL + PEOPLE + "/{peopleId}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .jsonPath();

        System.out.println(json.prettyPrint());

        assertThat(json.getString("birth_year")).isEqualTo("19BBY");
        assertThat(json.getString("name")).isEqualTo("Luke Skywalker");
    }
}