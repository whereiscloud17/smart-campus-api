package com.example.smartcampus.resource;

import com.example.smartcampus.model.Sensor;
import com.example.smartcampus.model.SensorReading;
import com.example.smartcampus.storage.DataStore;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/sensors/{sensorId}/readings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorReadingResource {

    @GET
    public Response getReadings(@PathParam("sensorId") String sensorId) {

        Sensor sensor = DataStore.sensors.get(sensorId);

        if (sensor == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Sensor not found")
                    .build();
        }

        List<SensorReading> result = new ArrayList<>();

        for (SensorReading r : DataStore.readings.values()) {
            if (r.getSensorId().equals(sensorId)) {
                result.add(r);
            }
        }

        return Response.ok(result).build();
    }

    @POST
    public Response addReading(@PathParam("sensorId") String sensorId,
                               SensorReading reading,
                               @Context UriInfo uriInfo) {

        Sensor sensor = DataStore.sensors.get(sensorId);

        if (sensor == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Sensor not found")
                    .build();
        }

        if ("MAINTENANCE".equalsIgnoreCase(sensor.getStatus())) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Sensor in maintenance")
                    .build();
        }

        reading.setId("R-" + System.currentTimeMillis());
        reading.setSensorId(sensorId);
        reading.setTimestamp(java.time.LocalDateTime.now().toString());

        DataStore.readings.put(reading.getId(), reading);

        sensor.setCurrentValue(reading.getValue());

        URI uri = uriInfo.getAbsolutePathBuilder().path(reading.getId()).build();
        return Response.created(uri).entity(reading).build();
    }
}