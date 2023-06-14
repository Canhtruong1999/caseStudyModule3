package service;

import dao.TransportDAO;
import model.Transport;

import java.util.List;

public class TransportService {
    private TransportDAO transportDAO = new TransportDAO();

    public TransportService(){}

    public List<Transport> findAll(){
        return transportDAO.findAll();
    }

    public Transport findById(int id){
        return transportDAO.findById(id);
    }
}
