package Controller;

import Model.Tag;
import Model.Tour;
import Model.Tour_tag;
import pageable.PageAble;
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
import java.util.Collections;
import java.util.List;

@WebServlet(name = "tourSeverlet", value = "/tours")
public class TourSeverlet extends HttpServlet {
    int totalItem=5;

    TourService tourService=new TourService();
    TagService tagService=new TagService();
    Tour_tagService tour_tagService=new Tour_tagService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreate(req,resp);
                break;
            case "edit":
                showEdit(req,resp);
                break;
            case"delete":
                //deleteBook(req,resp);
                break;
            default:
                showTour(req,resp);
        }
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) {
        int tour_id = Integer.parseInt(req.getParameter("id"));
       Tour tour= tourService.findById(tour_id);
        List<Integer> tour_tag_id= tour_tagService.findTourTagid(tour.getTour_id());
       List<Tag> tagList =tagService.findAll();
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tag> tagList = tagService.findAll();
        req.setAttribute("tagList",tagList);
        req.getRequestDispatcher("creat.jsp").forward(req,resp);
    }

    private void showTour(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search =req.getParameter("search");
        int page = 1;
        if(req.getParameter("page") != null){
            page = Integer.parseInt(req.getParameter("page"));
        }
        String fieldName="t1.tour_id";
        if(req.getParameter("fieldName") != null){
            fieldName = req.getParameter("page");
        }
        String sortby ="desc";
        if(req.getParameter("sortby") != null){
            sortby = req.getParameter("sortby");
        }
        PageAble pageAble =new PageAble(search,page,totalItem,fieldName,sortby);
        req.setAttribute("pageable",pageAble);
        List<Tour> tours =tourService.findAll(pageAble);
        req.setAttribute("tours",tourService.findAll(pageAble));
        req.getRequestDispatcher("show.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createTour(req,resp);
                break;
            case"edit":
             //   editBook(req,resp);
            default:
                //   showProduct(req,resp);
        }
    }

    private void createTour(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Double price= Double.valueOf(req.getParameter("price"));
        LocalDate start_time = LocalDate.parse(req.getParameter("start_time"));
        LocalDate end_time = LocalDate.parse(req.getParameter("start_time"));
        String img =req.getParameter("img");
        String description =req.getParameter("description");
        Tour tour=new Tour(name,price,start_time,end_time,img,description);
        tourService.create(tour);
        int tour_id =tourService.findId();
        String[] selectedValues = req.getParameterValues("myCheckbox");
        for (String str:selectedValues) {
            int tag_id= Integer.parseInt(str);
            tour_tagService.create(new Tour_tag(tour_id,tag_id));
        }
        req.setAttribute("tour",tour);
        req.setAttribute("message", "Created");
        req.setAttribute("tagList", tagService.findAll());
        req.getRequestDispatcher("creat.jsp").forward(req,resp);
    }

}
