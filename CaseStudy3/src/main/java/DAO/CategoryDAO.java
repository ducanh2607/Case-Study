package DAO;

import connection.MyConnection;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final Connection connection;
    private final String SELECT_ALL_CATEGORIES = "select * from category;";
    private final String SELECT_CATEGORY_BY_ID = "select * from category where id_category = ?;";
    private final String INSERT_CATEGORY = "insert into category(type, name_category) value (?,?);";

    public CategoryDAO() {
        connection = MyConnection.getConnection();
    }
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_ALL_CATEGORIES)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id_category");
                String name = resultSet.getString("name_category");
                Boolean type = resultSet.getBoolean("type");
                categories.add(new Category(id, name, type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public Category findCategoryById(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_CATEGORY_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long idDb = resultSet.getLong("id_category");
                String name = resultSet.getString("name_category");
                Boolean type = resultSet.getBoolean("type");
                return new Category(idDb, name, type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createCategory(Category category) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_CATEGORY)) {
            preparedStatement.setBoolean(1, category.getType());
            preparedStatement.setString(2, category.getName());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
