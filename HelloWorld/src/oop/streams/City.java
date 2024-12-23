package oop.streams;

import java.util.*;
import java.util.stream.Collectors;

class City {
    private int id;
    private String name;
    private String country;
    private int population;

    public City(int id, String name, String country, int population) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                '}';
    }

    public static void main(String[] args) {
        List<City> cities = Arrays.asList(
                new City(1, "New York", "USA", 8_000_000),
                new City(2, "Los Angeles", "USA", 4_000_000),
                new City(3, "Tokyo", "Japan", 14_000_000),
                new City(4, "Osaka", "Japan", 2_700_000),
                new City(5, "Paris", "France", 2_200_000),
                new City(6, "Lyon", "France", 500_000)
        );

        //Find the country with the highest total population (sum of all city populations).

        Optional<Map.Entry<String, Integer>> entry = cities.stream().collect(Collectors.groupingBy(City::getCountry, Collectors.summingInt(City::getPopulation))).entrySet().stream()
                .max(Map.Entry.comparingByValue()).orElseThrow( () -> new RuntimeException("not data found"));


    }
}
