package com.simulation.actions;

import com.simulation.Coordinates;
import com.simulation.Map;

import java.util.Random;

public interface SpawnActions {

    default Coordinates getRandomCoordinates(Map map) {
        Random random = new Random();

        // Генерируем случайные координаты, пока не найдем пустую ячейку на карте
        while (true) {
            int x = random.nextInt(map.width);
            int y = random.nextInt(map.height);
            Coordinates coordinates = new Coordinates(x, y);

            if (!map.isCellEmpty(coordinates)) {
                return coordinates;
            }
        }
    }
    void spawnEntity(Map map);
}
