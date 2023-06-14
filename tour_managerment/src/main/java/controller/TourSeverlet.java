package controller;

import model.Tag;
import model.Tour;
import model.Tour_tag;
import dto.Pageable;
import service.TagService;
import service.TourService;
import service.Tour_tagService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "tourSeverlet", value = "/tours")
public class TourSeverlet extends HttpServlet {
    private static final long serialVersionUID = 102831973239L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
