package model;

public class City {
    private int id_city;
    private String name_city;
    private double popular;
    private double area;
    private double GDP;
    private String name_country;

    public City(int id_city, String name_city, double popular, double area, double GDP, String name_country) {
        this.id_city = id_city;
        this.name_city = name_city;
        this.popular = popular;
        this.area = area;
        this.GDP = GDP;
        this.name_country = name_country;
    }

    public City(String name_city, double popular, double area, double GDP, String name_country) {
        this.name_city = name_city;
        this.popular = popular;
        this.area = area;
        this.GDP = GDP;
        this.name_country = name_country;
    }

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public String getName_city() {
        return name_city;
    }

    public void setName_city(String name_city) {
        this.name_city = name_city;
    }

    public double getPopular() {
        return popular;
    }

    public void setPopular(double popular) {
        this.popular = popular;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getGDP() {
        return GDP;
    }

    public void setGDP(double GDP) {
        this.GDP = GDP;
    }

    public String getName_country() {
        return name_country;
    }

    public void setName_country(String name_country) {
        this.name_country = name_country;
    }
}
