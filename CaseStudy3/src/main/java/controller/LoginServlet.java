package controller;

import model.Category;
import model.SpendingLimit;
import model.User;
import model.WalletManagement;
import service.CategoryServiceImpl;
import service.Impl.SpendingLimitServiceImpl;
import service.Impl.UserServiceImpl;
import service.WalletManagementImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private UserServiceImpl userService;

    private SpendingLimitServiceImpl spendingLimitService;
    private WalletManagementImpl walletManagement;

    private CategoryServiceImpl categoryService;

    public void init() {
        userService = new UserServiceImpl();
        spendingLimitService = new SpendingLimitServiceImpl();
        walletManagement= new WalletManagementImpl();
        categoryService = new CategoryServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
if (action == null) {
    action ="";

}switch (action) {
            case "deleteWallet":
                deleteWallet(request,response);
                break;
            case "view":
                view(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "createForm":
                createFormSpendingLimit(request, response);
                break;
            case "spendingdetail":
                displaySpendingDetail(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            case "updateFormSpending" :
                updateFormSpending(request, response);
                break;
            default:
                displayFormLogin(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action ="";

        } switch (action) {
            case "create":
                create(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "register":
                displayFormRegister(request, response);
                break;
            case "home" :
                displayHome(request, response);
                break;
            case "account" :
                displayInformationAccount(request, response);
                break;
            case "createspending":
                createSpendingLimit(request, response);
                break;
            case "updateSpending":
                updateSpending(request, response);
                break;
            case "createWallet":
                createWallet(request, response);
                break;
            case "editWallet":
                editWallet(request, response);
                break;
            case "updateForm" :
                updateFrom(request, response);
                break;
            case "category":
                createCategory(request,response);
                break;
            default:
                displayFormLogin(request, response);
                break;
        }
    }


    private void displayFormLogin(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
        dispatcher.forward(request, response);
    }
    private void createCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (categoryService.add(request)) {
            HttpSession session =request.getSession();
            session.setAttribute("message", "Create successfully");
        }
        displayHome(request,response);
    }

    private void displayFormRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Register/register.jsp");
        dispatcher.forward(request, response);
    }

    private void displayInformationAccounts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("statistical.jsp");
        requestDispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        if (userService.add(request)) {
            HttpSession session = request.getSession();
            session.setAttribute("message", "Create successfully");
        }
        response.sendRedirect("http://localhost:8080/login");
    }

    private void createFormSpendingLimit(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException {
        List<User> users = userService.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("userservice/spendinglimit.jsp");
        request.setAttribute("users",users);
        requestDispatcher.forward(request, response);
    }

    private void createSpendingLimit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
       if (spendingLimitService.add(request)) {
           HttpSession session = request.getSession();
           session.setAttribute("message", "Create successfully!");

       }
       response.sendRedirect("http://localhost:8080/login");
    }

    private void displaySpendingDetail(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<User> users = userService.findAll();
        List<SpendingLimit> spendingLimit1 = spendingLimitService.findAllUser();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home/spendinglimitdetail.jsp");
        request.setAttribute("spendinglimit",spendingLimit1);
        request.setAttribute("users",users);
        requestDispatcher.forward(request, response);
    }





    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if (userService.checkLogin(request) == 1L ){
            login1(request, response);
        }else {
            if(userService.checkLogin(request) != 0L & userService.checkLogin(request) != -1L){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/usercheck.jsp");
                request.setAttribute("user", userService.findByIds(request, userService.checkLogin(request)));
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("user", userService.findByIds(request, userService.checkLogin(request)));
                requestDispatcher.forward(request, response);

            }else {
                if (userService.checkLogin(request) != 0L){
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login.jsp");
                    HttpSession session = request.getSession();
                    session.setAttribute("message", "Your account has been locked, if you want to unlock please contact admin.");
                    requestDispatcher.forward(request, response);
                }else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login.jsp");
                    HttpSession session = request.getSession();
                    session.setAttribute("message", "Wrong username or password, please re-enter.");
                    requestDispatcher.forward(request, response);

                }
            }
        }
    }

    private void login1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/admin.jsp");
        request.setAttribute("users", userService.findAll(request));
        requestDispatcher.forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login.jsp");
        HttpSession session = request.getSession();
        session.invalidate();
        requestDispatcher.forward(request, response);

    }

    private void view(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        userService.view(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home/detailUser.jsp");
        request.setAttribute("details",spendingLimitService.findAllUser());
        requestDispatcher.forward(request,response);
    }

    private void updateSpending(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        spendingLimitService.update(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/usercheck.jsp");
        request.setAttribute("sl", spendingLimitService.findAllId(request));
        requestDispatcher.forward(request, response);
    }

    private void updateFormSpending(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("spendinglimitupdate.jsp");
        request.setAttribute("sl", spendingLimitService.findAllId(request));
        requestDispatcher.forward(request, response);
    }

    private void displayInformationAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("statistical.jsp");
        requestDispatcher.forward(request, response);
    }

    private void updateFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("home/home.jsp");
        request.setAttribute("wallet",walletManagement.findById(request));
        dispatcher.forward(request, response);
    }

    private void editWallet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        walletManagement.add(request);
        displayHome(request,response);
    }

    private void deleteWallet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        walletManagement.deleteById(request);
        displayHome(request,response);
    }


    private void createWallet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        walletManagement.add(request);
        displayHome(request,response);
    }





    private void displayHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home/home.jsp");
        List<Category> categories = walletManagement.findAllCategory(request);
        List<WalletManagement> walletManagements = walletManagement.findAll(request);
        List<Category> categoriesType1 = new ArrayList<>();
        List<Category> categoriesType2 =  new ArrayList<>();
        for (Category c: categories) {
            if (c.getType()){
                categoriesType1.add(c);
            }else {
                categoriesType2.add(c);
            }
        }
        request.setAttribute("categoriesType1",categoriesType1);
        request.setAttribute("categoriesType2",categoriesType2);

        List<WalletManagement> walletManagementsExpense = new ArrayList<>();
        List<WalletManagement> walletManagementsIncome =  new ArrayList<>();

        for (WalletManagement w: walletManagements) {
            if (w.isType()){
                walletManagementsIncome.add(w);
            }else {
                walletManagementsExpense.add(w);
            }
        }
        request.setAttribute("walletsExpense",walletManagementsExpense);
        request.setAttribute("walletsIncome",walletManagementsIncome);


        requestDispatcher.forward(request, response);
    }


}


