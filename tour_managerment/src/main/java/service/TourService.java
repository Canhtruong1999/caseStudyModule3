package service;

import Dao.TourDao;
import Model.Tour;
import pageable.PageAble;

import java.util.List;

public class TourService {
    TourDao tourDao=new TourDao();
    public List<Tour> findAll(PageAble pageAble){
        return tourDao.findAll(pageAble);
    }
    public Tour findById(int id){
        return tourDao.findById(id);
    }
    public void create(Tour tour){
        tourDao.insertTour(tour);
    }
    public int findId(){
       return tourDao.findID();
    }
    public void edit(Tour tour){
        tourDao.updateTour(tour);
    }
    public void delete(int id ){
        tourDao.deleteTour(id);
    }
}
