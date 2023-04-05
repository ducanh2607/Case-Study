package service.Impl;

import DAO.SpendingLimitDAO;
import DAO.UserDAO;
import model.SpendingLimit;
import model.User;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public class SpendingLimitServiceImpl {

    private UserDAO userDAO;
    private SpendingLimitDAO spendingLimitDAO;

    public SpendingLimitServiceImpl() {
        spendingLimitDAO = new SpendingLimitDAO();
        userDAO = new UserDAO();
    }

    public List<SpendingLimit> findAll() {
        return spendingLimitDAO.findAllSpendingUser();
    }

    public SpendingLimit findAllId(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        for (SpendingLimit sl : spendingLimitDAO.findAllSpendingUser()) {
            if (sl.getId() == id) {
                return sl;
            }
        }
        return null;
    }

    public List<SpendingLimit> findAllUser() {
        return spendingLimitDAO.findAllNameUser();
    }


    public boolean add(HttpServletRequest request) {
        Long userId = Long.parseLong(request.getParameter("user"));
        LocalDate date_create = LocalDate.parse(request.getParameter("date_create"));
        LocalDate activation_date = LocalDate.parse(request.getParameter("activation_date"));
        Double money_limit = Double.parseDouble(request.getParameter("money_limit"));
        return spendingLimitDAO.createSpendingLimit(new SpendingLimit(userDAO.findUserById(userId), date_create, activation_date, money_limit));
    }

    public boolean update(HttpServletRequest request) {
        Long userId = Long.parseLong(request.getParameter("user"));
        LocalDate date_create = LocalDate.parse(request.getParameter("date_create"));
        LocalDate activation_date = LocalDate.parse(request.getParameter("activation_date"));
        Double money_limit = Double.parseDouble(request.getParameter("money_limit"));
        return spendingLimitDAO.updateSpendingLimit(new SpendingLimit(userId,date_create,activation_date,money_limit));
    }
}



