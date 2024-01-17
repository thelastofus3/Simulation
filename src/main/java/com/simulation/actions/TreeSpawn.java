package com.simulation.actions;

import com.simulation.Coordinates;
import com.simulation.Map;
import com.simulation.MapRender;
import com.simulation.essence.Entity;
import com.simulation.staticObject.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeSpawn extends Tree implements SpawnActions{
    @Override
    public Coordinates getRandomCoordinates(Map map) {
        return SpawnActions.super.getRandomCoordinates(map);
    }
    public void spawnEntity(Map map) {
        // Количество деревьев для спавна
        int numberOfTrees = 10;
        for (int i = 0; i < numberOfTrees; i++) {
            // Получаем случайные координаты для спавна дерева
            Coordinates treeCoordinates = getRandomCoordinates(map);

            // Создаем новое дерево с полученными координатами и помещаем его на карту
            Tree tree = new Tree(treeCoordinates);
            map.placeEntity(tree, treeCoordinates);
        }
    }
}

