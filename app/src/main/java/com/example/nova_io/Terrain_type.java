package com.example.nova_io;

import java.util.HashMap;

public class Terrain_type {
    final private HashMap<String, Boolean> node_type_list = new HashMap<>();
    public Terrain_type(){
        create_type_list();
    }
    private void create_type_list(){
        this.node_type_list.put("floor", true);
        this.node_type_list.put("character", false);
   }

    public HashMap getNode_type_list() {
        return node_type_list;
    }
}
