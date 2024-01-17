package com.simulation.essence;

import com.simulation.Coordinates;
import com.simulation.Map;
import com.simulation.staticObject.Grass;
import com.simulation.staticObject.Rock;
import com.simulation.staticObject.Tree;

import java.util.*;

public class Predator extends Creature{
    int attack = 10;
    public Predator(Coordinates coordinates) {
        super(coordinates);
        super.speed = 20;
        super.health = 10;
    }

    @Override
    public boolean notAllowedEntitiesToPass(Entity entity) {
        if (entity instanceof Grass ||
                entity instanceof Rock ||
                entity instanceof Tree ||
                entity instanceof Predator) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public List<Integer> makeMove(Map worldMap) {
        List<Integer> pathToTarget = findPathToTheObject(worldMap);
//        System.out.println("Tiger");
//        System.out.println(pathToTarget);

        if (pathToTarget != null && pathToTarget.size() > 1) {
            int currentIndex = pathToTarget.remove(0);
//            System.out.println("Current = " + currentIndex);
//            Coordinates nextCoordinates = new Coordinates(currentIndex / worldMap.width, currentIndex % worldMap.height);
            int nextIndex = pathToTarget.get(0);
            Coordinates nextCoordinates = new Coordinates(nextIndex / worldMap.width, nextIndex % worldMap.height);
//            System.out.println("Next = " + nextCoordinates.toString());

            // Перемещаем объект Herbivore на следующие координаты
            worldMap.moveEntity(this.getCoordinates(), nextCoordinates);
            this.setCoordinates(nextCoordinates);
        }
        return pathToTarget;
    }

    @Override
    public void makeMove() {

    }

    @Override
    public boolean checkTarget(Entity entity) {
        return entity instanceof Herbivore;
    }


    @Override
    public String toString() {
        return "\uD83D\uDC05";
    }
}
