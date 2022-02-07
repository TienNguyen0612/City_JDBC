package controller;

import dao.CityDAO;
import model.City;
import model.Country;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CityServlet", urlPatterns = "/cities")
public class CityServlet extends HttpServlet {
    CityDAO cityDAO = new CityDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createGet":
                    createGet(request, response);
                    break;
                case "createPost":
                    createPost(request, response);
                    break;
                case "editGet":
                    editGet(request, response);
                    break;
                case "editPost":
                    editPost(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                default:
                    displayALlCities(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int idDelete = Integer.parseInt(request.getParameter("id"));
        cityDAO.deleteCity(idDelete);
        displayALlCities(request, response);
    }

    private void editPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id_city = Integer.parseInt(request.getParameter("id"));
        String name_city = request.getParameter("name_city");
        double popular = Double.parseDouble(request.getParameter("popular"));
        double area = Double.parseDouble(request.getParameter("area"));
        double GDP = Double.parseDouble(request.getParameter("GDP"));
        String name_country = request.getParameter("name_country");

        City city = new City(id_city, name_city, popular, area, GDP, name_country);
        cityDAO.updateCity(city);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editGet(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Country> countryList = cityDAO.selectAllCountries();
        request.setAttribute("countryList", countryList);
        int id_city = Integer.parseInt(request.getParameter("id"));
        City cityEdit = cityDAO.selectCity(id_city);
        request.setAttribute("city", cityEdit);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");

        requestDispatcher.forward(request, response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name_city = request.getParameter("name_city");
        double popular = Double.parseDouble(request.getParameter("popular"));
        double area = Double.parseDouble(request.getParameter("area"));
        double GDP = Double.parseDouble(request.getParameter("GDP"));
        String name_country = request.getParameter("name_country");
        City city = new City(name_city, popular, area, GDP, name_country);
        cityDAO.insertCity(city);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Country> countryList = cityDAO.selectAllCountries();
        request.setAttribute("countryList", countryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void displayALlCities(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<City> cityList = cityDAO.selectAllCities();
        request.setAttribute("cityList", cityList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }
}
