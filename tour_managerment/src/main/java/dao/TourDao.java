package dao;

import model.Tour;
import dto.Pageable;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TourDao extends ConectionDatabase {
    private final String SELECT_TOUR = "select t1.*,group_concat(t2.`name` separator ',') as tags  from tours t1 left  join tour_tag tt on tt.tour_id=t1.tour_id\n" +
            "\t\t\t\t\tleft join tag t2 on tt.tag_id=t2.tag_id\t\n" +
            "                    where t1.`name` like '%s' or  t1.start_time like '%s' or t1.price like '%s' \n" +
            "                    group by t1.tour_id\n" +
            "                    order by %s %s \n" +
            "                    limit %d offset %d";
    private final String TOTAL_TOUR = "select count(1) as total_tour from tours where tours.`name` like ? or tours.price like ? or tours.start_time like ? ";
    private final String SELECT_TOUR_BY_ID = "SELECT * FROM tour.tours where tour_id=?";
    private final String INSERT_TOUR = "INSERT INTO `tour`.`tours` (`name`, `price`, `start_time`, `end_time`, `img`, `description`) VALUES (?, ?, ?, ?, ?,?);";
    private final String FIND_ID = "SELECT max(tours.tour_id) as id FROM tour.tours ";
    private final String UPDATE_TOUR = "UPDATE `tour`.`tours` SET `name` = ?, `price` = ?, `start_time` = ?, `end_time` = ?, `img` = ?, `description` = ? WHERE (`tour_id` = ?);";
    private final String DELETE_TOUR = "DELETE FROM `tour`.`tours` WHERE (`tour_id` = ?);";

    public List<Tour> findAll(Pageable pageAble) {
        List<Tour> tours = new ArrayList<>();
        String search = pageAble.getSearch();
        if (search == null) {
            search = "";
        }
        search = "%" + search + "%";
        String sortby = pageAble.getSortBy();
        String fieldName = pageAble.getNameField();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(String.format(SELECT_TOUR, search, search, search, fieldName, sortby, pageAble.getTotalItems(), (pageAble.getPage() - 1) * pageAble.getTotalItems()))) {

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tour_id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                LocalDate start_time = rs.getDate("start_time").toLocalDate();
                LocalDate end_time = rs.getDate("end_time").toLocalDate();
                String img = rs.getString("img");
                String description = rs.getString("description");
                String tour_tag = rs.getString("tags");
                tours.add(new Tour(id, name, price, start_time, end_time, img, description, tour_tag));
            }
            PreparedStatement statementTotalUsers = connection.prepareStatement(TOTAL_TOUR);
            statementTotalUsers.setString(1, search);
            statementTotalUsers.setString(2, search);
            statementTotalUsers.setString(3, search);
            ResultSet rsTotalUser = statementTotalUsers.executeQuery();
            while (rsTotalUser.next()) {
                double total_tour = rsTotalUser.getDouble("total_tour");
                double totalItems = Double.parseDouble(pageAble.getTotalItems() + "");
                int totalPages = (int)
                        Math.ceil(total_tour / totalItems);
                pageAble.setTotalPage(totalPages);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tours;
    }

    public Tour findById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_TOUR_BY_ID)) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idtour = rs.getInt("tour_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                LocalDate start_time = rs.getDate("start_time").toLocalDate();
                LocalDate end_time = rs.getDate("end_time").toLocalDate();
                String img = rs.getString("img");
                String description = rs.getString("description");
                Tour tour = new Tour(idtour, name, price, start_time, end_time, img, description);
                return tour;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void insertTour(Tour tour) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TOUR)) {
            preparedStatement.setString(1, tour.getName());
            preparedStatement.setDouble(2, tour.getPrice());
            preparedStatement.setDate(3, Date.valueOf(tour.getStart_time()));
            preparedStatement.setDate(4, Date.valueOf(tour.getEnd_time()));
            preparedStatement.setString(5, tour.getImg());
            preparedStatement.setString(6, tour.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int findID() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(FIND_ID);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");

                return id;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public void updateTour(Tour tour) {
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOUR)) {
            preparedStatement.setString(1, tour.getName());
            preparedStatement.setDouble(2, tour.getPrice());
            preparedStatement.setDate(3, Date.valueOf(tour.getStart_time()));
            preparedStatement.setDate(4, Date.valueOf(tour.getEnd_time()));
            preparedStatement.setString(5, tour.getImg());
            preparedStatement.setString(6, tour.getDescription());
            preparedStatement.setInt(7, tour.getTour_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteTour(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TOUR)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
