package ru.rgordeev.httpexample.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * {
 * 	"name": "Luke Skywalker",
 * 	"height": "172",
 * 	"mass": "77",
 * 	"hair_color": "blond",
 * 	"skin_color": "fair",
 * 	"eye_color": "blue",
 * 	"birth_year": "19BBY",
 * 	"gender": "male",
 * 	"homeworld": "https://swapi.dev/api/planets/1/",
 * 	"films": [
 * 		"https://swapi.dev/api/films/1/",
 * 		"https://swapi.dev/api/films/2/",
 * 		"https://swapi.dev/api/films/3/",
 * 		"https://swapi.dev/api/films/6/"
 * 	],
 * 	"species": [],
 * 	"vehicles": [
 * 		"https://swapi.dev/api/vehicles/14/",
 * 		"https://swapi.dev/api/vehicles/30/"
 * 	],
 * 	"starships": [
 * 		"https://swapi.dev/api/starships/12/",
 * 		"https://swapi.dev/api/starships/22/"
 * 	],
 * 	"created": "2014-12-09T13:50:51.644000Z",
 * 	"edited": "2014-12-20T21:17:56.891000Z",
 * 	"url": "https://swapi.dev/api/people/1/"
 * }
 */
public class Person {
    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private List<String> films = new ArrayList<>();
    private List<Film> filmObjects = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public List<Film> getFilmObjects() {
        return filmObjects;
    }

    public void setFilmObjects(List<Film> filmObjects) {
        this.filmObjects = filmObjects;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", filmObjects=" + filmObjects +
                '}';
    }
}
