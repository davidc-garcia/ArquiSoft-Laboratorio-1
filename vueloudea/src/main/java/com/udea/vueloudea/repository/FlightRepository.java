package com.udea.vueloudea.repository;

import com.udea.vueloudea.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndFlightType(
            LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, String flightType);

    List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndFlightType(
            LocalDate startDate, LocalDate endDate, String origin, String destination, String flightType);

    List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndFlightType(
            LocalDate startDate, LocalDate endDate, String origin, Double maxPrice, String flightType);

    List<Flight> findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndFlightType(
            LocalDate startDate, LocalDate endDate, String destination, Double maxPrice, String flightType);

    List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndFlightType(
            LocalDate startDate, LocalDate endDate, String origin, String flightType);

    List<Flight> findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndFlightType(
            LocalDate startDate, LocalDate endDate, String destination, String flightType);

    List<Flight> findByDepartureDateBetweenAndPriceLessThanEqualAndFlightType(
            LocalDate startDate, LocalDate endDate, Double maxPrice, String flightType);

    List<Flight> findByDepartureDateBetweenAndFlightType(
            LocalDate startDate, LocalDate endDate, String flightType);

    List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination);
    List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice);

    List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate, String origin, Double maxPrice);

    List<Flight> findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate, String destination, Double maxPrice);

    List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin);

    List<Flight> findByDepartureDateBetweenAndDestinationContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String destination);

    List<Flight> findByDepartureDateBetweenAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate, Double maxPrice);

        List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndFlightTypeAndAirplaneType(
        LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, String flightType, String airplaneType);
        
        List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndFlightTypeAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String origin, String destination, String flightType, String airplaneType);
        
        List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndFlightTypeAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String origin, Double maxPrice, String flightType, String airplaneType);
        
        List<Flight> findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndFlightTypeAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String destination, Double maxPrice, String flightType, String airplaneType);
        
        List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndFlightTypeAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String origin, String flightType, String airplaneType);
        
        List<Flight> findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndFlightTypeAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String destination, String flightType, String airplaneType);
        
        List<Flight> findByDepartureDateBetweenAndPriceLessThanEqualAndFlightTypeAndAirplaneType(
                LocalDate startDate, LocalDate endDate, Double maxPrice, String flightType, String airplaneType);
        
        List<Flight> findByDepartureDateBetweenAndFlightTypeAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String flightType, String airplaneType);
    
        List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, String airplaneType);
        
        List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String origin, String destination, String airplaneType);
    
        List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String origin, Double maxPrice, String airplaneType);
    
        List<Flight> findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String destination, Double maxPrice, String airplaneType);
    
        List<Flight> findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String origin, String airplaneType);
    
        List<Flight> findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String destination, String airplaneType);
    
        List<Flight> findByDepartureDateBetweenAndPriceLessThanEqualAndAirplaneType(
                LocalDate startDate, LocalDate endDate, Double maxPrice, String airplaneType);
    
        List<Flight> findByDepartureDateBetweenAndAirplaneType(
                LocalDate startDate, LocalDate endDate, String airplaneType);

    List<Flight> findByDepartureDateBetween(
            LocalDate startDate, LocalDate endDate);
}
