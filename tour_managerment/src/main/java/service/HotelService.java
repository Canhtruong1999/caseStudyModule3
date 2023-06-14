package service;

import dao.HotelDAO;
import model.Hotel;

import java.util.List;

public class HotelService {
    public HotelService(){}
    private HotelDAO hotelDAO = new HotelDAO();

    public List<Hotel> findAll(){
        return  hotelDAO.findAll();
    }

    public Hotel findById(int id){
        return hotelDAO.findById(id);
    }

}
