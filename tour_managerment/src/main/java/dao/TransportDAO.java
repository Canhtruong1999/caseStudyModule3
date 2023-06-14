package dao;

import model.Hotel;
import model.Transport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportDAO {
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
    private final String SELECT_ALL_TRANSPORTS = "SELECT * FROM tour.transport;";
    private final String SELECT_TRANSPORT_BY_ID= "SELECT * FROM tour.transport WHERE transport_id = ?;";

    public TransportDAO(){}

    public List<Transport> findAll(){
        List<Transport> transports = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_ALL_TRANSPORTS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("transport_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                transports.add(new Transport(id, name,price,description));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return transports;
    }

    public Transport findById(int id){
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_TRANSPORT_BY_ID);) {

            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idTransport = rs.getInt("transport_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                return new Transport(idTransport, name,price,description);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
