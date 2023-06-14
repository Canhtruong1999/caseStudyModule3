package service;

import dao.Tour_tag_dao;
import model.Tour_tag;

import java.util.List;

public class Tour_tagService {
    Tour_tag_dao tour_tag_dao =new Tour_tag_dao();
    public void create (Tour_tag tourTag){
        tour_tag_dao.insertTour_tag(tourTag);
    }
    public List<Tour_tag> findTourTagid(int tour_id){
       return tour_tag_dao.selectTourTagId(tour_id);
    }
    public void deleteByTourId(int tour_id){
        tour_tag_dao.deleteTourTagByTourId(tour_id);
    }
}
