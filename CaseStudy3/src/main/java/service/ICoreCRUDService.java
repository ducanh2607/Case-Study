package service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ICoreCRUDService<E, K> {
    List<E> findAll();

    E findById(HttpServletRequest request);

    boolean add(HttpServletRequest request);
    void upgrade(HttpServletRequest request);

}
