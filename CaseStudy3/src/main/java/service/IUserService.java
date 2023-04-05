package service;

import model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IUserService extends ICoreCRUDService<User, Long>{
    List<User> findAll(HttpServletRequest request);

    List<User> findAll();

    boolean update(HttpServletRequest request);

    List<User> findByNameContaining(HttpServletRequest request);

}
