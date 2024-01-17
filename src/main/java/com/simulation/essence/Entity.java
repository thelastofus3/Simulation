package com.simulation.essence;

import com.simulation.Coordinates;
import com.simulation.Map;

import java.util.List;

public class Entity {
    public Coordinates coordinates;

    protected Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    protected Entity() {
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    protected void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    protected List<Integer> makeMove(Map map){

        return null;
    }

}
