package dao;

import dto.Pageable;
import model.Hotel;
import model.ServiceModel;
import model.Transport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {
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

    private final String SELECT_ALL_SERVICE = "select service.service_id,service.hotel_id,hotel.`name` as hotel_name,hotel.price as hotel_price,hotel.`description` as hotel_description," +
            "\t\tservice.transport_id,transport.`name` as transport_name,transport.price as transport_price,transport.`description` as transport_description," +
            "        SUM(hotel.price + transport.price) as total_price," +
            "        concat(hotel.`description`, ',', transport.`description`) AS `description` " +
            "        from service " +
            "        LEFT JOIN hotel ON service.hotel_id = hotel.hotel_id " +
            "        LEFT JOIN transport ON service.transport_id = transport.transport_id " +
            "        WHERE LOWER(service.service_id) LIKE '%s' OR LOWER(hotel.`name`) LIKE '%s' OR LOWER(transport.`name`) LIKE '%s' OR LOWER(service.total_price) LIKE '%s' OR LOWER(service.`description`) LIKE '%s' " +
            "        GROUP BY service.service_id " +
            "        order by %s %s " +
            "        limit %d offset %d;";
    private final String TOTAL_SERVICES = "SELECT count(1) as total " +
            "FROM service " +
            "LEFT JOIN hotel ON service.hotel_id = hotel.hotel_id " +
            "LEFT JOIN transport ON service.transport_id = transport.transport_id " +
            "WHERE LOWER(service.service_id) LIKE ? OR LOWER(hotel.`name`) LIKE ? OR LOWER(transport.`name`) LIKE ? OR LOWER(service.total_price) LIKE ? OR LOWER(service.`description`) LIKE ?;";
    private final String SELECT_SERVICE_BY_ID = "select service.service_id,service.hotel_id,hotel.`name` as hotel_name,hotel.price as hotel_price,hotel.`description` as hotel_description," +
            "\t\tservice.transport_id,transport.`name` as transport_name,transport.price as transport_price,transport.`description` as transport_description," +
            "        SUM(hotel.price + transport.price) as total_price," +
            "        concat(hotel.`description`, ',', transport.`description`) AS `description` " +
            "        from service " +
            "        LEFT JOIN hotel ON service.hotel_id = hotel.hotel_id " +
            "        LEFT JOIN transport ON service.transport_id = transport.transport_id " +
            "        WHERE service.service_id = ?;";
    private final String INSERT_SERVICE = "INSERT INTO `tour`.`service` (`hotel_id`, `transport_id`) VALUES (?, ?);";
    private final String UPDATE_SERVICE = "UPDATE `tour`.`service` SET `hotel_id` = ?, `transport_id` = ? WHERE (service.`service_id` = ?);";
    private final String DELETE_SERVICE_BY_ID = "delete from service where service.service_id = ?;";

    public ServiceDAO() {
    }

    public List<ServiceModel> findAll(Pageable pageable) {
        List<ServiceModel> services = new ArrayList<>();
        String search = pageable.getSearch();
        if (search == null) {
            search = "";
        }
        search = "%" + search + "%";
//        String nameField=pageable.getNameField();
//        String sortBy=pageable.getSortBy();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(String.format(SELECT_ALL_SERVICE, search, search, search, search, search,
                             pageable.getNameField(), pageable.getSortBy(), pageable.getTotalItems(),
                             (pageable.getPage() - 1) * pageable.getTotalItems()));
        ) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("service_id");

                int idHotel = rs.getInt("hotel_id");
                String hotelName = rs.getString("hotel_name");
                double hotelPrice = rs.getDouble("hotel_price");
                String hotelDescription = rs.getString("hotel_description");

                int idTransport = rs.getInt("transport_id");
                String transportName = rs.getString("transport_name");
                double transportPrice = rs.getDouble("transport_price");
                String transportDescription = rs.getString("transport_description");

                double total_price = rs.getDouble("total_price");
                String description = rs.getString("description");

                services.add(new ServiceModel(id, new Hotel(idHotel,hotelName,hotelPrice,hotelDescription),
                                                new Transport(idTransport,transportName,transportPrice,transportDescription),
                                                total_price, description));
            }

            PreparedStatement preparedTotalServices = connection
                    .prepareStatement(TOTAL_SERVICES);
            preparedTotalServices.setString(1, search);
            preparedTotalServices.setString(2, search);
            preparedTotalServices.setString(3, search);
            preparedTotalServices.setString(4, search);
            preparedTotalServices.setString(5, search);
            ResultSet rsTotal = preparedTotalServices.executeQuery();
            while (rsTotal.next()) {
                double totalServices = rsTotal.getDouble("total");
                double totalItems = Double.parseDouble(pageable.getTotalItems() + "");
                int totalPages = (int) Math.ceil(totalServices / totalItems);
                pageable.setTotalPage(totalPages);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return services;
    }

    public ServiceModel findById(int id){
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_SERVICE_BY_ID);) {

            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idService = rs.getInt("service_id");

                int idHotel = rs.getInt("hotel_id");
                String hotelName = rs.getString("hotel_name");
                double hotelPrice = rs.getDouble("hotel_price");
                String hotelDescription = rs.getString("hotel_description");

                int idTransport = rs.getInt("transport_id");
                String transportName = rs.getString("transport_name");
                double transportPrice = rs.getDouble("transport_price");
                String transportDescription = rs.getString("transport_description");

                double total_price = rs.getDouble("total_price");
                String description = rs.getString("description");

                return new ServiceModel(idService, new Hotel(idHotel,hotelName,hotelPrice,hotelDescription),
                                                new Transport(idTransport,transportName,transportPrice,transportDescription),
                                                total_price, description);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void createService(ServiceModel serviceModel){
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection
                     .prepareStatement(INSERT_SERVICE);) {

            System.out.println(preparedStatement);
            preparedStatement.setInt(1, serviceModel.getHotelName().getId());
            preparedStatement.setInt(2, serviceModel.getTransportName().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editService(ServiceModel serviceModel){
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection
                     .prepareStatement(UPDATE_SERVICE);) {

            System.out.println(preparedStatement);
            preparedStatement.setInt(1, serviceModel.getHotelName().getId());
            preparedStatement.setInt(2, serviceModel.getTransportName().getId());
            preparedStatement.setInt(3, serviceModel.getId());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteService(int id){
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection
                     .prepareStatement(DELETE_SERVICE_BY_ID);) {

            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
