package com.example.nova_io;
import android.util.Log;

import java.util.HashMap;

public class Node {
    private int x_position;
    private int y_position;
    private boolean passable = false;
    private String type;
    private HashMap <String, Integer[]> node_dimensions;
    private Terrain_type terrains = new Terrain_type();
    private Integer[] center_coords;
    public Node(int x_position, int y_position, String type, HashMap node_dimens){
        this.x_position = x_position;
        this.y_position = y_position;
        setPassable(type);
        this.type = type;
        this.node_dimensions = node_dimens;
        this.center_coords = node_center_dimens();

    }

    public Integer[] node_center_dimens(){
        Integer[] coords = new Integer[2];
        Integer[] coords_side;
        coords_side = node_dimensions.get("top_l");
        coords[0] = coords_side[0];
        coords[1] = coords_side[1];
        coords_side = node_dimensions.get("top_r");
        coords[0] = coords[0] + coords_side[0] / 2;
        coords_side = node_dimensions.get("bottom_l");
        coords[1] = coords[1] + coords_side[1] / 2;
        return coords;
    }

    public Integer[] getCenter_coords() {
        return center_coords;
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
    public void setPassable(String t_type){
        try{
            this.passable = (boolean) terrains.getNode_type_list().get(t_type);
        }catch (NullPointerException error){
            Log.e("Terrain type error: ", error.getMessage());
        }
    }

    public Terrain_type getTerrains() {
        return terrains;
    }

    public HashMap<String, Integer[]> getNode_dimensions() {
        return node_dimensions;
    }
}
