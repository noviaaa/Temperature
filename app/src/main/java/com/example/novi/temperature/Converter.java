package com.example.novi.temperature;

public class Converter {


    private double temperature = 0;


    public Converter(){
        }

    public Converter(double temperature){
        this.temperature = temperature;
        }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getCelcius() {
        return temperature;
    }

    public double getKelvin() {
        temperature = (getCelcius() + 273.15);
        return temperature;
    }

    public double getFahrenheit() {
        temperature = (getCelcius()*1.8) + 32.0;
        return temperature;
    }
}
