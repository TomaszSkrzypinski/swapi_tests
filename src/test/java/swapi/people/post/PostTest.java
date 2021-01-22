//package swapi.people.post;
//
//import org.apache.http.HttpStatus;
//import org.junit.jupiter.api.Test;
//import swapi.base.BaseTest;
//import swapi.people.People;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static io.restassured.RestAssured.given;
//
//public class PostTest extends BaseTest {
//
//    People people = new People();
//
//    @Test
//    public void createNewPeople(){
//
//        people.setHomeworld("hommeworld");
//        people.setGender("male");
//        people.setSkin_color("pink");
//        people.setName("Tomek");
//        people.setEdited("19970534");
//        people.setCreated("19891122");
//        people.setMass("80");
//        people.setUrl("ww.wp.pl");
//        people.setHair_color("yellow");
//        people.setBirth_year("789");
//        people.setEye_color("red");
//        people.setName("Tomek");
//        people.setHeight("168");
//
//        List<String> films = new ArrayList<>();
//        films.add("film1");
//        films.add("film2");
//
//        people.setFilms(films);
//
//        List<String> vehicles = new ArrayList<>();
//        vehicles.add("vehicle1");
//        vehicles.add("vehicle2");
//
//        people.setVehicles(vehicles);
//
//        List<String> species = new ArrayList<>();
//        species.add("specie1");
//        species.add("specie2");
//
//        people.setSpecies(species);
//
//        List<String> starships = new ArrayList<>();
//        starships.add("starship1");
//        starships.add("starship2");
//
//        people.setStarships(starships);
//
//
//        given()
//                .body(people)
//                .spec(reqSpec)
//                .when()
//                .post(BASE_URL + PEOPLE)
//                .then()
//                .statusCode(HttpStatus.SC_OK);
//
//
//    }
//}