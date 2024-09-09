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
                                    String flightType, String airplaneType) {
        // Adaptar el switch para manejar los nuevos parámetros
        String key = (origin != null ? "1" : "0") +
                (destination != null ? "1" : "0") +
                (maxPrice != null ? "1" : "0") +
                (flightType != null ? "1" : "0")+
                (airplaneType != null ? "1" : "0");

        return switch (key) {
            case "11110" -> // origin, destination, maxPrice, flightType no son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndFlightType(
                            startDate, endDate, origin, destination, maxPrice, flightType);
            case "11010" -> // origin, destination, flightType no son nulos, maxPrice es nulo
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndFlightType(
                            startDate, endDate, origin, destination, flightType);
            case "10110" -> // origin, maxPrice, flightType no son nulos, destination es nulo
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndFlightType(
                            startDate, endDate, origin, maxPrice, flightType);
            case "01110" -> // destination, maxPrice, flightType no son nulos, origin es nulo
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndFlightType(
                            startDate, endDate, destination, maxPrice, flightType);
            case "10010" -> // origin, flightType no son nulos, destination y maxPrice son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndFlightType(
                            startDate, endDate, origin, flightType);
            case "01010" -> // destination, flightType no son nulos, origin y maxPrice son nulos
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndFlightType(
                            startDate, endDate, destination, flightType);
            case "00110" -> // maxPrice, flightType no son nulos, origin y destination son nulos
                    flightRepository.findByDepartureDateBetweenAndPriceLessThanEqualAndFlightType(
                            startDate, endDate, maxPrice, flightType);
            case "00010" -> // solo flightType no es nulo
                    flightRepository.findByDepartureDateBetweenAndFlightType(startDate, endDate, flightType);
            case "11100" -> // origin, destination, maxPrice no son nulos, flightType es nulo
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, origin, destination, maxPrice);
            case "11000" -> // origin, destination no son nulos, maxPrice y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
                            startDate, endDate, origin, destination);
            case "10100" -> // origin y maxPrice no son nulos, destination y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, origin, maxPrice);
            case "01100" -> // destination y maxPrice no son nulos, origin y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, destination, maxPrice);
            case "10000" -> // solo origin no es nulo, destination, maxPrice y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCase(startDate, endDate, origin);
            case "01000" -> // solo destination no es nulo, origin, maxPrice y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCase(startDate, endDate, destination);
            case "00100" -> // solo maxPrice no es nulo, origin, destination y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndPriceLessThanEqual(startDate, endDate, maxPrice);
            case "00000" -> // todos son nulos
                    flightRepository.findByDepartureDateBetween(startDate, endDate);

            case "11111" -> // origin, destination, maxPrice, flightType no son nulos
                flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndFlightTypeAndAirplaneType(startDate, endDate, origin, destination, maxPrice, flightType, airplaneType);
            case "11011" -> // origin, destination, flightType no son nulos, maxPrice es nulo
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndFlightTypeAndAirplaneType(startDate, endDate, origin, destination, flightType, airplaneType);
            case "10111" -> // origin, maxPrice, flightType no son nulos, destination es nulo
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndFlightTypeAndAirplaneType(startDate, endDate, origin, maxPrice, flightType, airplaneType);
            case "01111" -> // destination, maxPrice, flightType no son nulos, origin es nulo
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndFlightTypeAndAirplaneType(startDate, endDate, destination, maxPrice, flightType, airplaneType);
            case "10011" -> // origin, flightType no son nulos, destination y maxPrice son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndFlightTypeAndAirplaneType(startDate, endDate, origin, flightType, airplaneType);
            case "01011" -> // destination, flightType no son nulos, origin y maxPrice son nulos
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndFlightTypeAndAirplaneType(startDate, endDate, destination, flightType, airplaneType);
            case "00111" -> // maxPrice, flightType no son nulos, origin y destination son nulos
                    flightRepository.findByDepartureDateBetweenAndPriceLessThanEqualAndFlightTypeAndAirplaneType(startDate, endDate, maxPrice, flightType, airplaneType);
            case "00011" -> // solo flightType no es nulo
                    flightRepository.findByDepartureDateBetweenAndFlightTypeAndAirplaneType(startDate, endDate, flightType, airplaneType);
            case "11101" -> // origin, destination, maxPrice no son nulos, flightType es nulo
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndAirplaneType(startDate, endDate, origin, destination, maxPrice, airplaneType);
            case "11001" -> // origin, destination no son nulos, maxPrice y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndAirplaneType(startDate, endDate, origin, destination, airplaneType);
            case "10101" -> // origin y maxPrice no son nulos, destination y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndAirplaneType(startDate, endDate, origin, maxPrice, airplaneType);
            case "01101" -> // destination y maxPrice no son nulos, origin y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndAirplaneType(startDate, endDate, destination, maxPrice, airplaneType);
            case "10001" -> // solo origin no es nulo, destination, maxPrice y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndOriginContainingIgnoreCaseAndAirplaneType(startDate, endDate, origin, airplaneType);
            case "01001" -> // solo destination no es nulo, origin, maxPrice y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndDestinationContainingIgnoreCaseAndAirplaneType(startDate, endDate, destination, airplaneType);
            case "00101" -> // solo maxPrice no es nulo, origin, destination y flightType son nulos
                    flightRepository.findByDepartureDateBetweenAndPriceLessThanEqualAndAirplaneType(startDate, endDate, maxPrice, airplaneType);
            case "00001" -> // todos son nulos
                    flightRepository.findByDepartureDateBetweenAndAirplaneType(startDate, endDate, airplaneType);
            
            
            default -> flightRepository.findByDepartureDateBetween(startDate, endDate);
        };
    }

}
