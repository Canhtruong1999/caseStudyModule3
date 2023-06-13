package service;

import Dao.Tour_tag_dao;
import Model.Tour_tag;

import java.util.List;

public class Tour_tagService {
    Tour_tag_dao tour_tag_dao =new Tour_tag_dao();
    public void create (Tour_tag tourTag){
        tour_tag_dao.insertTour_tag(tourTag);
    }
    public List<Integer> findTourTagid(int tour_id){
       return tour_tag_dao.selectTourTagId(tour_id);
    }
}
