package com.simulation;

import com.simulation.actions.GrassSpawn;
import com.simulation.actions.RockSpawn;
import com.simulation.actions.TreeSpawn;
import com.simulation.essence.Herbivore;
import com.simulation.essence.Predator;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Simulation {
    private final Map map = new Map(10,10);
    private final MapRender render = new MapRender();
    private Scanner scanner = new Scanner(System.in);
    private Predator predator;
    private Herbivore herbivore1;
    private List<Integer> a;

    public void startSimulation(){
        spawnEntity();
        while (true){
            readFromKeyboard(map);
        }
    }
    public void readFromKeyboard(Map map) {
        System.out.println("------Game Simulation-------");
        System.out.println("---Press '1' for one move---");
        System.out.println("Press '2' for infinity moves");

        int number = scanner.nextInt();
            switch (number) {
                case 1:
                    InfinityLoop(map);
                    break;
                case 2:
                    oneMove(map);
        }
    }
    public void oneMove(Map map) {
        a = herbivore1.makeMove(map);
        if(a == null) {
            System.out.println("Pingvin win");
            System.exit(0);
        }
        a = predator.makeMove(map);
        if(a == null) {
            System.out.println("Tiger win");

            System.exit(0);
        }
        render.render(map);
    }
    public void InfinityLoop(Map map) {
        AtomicBoolean isFlag = new AtomicBoolean(true);
        Thread loop = new Thread(() ->  {
            try {
                while (isFlag.get()) {
                    a = herbivore1.makeMove(map);
                    if(a == null) {
                        System.out.println("Pingvin win");
                        System.exit(0);
                    }
                     a = predator.makeMove(map);
                    if(a == null) {
                        System.out.println("Tiger win");
                        System.exit(0);
                    }
                    render.render(map);

                    Thread.sleep(1000);
                    System.out.println("");
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        loop.start();

    }
    public void spawnEntity() {
        herbivore1 = new Herbivore(getRandomCoordinates(map));
        map.placeEntity(herbivore1,herbivore1.getCoordinates());

        predator = new Predator(getRandomCoordinates(map));
        map.placeEntity(predator,predator.getCoordinates());

        GrassSpawn grassSpawn = new GrassSpawn();
        grassSpawn.spawnEntity(map);

        RockSpawn rockSpawn = new RockSpawn();
        rockSpawn.spawnEntity(map);
        TreeSpawn treeSpawn = new TreeSpawn();
        treeSpawn.spawnEntity(map);
        render.render(map);
    }
    public Coordinates getRandomCoordinates(Map map) {
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

}
