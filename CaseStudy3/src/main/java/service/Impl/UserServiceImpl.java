package service.Impl;

import DAO.SpendingLimitDAO;
import DAO.UserDAO;
import model.SpendingLimit;
import model.User;
import service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserServiceImpl implements IUserService {
    private final UserDAO userDAO;
    private final SpendingLimitDAO spendingLimitDAO;

    public UserServiceImpl() {
        userDAO = new UserDAO();
        spendingLimitDAO = new SpendingLimitDAO();
    }

    @Override
    public List<User> findAll(HttpServletRequest request) {
        return userDAO.findAll();
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAllUserById();
    }

    @Override
    public User findById(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return userDAO.findById(id);
    }

    @Override
    public boolean add(HttpServletRequest request) {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return userDAO.createUser(new User(name, username, password));
    }


    @Override
    public void upgrade(HttpServletRequest request) {

    }

    @Override
    public boolean update(HttpServletRequest request) {
        String id = request.getParameter("id_user");
        String name = request.getParameter("name_user");
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");
        String wallet = request.getParameter("wallet");
        String test = request.getParameter("share");
        boolean share = test.equals("true");
        return userDAO.updateUser(new User(Long.parseLong(id), name, userName, password, Double.parseDouble(wallet), share));
    }

    public boolean delete(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return userDAO.deleteById(id);
    }

    public List<SpendingLimit> view(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return spendingLimitDAO.findAllSpendingUserById(id);
    }

    public boolean block(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return userDAO.blockUser(id);
    }
    public boolean unlock(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return userDAO.unlockUser(id);
    }

    @Override
    public List<User> findByNameContaining(HttpServletRequest request) {
        return null;
    }
    public Long checkLogin(HttpServletRequest request) {
        List<User> users = userDAO.findAll();
        Long idLogin;
        HttpSession httpSession = request.getSession();
        User userSession = (User) httpSession.getAttribute("user");
        if (userSession != null) {
            return userSession.getId();
        }
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");
        User userCheck = new User();
        boolean flag = false;

        for (User user : users) {
            if (user.getUserName().equals(userName) & user.getPassword().equals(password)) {
                userCheck = user;
                flag = true;
            }
        }
        if (!flag){
            idLogin = -1L;
        }else{
            if (userCheck.isRole()){
                idLogin = 1L;
            }else {
                if (!userCheck.isStatus()){
                    idLogin = userCheck.getId();
                }else{
                    idLogin = 0L;
                }
            }
        }
        return idLogin;
    }

    public User findByIds(HttpServletRequest request, Long id) {
        return userDAO.findById(id);
    }
}
