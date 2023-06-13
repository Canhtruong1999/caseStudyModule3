package Model;

public class Tour_tag {
    private int tour_tag_id;
    private int tour_id;
    private  int tag_id;

    public int getTour_tag_id() {
        return tour_tag_id;
    }

    public void setTour_tag_id(int tour_tag_id) {
        this.tour_tag_id = tour_tag_id;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public Tour_tag(int tour_id, int tag_id) {
        this.tour_id = tour_id;
        this.tag_id = tag_id;
    }
}
