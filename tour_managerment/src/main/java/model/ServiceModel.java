package model;

public class ServiceModel {
    private int id;
    private Hotel hotel;
    private Transport transport;
    private double totalPrice;

    private String description;


    public ServiceModel(int id, Hotel hotelName, Transport transportName, double totalPrice, String description) {
        this.id = id;
        this.hotel = hotelName;
        this.transport = transportName;
        this.totalPrice = totalPrice;
        this.description = description;
    }

    public ServiceModel(Hotel hotelName, Transport transportName, double totalPrice, String description) {
        this.hotel = hotelName;
        this.transport = transportName;
        this.totalPrice = totalPrice;
        this.description = description;
    }

    public ServiceModel(Hotel hotel, Transport transport) {
        this.hotel = hotel;
        this.transport = transport;
    }

    public ServiceModel(int id, Hotel hotel, Transport transport) {
        this.id = id;
        this.hotel = hotel;
        this.transport = transport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hotel getHotelName() {
        return hotel;
    }

    public void setHotelName(Hotel hotelName) {
        this.hotel = hotelName;
    }

    public Transport getTransportName() {
        return transport;
    }

    public void setTransportName(Transport transportName) {
        this.transport = transportName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
