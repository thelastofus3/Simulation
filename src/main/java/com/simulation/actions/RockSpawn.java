package com.simulation.actions;

import com.simulation.Coordinates;
import com.simulation.Map;
import com.simulation.essence.Entity;
import com.simulation.staticObject.Rock;

import java.util.ArrayList;
import java.util.List;

public class RockSpawn extends Rock implements SpawnActions{


    @Override
    public Coordinates getRandomCoordinates(Map map) {
        return SpawnActions.super.getRandomCoordinates(map);
    }

    public void spawnEntity(Map map) {
        // Количество деревьев для спавна
        int numberOfRock = 8;

        for (int i = 0; i < numberOfRock; i++) {
            // Получаем случайные координаты для спавна дерева
            Coordinates treeCoordinates = getRandomCoordinates(map);

            // Создаем новое дерево с полученными координатами и помещаем его на карту
            Rock rock = new Rock(treeCoordinates);
            map.placeEntity(rock, treeCoordinates);
        }
    }

}
