package com.simulation.staticObject;

import com.simulation.Coordinates;
import com.simulation.essence.Entity;

public class Rock extends Entity {
    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "\uD83E\uDEA8";
    }
  public Rock() {}
}
