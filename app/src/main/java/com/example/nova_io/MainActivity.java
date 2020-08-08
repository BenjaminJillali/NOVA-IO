package com.example.nova_io;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Grid base_terrain = new Grid(30, 30, "floor");
        int[] position = {6, 4};
        Character bob = new Character("Hobonaut", "yellow", "character", base_terrain.getNode(6, 4), position, 1, 1, 3);
        Integer[] newNode = base_terrain.getNode(6, 4).getCenter_coords();
        bob.placeObject(base_terrain, bob.getType());*/
    }

}
