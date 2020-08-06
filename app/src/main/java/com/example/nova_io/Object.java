package com.example.nova_io;

import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class Object extends AppCompatActivity{
    public ImageView object_img;
    private String name;
    private String img_Path;
    private String type;
    private Boolean image_exists = false;
    //nd_pos refers to the objects starting node number. y_length and h_length referes to the.
    //height and length of the object for node tiles it occupise ie 2x3.
    private int node_pos[] = new int[2];
    private Node currentNode;
    private int y_length;
    private int x_length;
    public Object(String name, String img_Path, String type, Node currentNode, int[] node_pos, int x_length, int y_length){
        this.object_img = (ImageView) findViewById(R.id.testImage);
        this.name = name;
        this.type = type;
        this.currentNode = currentNode;
        this.node_pos[0] = node_pos[0];
        this.node_pos[1] = node_pos[1];
        this.x_length = x_length;
        this.y_length = y_length;
        if(checkLink(img_Path)){
            this.img_Path = img_Path;
        }else{
            this.img_Path = "";
        }
    }
    public boolean checkLink(String path){
        return path.length() > 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Boolean getImage_exists() {
        return image_exists;
    }

    public String getImg_Path() {
        return img_Path;
    }

    public void setNode_pos(int[] node_pos) {
        this.node_pos[0] = node_pos[0];
        this.node_pos[0] = node_pos[0];
    }

    public int[] getNode_pos() {
        return node_pos;
    }

    public void setH_length(int h_length) {
        this.x_length = h_length;
    }

    public int getH_length() {
        return x_length;
    }

    public void setY_length(int y_length) {
        this.y_length = y_length;
    }

    public int getY_length() {
        return y_length;
    }
    public Node getCurrentNode(){
        return this.currentNode;
    }

    public void setCurrentNode(Node currentNode, String type) {
        currentNode.setType(type);
        int[] positions = {currentNode.getX_position(), currentNode.getY_position()};
        setNode_pos(positions);
        this.currentNode = currentNode;
    }
    public void placeObject(Grid grid, String type){
        boolean placement_possible = true;
        for(int i = node_pos[1]; i < y_length; i++){
            for(int n = node_pos[0]; n < x_length; n++){
                if(grid.getNode(node_pos[0] + n, node_pos[1] + i).getPassable()){
                    placement_possible = true;
                }
            }
        }if(placement_possible){
          //  int img_id = getResources().getIdentifier("test_image", "drawable", "com.example.nova_io");
           // ImageView character_test = (ImageView) findViewById(R.id.testImage);
            this.object_img.setTranslationY(grid.getNode(node_pos[0], node_pos[1]).getCenter_coords()[1]);
            this.object_img.setTranslationX(grid.getNode(node_pos[0], node_pos[1]).getCenter_coords()[0]);
            for(int i = node_pos[1]; i < y_length; i++){
                for(int n = node_pos[0]; n < x_length; n++){
                    setCurrentNode(grid.getNode(n, i), type);
                }
            }
        }
    }
}
