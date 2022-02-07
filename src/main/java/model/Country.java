package model;

public class Country {
    private int id_country;
    private String name_country;

    public Country(int id_country, String name_country) {
        this.id_country = id_country;
        this.name_country = name_country;
    }

    public Country(String name_country) {
        this.name_country = name_country;
    }

    public int getId_country() {
        return id_country;
    }

    public String getName_country() {
        return name_country;
    }
}
