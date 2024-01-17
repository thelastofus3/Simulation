package com.simulation.essence;

import com.simulation.Coordinates;
import com.simulation.Map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Creature extends Entity {

    public int speed;
    public int health;
    public abstract void makeMove();

    public abstract boolean checkTarget(Entity entity);

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    protected ArrayList<Integer> findPathToTheObject(Map map){
        ArrayList<Integer> path = new ArrayList<>();
        Queue<ArrayList<Integer>> queueEntity = new LinkedList<>();
        ArrayList<Integer> isVisited = new ArrayList<>();
        int index = super.coordinates.getX() * map.height + super.coordinates.getY();
        path.add(index);
        queueEntity.add(path);

        while (!queueEntity.isEmpty()){
            ArrayList<Integer> currentPath = queueEntity.remove();
            int lastIndexCurrentPath = currentPath.get(currentPath.size() - 1);
            Entity targetEntity = map.getEntity(new Coordinates(lastIndexCurrentPath / map.height, lastIndexCurrentPath % map.height));
            if(checkTarget(targetEntity)){
                return currentPath;
            }else {
                int row = lastIndexCurrentPath/ map.height;
                int col = lastIndexCurrentPath% map.height;
                for (int i = -1; i <= 1; i++) {
                    for(int j = -1; j <= 1; j++){
                        int currentIndex = (row + i) * map.height + (col+j);
                        if ((currentIndex >= 0 && currentIndex < map.height * map.width) &&
                                (col + j >= 0 && col + j < map.width)) {
                            if (!isVisited.contains(currentIndex)) {
                                if (!notAllowedEntitiesToPass(map.getEntity(new Coordinates(currentIndex / map.height, currentIndex % map.height)))) {
                                    ArrayList<Integer> newPath = new ArrayList<>(currentPath);
                                    newPath.add(currentIndex);
                                    queueEntity.add(newPath);
                                    isVisited.add(currentIndex);
                                }
                            }
                        }
                    }
                }
            }

        }


        return null;
    }


    protected List<Integer> makeMove(Map worldMap) {

        List<Integer> pathToObject = findPathToTheObject(worldMap);

        if (findPathToTheObject(worldMap) != null) {
            if (pathToObject.size() > 1) {
                int currentIndex = pathToObject.remove(0); // Извлекаем первый элемент пути и делаем его пустой ячейкой
                Coordinates coordinates = new Coordinates(currentIndex/ worldMap.height , currentIndex  % worldMap.height);
                Entity changeEntityTo = new Entity(coordinates);
                worldMap.setEntity(changeEntityTo);
                currentIndex = pathToObject.remove(0); // Извлекаем следующий элемент пути и ставим на него текущее существо
                coordinates = new Coordinates(currentIndex/ worldMap.height , currentIndex  % worldMap.height);
                this.setCoordinates(coordinates);
                worldMap.setEntity(this);
            }
        }
        else {
            return findPathToTheObject(worldMap);
        }
        return pathToObject;
    }
    protected abstract boolean notAllowedEntitiesToPass(Entity entity);

}
