package com.example.nova_io;

import java.io.File;

public class Object {
    private String name;
    private File img_Path;
    private String type;
    private Boolean image_exists = false;
    //nd_pos refers to the objects starting node number. y_length and h_length referes to the.
    //height and length of the object for node tiles it occupise ie 2x3.
    private int node_pos[] = new int[2];
    private int y_length;
    private int h_length;
    public Object(String name, String img_Path, String type, int[] node_pos, int v_length, int h_length){
        this.name = name;
        this.type = type;
        this.node_pos[0] = node_pos[0];
        this.node_pos[1] = node_pos[1];

        checkLink(img_Path);
        if(image_exists){
            this.img_Path = new File(img_Path);
        }else{
            this.img_Path = new File("");
        }
    }
    public void checkLink(String path){
        if(path.length() > 0){
            File image_path = new File(path);
            if(image_path.exists()){
                this.image_exists = true;
            }
        }else {
            this.image_exists = false;
        }
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

    public File getImg_Path() {
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
        this.h_length = h_length;
    }

    public int getH_length() {
        return h_length;
    }

    public void setY_length(int y_length) {
        this.y_length = y_length;
    }

    public int getY_length() {
        return y_length;
    }
}
