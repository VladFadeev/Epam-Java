package edu.epam.fadeev.service;

import edu.epam.fadeev.dao.AirportDao;
import edu.epam.fadeev.dao.DaoException;
import edu.epam.fadeev.dao.impl.AirportDaoImpl;
import edu.epam.fadeev.entity.Airline;
import edu.epam.fadeev.entity.Weekday;
import edu.epam.fadeev.storage.Airport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AirportService {
    private AirportDao airportDao;
    private static final Logger log = LogManager.getLogger(AirportService.class);

    private AirportService(){
        airportDao = new AirportDaoImpl();
    }

    private static class AirportServiceHolder {
        private final static AirportService instance = new AirportService();
    }

    public static AirportService getInstance() {
        return AirportService.AirportServiceHolder.instance;
    }

    public List<Airline> findAirlinesByDestination(String destination) {
        List<Airline> out = new ArrayList<>();
        try {
            out = airportDao.findByDestination(destination);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
        }
        return out;
    }

    public List<Airline> findAirlinesByWeekday(Weekday weekday) {
        List<Airline> out = new ArrayList<>();
        try {
           out = airportDao.findByWeekday(weekday);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
        }
        return out;
    }

    public List<Airline> findAirlinesByWeekdayTime( Weekday weekday, LocalTime time) {
        List<Airline> out = new ArrayList<>();
        try {
            out = airportDao.findByWeekdayAndTime(weekday, time);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
        }
        return out;
    }
}
