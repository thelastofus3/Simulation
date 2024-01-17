package com.simulation.staticObject;

import com.simulation.Coordinates;
import com.simulation.essence.Entity;

public class Tree extends Entity {
    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }
    public Tree() {}
}
