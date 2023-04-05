package service;

import DAO.CategoryDAO;
import model.Category;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class CategoryServiceImpl implements ICategoryService{
    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl() {
        categoryDAO = new CategoryDAO();
    }

    @Override
    public List<Category> findAll(HttpServletRequest request) {
        return categoryDAO.findAll();
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findById(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return categoryDAO.findCategoryById(id);
    }

    @Override
    public boolean add(HttpServletRequest request) {
        String name = request.getParameter("name_category");
        String type = request.getParameter("type");
        if (type.equals("0")){
            return categoryDAO.createCategory(new Category(false, name));
        } else {
            return categoryDAO.createCategory(new Category(true, name));
        }

    }


    @Override
    public void upgrade(HttpServletRequest request) {
    }
}
