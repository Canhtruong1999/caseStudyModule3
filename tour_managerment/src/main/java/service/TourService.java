package service;

import dao.TourDao;
import model.Tour;
import dto.Pageable;

import java.util.List;

public class TourService {
    TourDao tourDao=new TourDao();
    public List<Tour> findAll(Pageable pageAble){
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
