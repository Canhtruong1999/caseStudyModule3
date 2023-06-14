package controller;



import filter.FilterAdmin;
import model.User;
import ultils.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserServlet userServlet = new UserServlet();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user_name");
        String password = req.getParameter("user_password");
        User user = userServlet.userService.findByUsername(username);


        if (user != null) {
            if (PasswordEncoder.check(password, user.getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute("role", user.getRole().toString());
                session.setAttribute("user", user);
                resp.sendRedirect("admin/user?action=userPage");
                return;
            }
            if (user.getPassword().equals(password)) {
                req.setAttribute("user", user);
                req.getRequestDispatcher("user.jsp")
                        .forward(req,resp);
            } else {
                req.setAttribute("errors", "Mat khau khong dung");
            }
        }else {
            req.setAttribute("errors", "Tài khoản không tồn tại trong hệ thống");
        }

        req.getRequestDispatcher("login.jsp")
                .forward(req,resp);
    }
}
