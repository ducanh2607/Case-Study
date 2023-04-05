package DAO;

import connection.MyConnection;
import model.Category;
import model.User;
import model.WalletManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WalletDAO {
    private final Connection connection;
    private final UserDAO userDAO;
    private final CategoryDAO categoryDAO;
    private final String SELECT_ALL_WALLET = "select * from walletmanagement;";
    private final String SELECT_WALLET_BY_ID = "select * from walletmanagement where id_walletManagement = ?;";
    private final String INSERT_WALLET = "insert into walletmanagement(date_create,type, money,notes,id_category,id_user) value (?,?,?,?,?,?);";
    private final String UPDATE_WALLET = "update walletmanagement set money = ?, notes = ?, id_category = ? where id = ?;";
    private final String DELETE_WALLET = "delete from walletmanagement where id_walletManagement = ?;";

    public WalletDAO() {
        connection = MyConnection.getConnection();
        userDAO = new UserDAO();
        categoryDAO = new CategoryDAO();
    }


    public List<WalletManagement> findAll() {
        List<WalletManagement> walletManagements = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_ALL_WALLET)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id_walletManagement");
                LocalDate date = resultSet.getDate("date_create").toLocalDate();
                Boolean type = resultSet.getBoolean("type");
                Double money = resultSet.getDouble("money");
                String notes = resultSet.getString("notes");
                Long categoryId = resultSet.getLong("id_category");
                Long userId = resultSet.getLong("id_user");
                Category category = categoryDAO.findCategoryById(categoryId);
                User user = userDAO.findById(userId);

                walletManagements.add(new WalletManagement(id,date,type,money,notes,category,user));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return walletManagements;
    }

    public boolean createWallet(WalletManagement walletManagement) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_WALLET)) {
            preparedStatement.setString(1, walletManagement.getDate().toString());
            preparedStatement.setBoolean(2, walletManagement.isType());
            preparedStatement.setDouble(3, walletManagement.getMoney());
            preparedStatement.setString(4,walletManagement.getNotes());
            preparedStatement.setLong(5, walletManagement.getCategory().getId());
            preparedStatement.setLong(6, walletManagement.getUser().getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public WalletManagement findWalletById(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_WALLET_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LocalDate date = resultSet.getDate("date_create").toLocalDate();
                Boolean type  = resultSet.getBoolean("type");
                Double money = resultSet.getDouble("money");
                String notes = resultSet.getString("notes");
                Long category = resultSet.getLong("id_category");
                Long user = resultSet.getLong("id_user");
                return new WalletManagement(date,type,money,notes,categoryDAO.findCategoryById(category),userDAO.findById(user));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean deleteWallet(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(DELETE_WALLET)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProduct(WalletManagement walletManagement) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(UPDATE_WALLET)) {
            preparedStatement.setDouble(1, walletManagement.getMoney());
            preparedStatement.setString(2,walletManagement.getNotes());
            preparedStatement.setLong(3, walletManagement.getCategory().getId());
            preparedStatement.setLong(4, walletManagement.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
