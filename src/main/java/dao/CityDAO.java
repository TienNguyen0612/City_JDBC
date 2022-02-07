package dao;

import model.City;
import model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements ICityDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/city_country?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";


    private static final String INSERT_CITY_SQL = "insert into city (name_city, popular, area, GDP, country) value (?, ?, ?, ?, ?);";
    private static final String SELECT_CITY_BY_ID = "select * from city where id_city = ?";
    private static final String SELECT_ALL_CITIES = "select * from city";
    private static final String DELETE_CITY_SQL = "delete from city where id_city = ?;";
    private static final String UPDATE_CITY_SQL = "update city set name_city = ?, popular = ?, area = ?, GDP = ?, country = ? where id_city = ?;";
    private static final String SELECT_ALL_COUNTRIES = "select * from country";

    public CityDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertCity(City city) throws SQLException {
        System.out.println(INSERT_CITY_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CITY_SQL)) {
            preparedStatement.setString(1, city.getName_city());
            preparedStatement.setDouble(2, city.getPopular());
            preparedStatement.setDouble(3, city.getArea());
            preparedStatement.setDouble(4, city.getGDP());
            preparedStatement.setString(5, city.getName_country());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public City selectCity(int id) {
        City city = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CITY_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name_city = rs.getString("name_city");
                double popular = rs.getDouble("popular");
                double area = rs.getDouble("area");
                double GDP = rs.getDouble("GDP");
                String name_country = rs.getString("country");
                city = new City(id, name_city, popular, area, GDP, name_country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public List<City> selectAllCities() {
        List<City> cityList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CITIES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_city");
                String name_city = rs.getString("name_city");
                double popular = rs.getDouble("popular");
                double area = rs.getDouble("area");
                double GDP = rs.getDouble("GDP");
                String name_country = rs.getString("country");
                cityList.add(new City(id, name_city, popular, area, GDP, name_country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public boolean deleteCity(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CITY_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCity(City city) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CITY_SQL)) {
            statement.setString(1, city.getName_city());
            statement.setDouble(2, city.getPopular());
            statement.setDouble(3, city.getArea());
            statement.setDouble(4, city.getGDP());
            statement.setString(5, city.getName_country());
            statement.setInt(6, city.getId_city());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Country> selectAllCountries() {
        List<Country> countryList = new ArrayList<>();
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COUNTRIES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_country = rs.getInt("id_country");
                String name_country = rs.getString("name_country");
                countryList.add(new Country(id_country, name_country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countryList;
    }
}
