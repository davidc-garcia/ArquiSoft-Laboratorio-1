import React, { useState } from "react";
import './App.css';

const FlightSearch = () => {
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [filterByOrigin, setFilterByOrigin] = useState(false);
  const [origin, setOrigin] = useState("");
  const [filterByDestination, setFilterByDestination] = useState(false);
  const [destination, setDestination] = useState("");
  const [filterByMaxPrice, setFilterByMaxPrice] = useState(false);
  const [maxPrice, setMaxPrice] = useState("");
  const [filterByFlightType, setFilterByFlightType] = useState(false);
  const [flightType, setFlightType] = useState("");
  const [filterByAircraftType, setFilterByAircraftType] = useState(false);
  const [aircraftType, setAircraftType] = useState("");
  const [flights, setFlights] = useState([]);

  const handleSearch = async () => {
    let url = `http://localhost:8080/api/flights/search?startDate=${startDate}&endDate=${endDate}`;

    if (filterByOrigin && origin) {
      url += `&origin=${origin}`;
    }
    if (filterByDestination && destination) {
      url += `&destination=${destination}`;
    }
    if (filterByMaxPrice && maxPrice) {
      url += `&maxPrice=${maxPrice}`;
    }
    if (filterByFlightType && flightType) {
      url += `&flightType=${flightType}`;
    }
    if (filterByAircraftType && aircraftType) {
      url += `&airplaneType=${aircraftType}`;
    }

    try {
      const response = await fetch(url);
      const data = await response.json();
      setFlights(data);
      console.log(flights) //Para quitar
    } catch (error) {
      console.error("Error fetching flights:", error);
    }
  };

  return (
    <div className="container">
      <h1>Flight Search</h1>
      <div className="form-container">
        <h2>Search Flights</h2>
        <label>Start Date:</label>
        <input type="date" value={startDate} onChange={(e) => setStartDate(e.target.value)} />
        <br />
        <label>End Date:</label>
        <input type="date" value={endDate} onChange={(e) => setEndDate(e.target.value)} />
        <br />
        <input type="checkbox" checked={filterByOrigin} onChange={(e) => setFilterByOrigin(e.target.checked)} />
        <label>Filter by Origin</label>
        {filterByOrigin && (
          <input type="text" placeholder="Enter origin" value={origin} onChange={(e) => setOrigin(e.target.value)} />
        )}
        <br />
        <input type="checkbox" checked={filterByDestination} onChange={(e) => setFilterByDestination(e.target.checked)} />
        <label>Filter by Destination</label>
        {filterByDestination && (
          <input type="text" placeholder="Enter destination" value={destination} onChange={(e) => setDestination(e.target.value)} />
        )}
        <br />
        <input type="checkbox" checked={filterByMaxPrice} onChange={(e) => setFilterByMaxPrice(e.target.checked)} />
        <label>Filter by Max Price</label>
        {filterByMaxPrice && (
          <input type="number" placeholder="Enter max price" value={maxPrice} onChange={(e) => setMaxPrice(e.target.value)} />
        )}
        <br />
        <input type="checkbox" checked={filterByFlightType} onChange={(e) => setFilterByFlightType(e.target.checked)} />
        <label>Filter by Flight Type</label>
        {filterByFlightType && (
          <select value={flightType} onChange={(e) => setFlightType(e.target.value)}>
            <option value="">Select Flight Type</option>
            <option value="Domestic">Domestic</option>
            <option value="International">International</option>
          </select>
        )}
        <br />
        <input type="checkbox" checked={filterByAircraftType} onChange={(e) => setFilterByAircraftType(e.target.checked)} />
        <label>Filter by Aircraft Type</label>
        {filterByAircraftType && (
          <input type="text" placeholder="Enter aircraft type" value={aircraftType} onChange={(e) => setAircraftType(e.target.value)} />
        )}
        <br />
        <button onClick={handleSearch}>Search Flights</button>
      </div>

      <div className="table-container">
        <h2>Available Flights</h2>
        <table className="table">
          <thead>
            <tr>
              <th>Departure Date</th>
              <th>Arrival Date</th>
              <th>Origin</th>
              <th>Destination</th>
              <th>Price</th>
              <th>Flight Type</th>
              <th>Aircraft Type</th>
            </tr>
          </thead>
          <tbody>
            {flights.map((flight, index) => (
              <tr key={index}>
                <td>{flight.departureDate}</td>
                <td>{flight.arrivalDate}</td>
                <td>{flight.origin}</td>
                <td>{flight.destination}</td>
                <td>${flight.price.toFixed(2)}</td>
                <td>{flight.flightType}</td>
                <td>{flight.airplaneType}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default FlightSearch;