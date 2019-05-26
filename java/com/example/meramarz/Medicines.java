package com.example.meramarz;

public class Medicines {

    private String number;
    private String medicine;
    private String quantity;
    private String morning;
    private String afternoon;
    private String night;

    public void setNumber(String number){
        this.number = number;
    }

    public void setMedicine(String medicine){
        this.medicine = medicine;
    }

    public void setQuantity(String quantity){
        this.quantity = quantity;
    }

    public void setMorning(String morning){
        this.morning = morning;
    }

    public void setAfternoon(String afternoon ){
        this.afternoon = afternoon;
    }

    public void setNight(String night){
        this.night = night;
    }

    public String getNumber(){
        return number;
    }

    public String getMedicine(){
        return medicine;
    }

    public String getQuantity(){
        return quantity;
    }

    public String getMorning(){
        return morning;
    }

    public String getAfternoon(){
        return afternoon;
    }

    public String getNight(){
        return night;
    }
}
