package DAO;

import connection.MyConnection;
import model.SpendingLimit;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;
    private final String SELECT_ALL_USERS = "select * from users;";
    private final String SELECT_USER_BY_ID = "select * from users where id_user = ?";
    private final String SELECT_SPENDING_BY_ID = "select * from spendinglimit where id_user = ?";
    private final String INSERT_USER = "insert into users(name,username,password) value (?,?,?);";
    private final String UPDATE_USER = "update users set username = ?, password = ?, name = ?, wallet = ?, share = ? where id_user = ?;";
    private final String DELETE_USER = "delete from users where id_user = ?;";

    private final String VIEW_USER = "select * from spendinglimit where id_user = ?";
    private final String LOCK_USER = "update users set status = ? where id_user = ?;";


    public UserDAO() {
        connection = MyConnection.getConnection();
    }

    public List<User> findAllUserById() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id_user");
                String name = resultSet.getString("name");
                users.add(new User(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean createUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
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
                Long idDb = resultSet.getLong("id_user");
                String name = resultSet.getString("name");
                return new User(idDb,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public User findById(Long id){
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                Double wallet = resultSet.getDouble("wallet");
                boolean share = resultSet.getBoolean("share");
                return new User(id, name, userName, password, wallet, share);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateUser(User user){
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)){
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setDouble(4, user.getWallet());
            preparedStatement.setBoolean(5,user.isShare());
            preparedStatement.setLong(6, user.getId());
            return  preparedStatement.executeUpdate() > 0;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteById(Long id){
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)){
            preparedStatement.setLong(1,id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public  SpendingLimit viewById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(VIEW_USER)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long idUser = resultSet.getLong("id_user");
                LocalDate date_create = resultSet.getDate("date_create").toLocalDate();
                LocalDate activation_date = resultSet.getDate("activation_date").toLocalDate();
                Double money = resultSet.getDouble("money_limit");
                return new SpendingLimit(idUser,date_create,activation_date,money);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean blockUser(Long id){
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOCK_USER)){
            preparedStatement.setBoolean(1, true);
            preparedStatement.setLong(2, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean unlockUser(Long id){
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOCK_USER)){
            preparedStatement.setBoolean(1, false);
            preparedStatement.setLong(2, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    private void getListUser(List<User> users, PreparedStatement preparedStatement)
            throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Long id = Long.parseLong(resultSet.getString("id_user"));
            String name = resultSet.getString("name");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            boolean role = resultSet.getBoolean("role");
            boolean status = resultSet.getBoolean("status");
            users.add(new User(id, name, username, password, role, status));
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            getListUser(users, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
