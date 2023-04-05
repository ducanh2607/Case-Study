package DAO;

import connection.MyConnection;
import model.SpendingLimit;
import model.User;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SpendingLimitDAO {
    private Connection connection;

    private UserDAO userDAO;


    public SpendingLimitDAO() {
        connection = MyConnection.getConnection();
        userDAO = new UserDAO();
    }

    private final String INSERT_SPENDING_LIMIT = "insert into spendinglimit(id_user,date_create,activation_date,money_limit) values (?,?,?,?);";
    private final String SELECT_USER_BY_ID = "select * from users where id_user =?;";
    private final String SELECT_SPENDINGLIMIT_BY_ID = "select * from spendinglimit where id_user =?;";
    private final String SELECT_ALL_SPENDING = "select * from spendinglimit;";
    private final String SELECT_ALL_SPENDING_BY_ID = "select * from spendinglimit where id_user = ?;";
    private final String UPDATE_SPENDINGLIMIT = "update spendinglimit set date_create = ?, activation_date = ?, money_limit = ? where id_user = ?;";


    public boolean createSpendingLimit(SpendingLimit spendingLimit) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SPENDING_LIMIT)) {
            preparedStatement.setLong(1, spendingLimit.getUser().getId());
            preparedStatement.setString(2, spendingLimit.getDateCreate().toString());
            preparedStatement.setString(3, spendingLimit.getDateActive().toString());
            preparedStatement.setDouble(4, spendingLimit.getMoney());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User findUserById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                return new User(id, name, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SpendingLimit> findAllSpendingUser() {
        List<SpendingLimit> spendingLimits = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SPENDING)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id_spendinglimit");
                LocalDate date_create = resultSet.getDate("date_create").toLocalDate();
                LocalDate activation_date = resultSet.getDate("activation_date").toLocalDate();
                Double money = resultSet.getDouble("money_limit");
                spendingLimits.add(new SpendingLimit(id, date_create, activation_date, money));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spendingLimits;
    }

    public List<SpendingLimit> findAllSpendingUserById(Long id) {
        List<SpendingLimit> spendingLimits = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SPENDING_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long idSpendinglimit = resultSet.getLong("id_spendinglimit");
                LocalDate date_create = resultSet.getDate("date_create").toLocalDate();
                LocalDate activation_date = resultSet.getDate("activation_date").toLocalDate();
                Double money = resultSet.getDouble("money_limit");
                spendingLimits.add(new SpendingLimit(idSpendinglimit, date_create, activation_date, money));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spendingLimits;
    }


    public List<SpendingLimit> findAllNameUser() {
        List<SpendingLimit> spendingLimit1 = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SPENDING)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long idUser = resultSet.getLong("id_user");
                Long id = resultSet.getLong("id_spendinglimit");
                LocalDate date_create = resultSet.getDate("date_create").toLocalDate();
                LocalDate activation_date = resultSet.getDate("activation_date").toLocalDate();
                Double money = resultSet.getDouble("money_limit");
                spendingLimit1.add(new SpendingLimit(userDAO.findUserById(idUser), id, date_create, activation_date, money));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spendingLimit1;
    }

    public User findByIdUser(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                Double wallet = resultSet.getDouble("wallet");
                boolean share = resultSet.getBoolean("share");
                return new User(id, name, userName, password, wallet, share);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean updateSpendingLimit(SpendingLimit spendinglimit) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SPENDINGLIMIT)) {
            preparedStatement.setLong(1, spendinglimit.getUser().getId());
            preparedStatement.setString(2, spendinglimit.getDateCreate().toString());
            preparedStatement.setString(3, spendinglimit.getDateActive().toString());
            preparedStatement.setDouble(4, spendinglimit.getMoney());
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
