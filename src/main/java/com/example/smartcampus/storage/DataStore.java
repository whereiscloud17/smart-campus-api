package com.example.smartcampus.storage;

import com.example.smartcampus.model.Room;
import com.example.smartcampus.model.Sensor;
import com.example.smartcampus.model.SensorReading;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataStore {

    public static final Map<String, Room> rooms = new LinkedHashMap<>();
    public static final Map<String, Sensor> sensors = new LinkedHashMap<>();
    public static final Map<String, SensorReading> readings = new LinkedHashMap<>();

    static {
        Room room1 = new Room("LIB-301", "Library Quiet Study", 40);
        Room room2 = new Room("ENG-201", "Engineering Lab", 25);

        rooms.put(room1.getId(), room1);
        rooms.put(room2.getId(), room2);

        Sensor sensor1 = new Sensor("TEMP-001", "Temperature", "ACTIVE", 22.5, "LIB-301");
        Sensor sensor2 = new Sensor("CO2-001", "CO2", "ACTIVE", 410.0, "ENG-201");

        sensors.put(sensor1.getId(), sensor1);
        sensors.put(sensor2.getId(), sensor2);

        room1.getSensorIds().add(sensor1.getId());
        room2.getSensorIds().add(sensor2.getId());

        SensorReading reading1 = new SensorReading("R-1001", 22.5, "2026-04-19T23:20:00", "TEMP-001");
        SensorReading reading2 = new SensorReading("R-1002", 410.0, "2026-04-19T23:25:00", "CO2-001");

        readings.put(reading1.getId(), reading1);
        readings.put(reading2.getId(), reading2);
    }

    private DataStore() {}
}