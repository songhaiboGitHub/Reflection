package com.shb;

public class Car {

    public String brand = "奔驰";
    private int price = 9000000;
    private String color = "黑色";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
