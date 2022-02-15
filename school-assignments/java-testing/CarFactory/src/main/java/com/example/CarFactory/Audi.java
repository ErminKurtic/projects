package com.example.CarFactory;

public class Audi implements Car {

    private String carModel = "Audi";
    private String licensePlate;
    private String carColor;
    private String carFuel = "Gasoline";

    public Audi(String carColor, String licensePlate) {
        this.licensePlate = licensePlate;
        setCarColor(carColor);
    }

    @Override
    public String getCarModel() {
        return this.carModel;
    }

    @Override
    public String getCarFuel() { return carFuel; }

    static String createLicensePlate() {
        // Generate three random uppercase letters
        int letter1 = 65 + (int) (Math.random() * (90 - 65));
        int letter2 = 65 + (int) (Math.random() * (90 - 65));
        int letter3 = 65 + (int) (Math.random() * (90 - 65));
        // Generate three random digits
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);
        int number3 = (int) (Math.random() * 10);
        // Display number plate
        return ("" + (char) (letter1) + ((char) (letter2)) +
                ((char) (letter3)) + number1 + number2 + number3);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarColor() { return carColor; }

    public void setCarColor(String carColor) { this.carColor = carColor; }
}
