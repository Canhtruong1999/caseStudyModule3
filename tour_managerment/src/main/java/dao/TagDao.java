package dao;

import model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagDao extends ConectionDatabase {
private  final String SELECT_TAG ="SELECT * FROM tour.tag;";
private final  String SELECT_TAG_BY_ID ="SELECT * FROM tour.tag where tour.tag_id = ?";
    public List<Tag> findAll() {
        List<Tag> categories = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_TAG);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tag_id");
                String name = rs.getString("name");
                categories.add(new Tag(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }
    public Tag findById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_TAG_BY_ID);) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idTag = rs.getInt("id");
                String name = rs.getString("name");
                return (new Tag(idTag, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
