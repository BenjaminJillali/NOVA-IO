package com.example.nova_io;

public class Movable_Object extends Object {
    Movement move;
    public Movable_Object(String name, String img_Path, String type, Node currentNode, int[] node_pos, int x_length, int y_length){
        super(name, img_Path, type, currentNode, node_pos, y_length, x_length);
        this.move = new Movement(this);
    }
}
