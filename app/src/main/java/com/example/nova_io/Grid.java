package com.example.nova_io;

import java.util.HashMap;

public class Grid {
    private int x_length;
    private int y_length;
    private Node grid_nodes[][] = new Node[y_length][x_length];
    public Grid(int x_length, int v_length){
        this.x_length = x_length;
        this.y_length = v_length;

    }

    public int getV_lenth() {
        return y_length;
    }

    public int getX_length() {
        return x_length;
    }

    public void createNode(Terrain_type t_type){
        /*
        /dp_node_size is a hashmap that represents that generates the x and y coordinates for each node
        /corner top left, top right, bottom left bottom right each hold an x and y coordinate which increments
        /as we loop through the array 1st loop goes through horizontal grid to create the node positions
        /2nd loop goes through the horizontal length of grid
        */
        HashMap<String, Integer[]>  dp_node_size = new HashMap<>();
        //create an array to hold the x and y coordinates
        //adds the corners to the dp_node_size map and puts the array with the starting coordinates for the 1st node
        Integer[] side_cords;
        dp_node_size.put("top_l", new Integer[]{0, 0});
        dp_node_size.put("top_r", new Integer[]{30, 0});
        dp_node_size.put("bottom_l", new Integer[]{0, 30});
        dp_node_size.put("bottom_r", new Integer[]{30, 30});
        //loops through the virtical grid node positions
        for(int i = 0; i <= y_length; i++){
            if(i > 0){
                //retrieves the coordinates array from the map and incriments the virtical position by
                //30 for each new row aside from the 1st one
                side_cords = dp_node_size.get("top_l");
                side_cords[1] = side_cords[1] + 31;
                dp_node_size.put("top_l", side_cords);
                side_cords = dp_node_size.get("top_r");
                side_cords[1] = side_cords[1] + 31;
                dp_node_size.put("top_r", side_cords);
                side_cords = dp_node_size.get("bottom_r");
                side_cords[1] = side_cords[1] + 31;
                dp_node_size.put("bottom", side_cords);
                side_cords = dp_node_size.get("bottom_l");
                side_cords[1] = side_cords[1] + 31;
                dp_node_size.put("bottom_l", side_cords);
            }
            for(int n = 0; n < x_length; n++){
                //loops through the horizontal grid rows and increments the horizontal cordinates by 30
                if(n > 0){
                    side_cords = dp_node_size.get("top_l");
                    side_cords[1] = side_cords[0] + 31;
                    dp_node_size.put("top_l", side_cords);
                    side_cords = dp_node_size.get("top_r");
                    side_cords[0] = side_cords[0] + 31;
                    dp_node_size.put("top_r", side_cords);
                    side_cords = dp_node_size.get("bottom_r");
                    side_cords[0] = side_cords[0] + 31;
                    dp_node_size.put("bottom_r", side_cords);
                    side_cords = dp_node_size.get("bottom_l");
                    side_cords[1] = side_cords[0] + 31;
                    dp_node_size.put("bottom_l", side_cords);
                }
                //creates a new node for each grid position of type floor
                //and adds it into the grid array
                grid_nodes[i][n] = new Node(n, i, "floor", dp_node_size);
            }

        }

    }

    public Node[][] getGrid_nodes() {
        return grid_nodes;
    }
    public Node getNode(int x_pos, int y_pos){
        return grid_nodes[y_pos][x_pos];
    }
}
