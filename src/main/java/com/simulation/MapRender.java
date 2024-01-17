package com.simulation;

import com.simulation.essence.Entity;

public class MapRender {
    public void render(Map map) {
        for(int height = 0; height < map.height; height++){
            for (int width = 0; width < map.width; width++) {
                Coordinates coordinates = new Coordinates(width,height);
                Entity entity = map.getEntity(coordinates);
                if(entity != null){
                    System.out.print(entity);
                }else {
                    System.out.print("\uD83D\uDFEB");
                }
            }
            System.out.println();
        }
    }
}
