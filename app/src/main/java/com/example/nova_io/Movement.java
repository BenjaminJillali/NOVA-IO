package com.example.nova_io;

public class Movement {
    private Node current_position;
    private Object character;
    public Enum move;
    public Movement(Object character){
        this.character = character;
    }
    public void move(String direction, Grid grid){
        int[] positions = {current_position.getX_position(), current_position.getY_position()};
        switch (direction){
            case "up":
                if(grid.getGrid_nodes().length > 0){
                    if(grid.getGrid_nodes()[positions[0]][positions[1] - 1] != null && grid.getNode(positions[0], positions[1] - 1).getPassable()){
                        character.setCurrentNode(grid.getNode(positions[0], positions[1] - 1), "character");
                    }
                }
                break;
            case "down":
                if(grid.getGrid_nodes().length > 0){
                    if(grid.getGrid_nodes()[positions[0]][positions[1] + 1] != null && grid.getNode(positions[0], positions[1] + 1).getPassable()){
                        character.setCurrentNode(grid.getNode(positions[0], positions[1] + 1), "character");
                    }
                }
                break;
            case "left":
                if(grid.getGrid_nodes().length > 0){
                    if(grid.getGrid_nodes()[positions[0] - 1][positions[1]] != null && grid.getNode(positions[0] - 1, positions[1]).getPassable()){
                        character.setCurrentNode(grid.getNode(positions[0] - 1, positions[1]), "character");
                    }
                }
                break;
            case "right":
                if(grid.getGrid_nodes().length > 0){
                    if(grid.getGrid_nodes()[positions[0] + 1][positions[1]] != null && grid.getNode(positions[0] + 1, positions[1]).getPassable()){
                        character.setCurrentNode(grid.getNode(positions[0] + 1, positions[1]), "character");
                    }
                }
                break;

        }
    }

}
