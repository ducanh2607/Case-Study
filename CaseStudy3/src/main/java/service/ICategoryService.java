package service;

import model.Category;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ICategoryService extends ICoreCRUDService<Category, Long>  {
    List<Category> findAll(HttpServletRequest request);
}
