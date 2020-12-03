package edu.epam.fadeev.entity;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;

public class Airline {
    private String destination;
    private int flightNumber;
    private PlaneType planeType;
    private LocalTime departure;
    private EnumSet<Weekday> weekdays;

    public Airline(String destination, int flightNumber, PlaneType planeType,
                   LocalTime departure, Weekday[] weekdays) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.departure = departure;
        this.weekdays = EnumSet.copyOf(Arrays.asList(weekdays));
    }

    public Airline(Airline airline) {
        this.destination = airline.getDestination();
        this.flightNumber = airline.getFlightNumber();
        this.planeType = airline.getPlaneType();
        this.departure = airline.getDeparture();
        this.weekdays = EnumSet.copyOf(airline.getWeekdays());
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public  void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public  void setWeekdays(Weekday[] weekdays) {
        this.weekdays = EnumSet.copyOf(Arrays.asList(weekdays));
    }

    public String getDestination() {
        return destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public EnumSet<Weekday> getWeekdays() {
        return weekdays;
    }

    public boolean isWeekdayIn(Weekday weekday) {
        return weekdays.contains(weekday);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return flightNumber == airline.flightNumber &&
                Objects.equals(destination, airline.destination) &&
                planeType == airline.planeType &&
                Objects.equals(departure, airline.departure) &&
                Objects.equals(weekdays, airline.weekdays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, flightNumber, planeType, departure, weekdays);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Airline{");
        sb.append("destination='").append(destination).append('\'');
        sb.append(", flightNumber=").append(flightNumber);
        sb.append(", planeType=").append(planeType);
        sb.append(", departure=").append(departure);
        sb.append(", weekdays=").append(weekdays);
        sb.append('}');
        return sb.toString();
    }
}
