package com.example.nova_io;
import android.util.Log;

import java.util.HashMap;

public class Node {
    private int x_position;
    private int y_position;
    private boolean passable = false;
    private String type;
    public Node(int x_position, int y_position, Terrain_type terrain, String type){
        this.x_position = x_position;
        this.y_position = y_position;
        setPassable(terrain, type);
        this.type = type;

    }
    public void setPassable(Terrain_type t_list, String t_type){
        try{
            this.passable = (boolean) t_list.getNode_type_list().get(t_type);
        }catch (NullPointerException error){
            Log.e("Terrain type error: ", error.getMessage());
        }
    }

    public void setX_position(int x_position) {
        this.x_position = x_position;
    }

    public void setY_position(int y_position) {
        this.y_position = y_position;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getX_position() {
        return x_position;
    }

    public int getY_position() {
        return y_position;
    }

    public String getType() {
        return type;
    }
    public boolean getPassable(){
        return passable;
    }
}
