package service;

import DAO.CategoryDAO;
import DAO.UserDAO;
import DAO.WalletDAO;
import model.Category;
import model.User;
import model.WalletManagement;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WalletManagementImpl implements IWalletService {

    private CategoryDAO categoryDAO;
    private WalletDAO walletDAO;
    private UserDAO userDAO;


    public WalletManagementImpl() {
        walletDAO = new WalletDAO();
        categoryDAO = new CategoryDAO();
        userDAO = new UserDAO();
    }

    @Override
    public List<WalletManagement> findAll(HttpServletRequest request) {
        return walletDAO.findAll();
    }

    public List<Category> findAllCategory(HttpServletRequest request) {
        return categoryDAO.findAll();
    }

    @Override
    public List<WalletManagement> findAll() {
        return null;
    }

    @Override
    public WalletManagement findById(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("a"));
        for (WalletManagement w : walletDAO.findAll()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    @Override
    public boolean add(HttpServletRequest request) {
        String id = request.getParameter("a");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String type = request.getParameter("type");
        Double money = Double.parseDouble(request.getParameter("money"));
        String notes = request.getParameter("notes");
        String categoryId1 = request.getParameter("category1");
        String categoryId2 = request.getParameter("category2");
        if (id == null) {
            if (type.equals("0")) {
                return walletDAO.createWallet(new WalletManagement(date, false, money, notes, categoryDAO.findCategoryById(Long.valueOf(categoryId1)), userDAO.findById(1L)));
            } else {
                return walletDAO.createWallet(new WalletManagement(date, true, money, notes, categoryDAO.findCategoryById(Long.valueOf(categoryId2)), userDAO.findById(1L)));
            }
        } else {
            if (type.equals("0")) {
                return walletDAO.updateProduct(new WalletManagement(Long.parseLong(id), date, false, money, notes, categoryDAO.findCategoryById(Long.valueOf(categoryId2)), userDAO.findById(1L)));
            } else {
                return walletDAO.updateProduct(new WalletManagement(Long.parseLong(id), date, true, money, notes, categoryDAO.findCategoryById(Long.valueOf(categoryId2)), userDAO.findById(1L)));

            }
        }
    }


    @Override
    public void upgrade(HttpServletRequest request) {

    }

    @Override
    public boolean edit(HttpServletRequest request) {
        return false;
    }

    @Override
    public boolean deleteById(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return walletDAO.deleteWallet(id);
    }

    @Override
    public List<WalletManagement> findByNameContaining(HttpServletRequest request) {
        return null;
    }
}
