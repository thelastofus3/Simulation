package com.simulation;

import com.simulation.essence.Creature;
import com.simulation.essence.Entity;
import com.simulation.essence.Herbivore;

import java.util.HashMap;
import java.util.Iterator;

public class Map {

    public int width ;
    public int height;

    private final HashMap<Coordinates,Entity> cells;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new HashMap<>();
    }

    public void placeEntity(Entity entity, Coordinates coordinates) {
        entity.coordinates = coordinates;

        cells.put(coordinates,entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return cells.get(coordinates);
    }
    public boolean isCellEmpty(Coordinates coordinates) {
        return cells.containsKey(coordinates);
    }
    public void removeEntity(Coordinates coordinates) {
        cells.remove(coordinates);
    }

    public void setEntity(Entity entity) {
        int index = entity.coordinates.getX() * height + entity.coordinates.getY();
        cells.put(entity.coordinates, entity);
    }

//    public void setEntity(final Entity entity) {
//        int index = entity.coordinates.getX() * height + entity.coordinates.getY();
//        map.set(index, entity);
//    }

    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entity = getEntity(from);

        // Проверка наличия объекта по исходным координатам
        if (entity != null) {
            removeEntity(from); // Удаление объекта с исходных координат
            placeEntity(entity, to); // Помещение объекта в новые координаты
        } else {
            // Обработка случая, когда объекта по указанным координатам нет
            System.out.println("Объект не найден по исходным координатам: " + from);
        }
    }
}
