package org.kaviya.hotel.model;

public class Room {
    private  int id;
    private RoomType type;
    private double price;
    private  RoomStatus status;

    public Room(int id, RoomType type, RoomStatus status, double price){
        this.id = id;
        this.type = type;
        this.status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public RoomType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
