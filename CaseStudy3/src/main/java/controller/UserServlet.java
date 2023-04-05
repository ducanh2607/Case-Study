package controller;

import service.Impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/admin")
public class UserServlet extends HttpServlet {
    private UserServiceImpl userService;
    @Override
    public void init() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "block":
                block(request, response);
                break;
            case "unlock":
                unlock(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "update":
                updateForm(request, response);
                break;
            case "updateSpending":
                updateForm(request, response);
                break;
            default:
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                update(request, response);
                break;
            case "updateSpending":
                update(request, response);
                break;

            default:
                break;
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService.delete(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/admin.jsp");
        request.setAttribute("users", userService.findAll(request));
        requestDispatcher.forward(request, response);
    }
    private void block(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService.block(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/admin.jsp");
        request.setAttribute("users", userService.findAll(request));
        requestDispatcher.forward(request, response);
    }
    private void unlock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService.unlock(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/admin.jsp");
        request.setAttribute("users", userService.findAll(request));
        requestDispatcher.forward(request, response);
    }
    private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/update.jsp");
        request.setAttribute("user", userService.findById(request));
        requestDispatcher.forward(request, response);
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        userService.update(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/usercheck.jsp");
        request.setAttribute("user", userService.findById(request));
        requestDispatcher.forward(request, response);
    }


}
