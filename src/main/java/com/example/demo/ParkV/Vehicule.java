package com.example.demo.ParkV;

public class Vehicule {

    private String type;
    private String mark;
    private int id;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public Vehicule(String type, String mark){

        this.type = type;
        this.mark = mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMark() {
        return mark;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Vehicule:" +
                "type='" + type + '\'' +
                ", mark='" + mark + '\'';
    }

    public Object getNom() {
        return null;
    }
}
