package com.example.nova_io;
import android.util.Log;

import java.util.HashMap;

public class Node {
    private int x_position;
    private int y_position;
    private boolean passable = false;
    private String type;
    private HashMap <String, Integer> node_dimensions;
    public Node(int x_position, int y_position, Terrain_type terrain, String type, HashMap node_dimens){
        this.x_position = x_position;
        this.y_position = y_position;
        setPassable(terrain, type);
        this.type = type;
        this.node_dimensions = node_dimens;

    }
    public void setPassable(Terrain_type t_list, String t_type){
        try{
            this.passable = (boolean) t_list.getNode_type_list().get(t_type);
        }catch (NullPointerException error){
            Log.e("Terrain type error: ", error.getMessage());
        }
    }
    public int node_center_width(){
        return node_dimensions.get("left") + 15;
    }
    public int node_center_height(){
        return node_dimensions.get("top") + 15;
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
