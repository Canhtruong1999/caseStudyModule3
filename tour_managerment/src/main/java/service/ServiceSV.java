package service;

import dao.ServiceDAO;
import dto.Pageable;
import model.ServiceModel;

import java.util.List;

public class ServiceSV {
    private ServiceDAO serviceDAO = new ServiceDAO();
    public ServiceSV(){}

    public List<ServiceModel> findAll(Pageable pageable){
        return serviceDAO.findAll(pageable);
    }
    public ServiceModel findById(int id){
        return serviceDAO.findById(id);
    }
    public void createService(ServiceModel serviceModel){
        serviceDAO.createService(serviceModel);
    }
    public void editService(ServiceModel serviceModel){
        serviceDAO.editService(serviceModel);
    }
    public void deleteService(int id){
        serviceDAO.deleteService(id);
    }
}
