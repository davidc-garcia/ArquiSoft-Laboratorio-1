package com.udea.vueloudea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String flightType;  // Nacional o Internacional
    private String origin;
    private String destination;
    private String airplaneType;  // Tipo de avión (A320, B737, etc.)
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private double price;
    private double taxPercentage;  // Porcentaje de impuestos
    private double surchargePercentage;  // Sobretasa en porcentaje

    // Constructor vacío
    public Flight() {
    }

    // Constructor con todos los campos
    public Flight(Long id, String flightNumber, String flightType, String origin, String destination,
                  String airplaneType, LocalDate departureDate, LocalDate arrivalDate, LocalTime departureTime,
                  LocalTime arrivalTime, double price, double taxPercentage, double surchargePercentage) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.flightType = flightType;
        this.origin = origin;
        this.destination = destination;
        this.airplaneType = airplaneType;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.taxPercentage = taxPercentage;
        this.surchargePercentage = surchargePercentage;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double getSurchargePercentage() {
        return surchargePercentage;
    }

    public void setSurchargePercentage(double surchargePercentage) {
        this.surchargePercentage = surchargePercentage;
    }

    // Métodos equals y hashCode basados en el id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
