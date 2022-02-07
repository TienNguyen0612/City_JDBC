package dao;

import model.City;
import model.Country;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO {
    public void insertCity(City city) throws SQLException;

    public City selectCity(int id);

    public List<City> selectAllCities();

    public boolean deleteCity(int id) throws  SQLException;

    public boolean updateCity(City city) throws  SQLException;

    public List<Country> selectAllCountries();
}
