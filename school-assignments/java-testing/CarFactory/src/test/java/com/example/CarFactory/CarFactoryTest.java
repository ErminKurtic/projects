package com.example.CarFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarFactoryTest {

    CarFactory carFactory = new CarFactory(() -> "ABC123","Audi");



    @Test
    void test_audi_creation_success() {
        Car car1 = carFactory.createCarModel( "Green");
        assertEquals("Audi", car1.getCarModel());
        assertEquals("ABC123", car1.getLicensePlate());
        assertEquals("Green", car1.getCarColor());
        assertEquals("Gasoline", car1.getCarFuel());
    }

    @Test
    void test_toyota_creation_success() {
        //Given
        carFactory.setCarModel("Toyota");
        //When
        Car car2 = carFactory.createCarModel("Pink");
        //Then
        assertEquals("Toyota", car2.getCarModel());
        assertEquals(6, car2.getLicensePlate().length());
        assertEquals("Pink", car2.getCarColor());
        assertEquals("Diesel", car2.getCarFuel());
    }

}
