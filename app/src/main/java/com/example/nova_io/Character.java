package com.example.nova_io;

public class Character extends Movable_Object {
    int fuel_lvl;
    String[] accessible_terrain = {"floor"};
    public Character(String name, String img_Path, String type, Node currentNode, int[] node_pos, int x_length, int y_length,
                    int fuel_lvl){
        super(name, img_Path, type, currentNode, node_pos, y_length, x_length);
        this.fuel_lvl = fuel_lvl;
    }
    public boolean checkTerrain_type(String new_terrain){
        for(String n : accessible_terrain){
            if(new_terrain == n)
                return true;
        }
        return false;
    }
}
