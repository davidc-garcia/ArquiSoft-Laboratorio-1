package com.udea.vueloudea.service;

import com.udea.vueloudea.model.Flight;
import com.udea.vueloudea.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findFlights(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice,
                                    String flightType) {
        // Adaptar el switch para manejar los nuevos parámetros
        String key = (origin != null ? "1" : "0") +
                (destination != null ? "1" : "0") +
                (maxPrice != null ? "1" : "0") +
                (flightType != null ? "1" : "0");
        return switch (key) {
            case "1111" -> // origin, destination, maxPrice, flightType no son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndFlightType(
                            startDate, endDate, origin, destination, maxPrice, flightType);
            case "1101" -> // origin, destination, flightType no son nulos, maxPrice es nulo
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndFlightType(
                            startDate, endDate, origin, destination, flightType);
            case "1011" -> // origin, maxPrice, flightType no son nulos, destination es nulo
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndFlightType(
                            startDate, endDate, origin, maxPrice, flightType);
            case "0111" -> // destination, maxPrice, flightType no son nulos, origin es nulo
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndFlightType(
                            startDate, endDate, destination, maxPrice, flightType);
            case "1001" -> // origin, flightType no son nulos, destination y maxPrice son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndFlightType(
                            startDate, endDate, origin, flightType);
            case "0101" -> // destination, flightType no son nulos, origin y maxPrice son nulos
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndFlightType(
                            startDate, endDate, destination, flightType);
            case "0011" -> // maxPrice, flightType no son nulos, origin y destination son nulos
                    flightRepository.findByDepartureDateBetweenAndPriceLessThanEqualAndFlightType(
                            startDate, endDate, maxPrice, flightType);
            case "0001" -> // solo flightType no es nulo
                    flightRepository.findByDepartureDateBetweenAndFlightType(startDate, endDate, flightType);
            case "1110" -> // origin, destination, maxPrice no son nulos, flightType es nulo
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, origin, destination, maxPrice);
            case "1100" -> // origin, destination no son nulos, maxPrice y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
                            startDate, endDate, origin, destination);
            case "1010" -> // origin y maxPrice no son nulos, destination y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, origin, maxPrice);
            case "0110" -> // destination y maxPrice no son nulos, origin y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, destination, maxPrice);
            case "1000" -> // solo origin no es nulo, destination, maxPrice y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCase(startDate, endDate, origin);
            case "0100" -> // solo destination no es nulo, origin, maxPrice y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCase(startDate, endDate, destination);
            case "0010" -> // solo maxPrice no es nulo, origin, destination y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndPriceLessThanEqual(startDate, endDate, maxPrice);
            case "0000" -> // todos son nulos
                    flightRepository.findByDepartureDateBetween(startDate, endDate);
            default -> flightRepository.findByDepartureDateBetween(startDate, endDate);
        };
    }

}
