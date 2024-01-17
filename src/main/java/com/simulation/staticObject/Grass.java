package com.simulation.staticObject;

import com.simulation.Coordinates;
import com.simulation.essence.Entity;

public class Grass extends Entity {
    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD66";
    }
    public Grass() {}
}
