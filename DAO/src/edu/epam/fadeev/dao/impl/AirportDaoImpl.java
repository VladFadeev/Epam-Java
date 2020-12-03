package edu.epam.fadeev.dao.impl;

import edu.epam.fadeev.dao.AirportDao;
import edu.epam.fadeev.dao.DaoException;
import edu.epam.fadeev.entity.Airline;
import edu.epam.fadeev.entity.Weekday;
import edu.epam.fadeev.storage.Airport;

import java.time.LocalTime;
import java.util.*;


import static edu.epam.fadeev.dao.DaoErrorCode.*;

public class AirportDaoImpl implements AirportDao {
    @Override
    public void add(Airline airline) throws DaoException {
        List<Airline> schedule = Airport.getInstance().getSchedule();
        try {
            schedule.add(airline);
            Airport.getInstance().setSchedule(schedule);
        } catch (NullPointerException e) {
            throw new DaoException(e, EXC_DAO_002, airline);
        }
    }

    @Override
    public void delete(Airline airline) throws DaoException {
        List<Airline> schedule = Airport.getInstance().getSchedule();
        if(schedule.remove(airline)) {
            Airport.getInstance().setSchedule(schedule);
        } else {
            throw new DaoException(EXC_DAO_004, airline);
        }
    }

    @Override
    public void update(Airline airline) throws DaoException {
        List<Airline> schedule = Airport.getInstance().getSchedule();
        try {
            Airline airlineUpdate = findByFlightNumber(airline.getFlightNumber());
            schedule.remove(airlineUpdate);
            schedule.add(airline);
            Airport.getInstance().setSchedule(schedule);
        } catch (DaoException | NullPointerException e){
            throw new DaoException(e, EXC_DAO_003, airline);
        }
    }

    @Override
    public Airline findByFlightNumber(int flightNumber) throws DaoException {
        List<Airline> schedule = Airport.getInstance().getSchedule();
        Optional<Airline> airlineTemp = schedule.stream()
                                                .filter(airline -> airline.getFlightNumber() == flightNumber)
                                                .findFirst();
        try {
            return new Airline(airlineTemp.get());
        } catch (NoSuchElementException e) {
            throw new DaoException(e, EXC_DAO_000, flightNumber);
        }
    }

    @Override
    public Airline findByDestinationAndDepartureAndWeekday(String destination, LocalTime departure, EnumSet<Weekday> weekdays) throws DaoException {
        List<Airline> schedule = Airport.getInstance().getSchedule();
        Optional<Airline> airlineTemp = schedule.stream()
                                                .filter(airline -> (airline.getDeparture() == departure && airline.getWeekdays().equals(weekdays)
                                                                    && airline.getDestination() == destination))
                                                .findFirst();
        try {
            return airlineTemp.get();
        } catch (NoSuchElementException e) {
            throw new DaoException(e, EXC_DAO_000, destination, departure, weekdays);
        }
    }

    @Override
    public List<Airline> findByDestination(String destination) throws DaoException {
        List<Airline> out = new ArrayList<>();
        List<Airline> schedule = findAll();
        for (int i = 0; i < schedule.size(); i++) {
            if (schedule.get(i).getDestination().equals(destination)) {
                out.add(schedule.get(i));
            }
        }
        return out;
    }

    @Override
    public List<Airline> findByWeekdayAndTime(Weekday weekday, LocalTime time) throws DaoException {
        List<Airline> schedule = findAll();
        List<Airline> out = new ArrayList<>();
        for (int i = 0; i < schedule.size(); i++) {
            if(schedule.get(i).isWeekdayIn(weekday) && time.compareTo(schedule.get(i).getDeparture()) < 0)
                out.add(schedule.get(i));
        }
        return out;
    }

    @Override
    public List<Airline> findByWeekday(Weekday weekday) throws DaoException {
        List<Airline> out = new ArrayList<>();
        List<Airline> schedule = findAll();
        for (int i = 0; i < schedule.size(); i++) {
            if (schedule.get(i).isWeekdayIn(weekday)) {
                out.add(schedule.get(i));
            }
        }
        return out;
    }

    @Override
    public List<Airline> findAll() throws DaoException {
        if(Airport.getInstance().getSchedule().isEmpty()){
            throw new DaoException(EXC_DAO_001);
        }
        List<Airline> airlineTemp = new ArrayList<>();
        for (int i = 0; i < Airport.getInstance().getScheduleSize(); i++) {
            Airline airline = new Airline(Airport.getInstance().getSchedule().get(i));
            airlineTemp.add(airline);
        }
        return airlineTemp;
    }
}
