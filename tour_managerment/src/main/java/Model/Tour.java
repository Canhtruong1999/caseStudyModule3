package Model;

import java.time.LocalDate;

public class Tour {
    private  int tour_id;
    private String name;
    private double price;
    private LocalDate start_time;
    private LocalDate end_time;
    private String  img;
    private String description;
    private String tour_tag;

    public String getTour_tag() {
        return tour_tag;
    }

    public void setTour_tag(String tour_tag) {
        this.tour_tag = tour_tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDate start_time) {
        this.start_time = start_time;
    }

    public LocalDate getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDate end_time) {
        this.end_time = end_time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Tour(int tour_id, String name, double price, LocalDate start_time, LocalDate end_time, String img, String description) {
        this.tour_id = tour_id;
        this.name = name;
        this.price = price;
        this.start_time = start_time;
        this.end_time = end_time;
        this.img = img;
        this.description = description;
    }

    public Tour(int tour_id, String name, double price, LocalDate start_time, LocalDate end_time, String img, String description, String tour_tag) {
        this.tour_id = tour_id;
        this.name = name;
        this.price = price;
        this.start_time = start_time;
        this.end_time = end_time;
        this.img = img;
        this.description = description;
        this.tour_tag = tour_tag;
    }

    public Tour(String name, double price, LocalDate start_time, LocalDate end_time, String img, String description, String tour_tag) {
        this.name = name;
        this.price = price;
        this.start_time = start_time;
        this.end_time = end_time;
        this.img = img;
        this.description = description;
        this.tour_tag = tour_tag;
    }

    public Tour(String name, double price, LocalDate start_time, LocalDate end_time, String img, String description) {
        this.name = name;
        this.price = price;
        this.start_time = start_time;
        this.end_time = end_time;
        this.img = img;
        this.description = description;
    }
}
