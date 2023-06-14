package dao;

import model.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
    private String jdbcURL = "jdbc:mysql://127.0.0.1:3306/tour?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "0766784418";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    private final String SELECT_ALL_HOTELS = "SELECT * FROM tour.hotel;";
    private final String SELECT_HOTEL_BY_ID = "SELECT * FROM tour.hotel WHERE hotel_id = ?";

    public HotelDAO(){}

    public List<Hotel> findAll() {
        List<Hotel> hotels = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_ALL_HOTELS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("hotel_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                hotels.add(new Hotel(id, name,price,description));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotels;
    }

    public Hotel findById(int id){
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_HOTEL_BY_ID);) {

            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idHotel = rs.getInt("hotel_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                return new Hotel(idHotel, name,price,description);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
