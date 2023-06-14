package Dao;

import Model.Tag;
import Model.Tour;
import Model.Tour_tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Tour_tag_dao extends ConectionDatabase{
 private final String INSERT_TOUR_TAG ="INSERT INTO `tour`.`tour_tag` (`tour_id`, `tag_id`) VALUES (?, ?);";
 private final String SELECT_TOUR_TAG_ID ="select * from tours left join tour_tag on tours.tour_id=tour_tag.tour_id\n" +
         " where tours.tour_id=?";
 private final String DELETE_TOURTAG_BY_TOUR_ID="DELETE FROM `tour`.`tour_tag` WHERE (`tour_id` = ?);";

    public void insertTour_tag(Tour_tag tourTag) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TOUR_TAG)) {
            preparedStatement.setInt(1, tourTag.getTour_id());
            preparedStatement.setDouble(2,tourTag.getTag_id());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteTourTagByTourId(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TOURTAG_BY_TOUR_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Tour_tag> selectTourTagId (int tour_id){
        List<Tour_tag> tour_tag_id = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_TOUR_TAG_ID);) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, tour_id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idTourTag = rs.getInt("tour_tag_id");
                int idTag=rs.getInt("tag_id");

                tour_tag_id.add(new Tour_tag(idTourTag,tour_id,idTag));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tour_tag_id;
    }
}
