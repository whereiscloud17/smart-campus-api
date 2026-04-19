package com.example.smartcampus.config;

import com.example.smartcampus.resource.RoomResource;
import com.example.smartcampus.resource.SensorReadingResource;
import com.example.smartcampus.resource.SensorResource;
import com.example.smartcampus.resource.TestResource;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(TestResource.class);
        register(RoomResource.class);
        register(SensorResource.class);
        register(SensorReadingResource.class);
    }
}