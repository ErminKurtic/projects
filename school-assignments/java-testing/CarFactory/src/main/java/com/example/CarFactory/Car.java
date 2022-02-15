package com.example.CarFactory;

public interface Car {

    String getCarModel();
    String getCarColor();
    String getCarFuel();

    //For making sure testing of licensePlate work
    CharSequence getLicensePlate();

}
