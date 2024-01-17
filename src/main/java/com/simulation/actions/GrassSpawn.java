package com.simulation.actions;

import com.simulation.Coordinates;
import com.simulation.Map;
import com.simulation.essence.Entity;
import com.simulation.staticObject.Grass;
import com.simulation.staticObject.Tree;

import java.util.ArrayList;
import java.util.List;

public class GrassSpawn extends Grass implements SpawnActions{

    @Override
    public Coordinates getRandomCoordinates(Map map) {
        return SpawnActions.super.getRandomCoordinates(map);
    }

    @Override
    public void spawnEntity(Map map) {
        // Количество деревьев для спавна
        int numberOfGrass = 3;

        for (int i = 0; i < numberOfGrass; i++) {
            // Получаем случайные координаты для спавна дерева
            Coordinates treeCoordinates = getRandomCoordinates(map);

            // Создаем новое дерево с полученными координатами и помещаем его на карту
            Grass grass = new Grass(treeCoordinates);
            map.placeEntity(grass, treeCoordinates);

        }
    }
}
