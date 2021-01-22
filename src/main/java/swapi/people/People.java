package swapi.people;

import lombok.Data;

import java.util.List;

@Data
public class People {

    private List films;
    private String homeworld;
    private String gender;
    private String skin_color;
    private String edited;
    private String created;
    private String mass;
    private List vehicles;
    private String url;
    private String hair_color;
    private String birth_year;
    private String eye_color;
    private List species;
    private List starships;
    private String name;
    private String height;
}