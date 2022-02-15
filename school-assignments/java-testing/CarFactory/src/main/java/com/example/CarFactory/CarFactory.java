package com.example.CarFactory;

public class CarFactory {

    private LicPlateGenerator licPlateGenerator;

    private String carModel;

    public CarFactory(LicPlateGenerator licPlateGenerator, String carModel) {
        this.licPlateGenerator = licPlateGenerator;
        this.carModel = carModel;
    }

    public Car createCarModel(String carColor){
        return switch (carModel) {
            case "Audi" ->
                new Audi(carColor, licPlateGenerator.newPlate());
            case "Toyota" ->
                new Toyota(carColor, licPlateGenerator.newPlate());
            default ->
                throw new IllegalStateException("Unexpected value: " + carModel);
        };
    }


    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}
