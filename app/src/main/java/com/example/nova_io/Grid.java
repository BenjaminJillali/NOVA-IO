package com.example.nova_io;

import java.util.HashMap;

public class Grid {
    private int x_length;
    private int y_length;
    private Node grid_nodes[][] = new Node[y_length][x_length];
//not looking forward to this class.
    public Grid(int v_length){
        this.y_length = v_length;
    }

    public int getV_lenth() {
        return y_length;
    }

    public void createNode(Terrain_type t_type){
        //dp_position represents the current node center position starting at top left at 15dp, 15dp.
        //it increases by 30 for each node added height and length
        /*
        /dp_node_values represent each of the 4 node dp positions per node starting at the top->right->bottom->left
        /they increase by 30 for each node e.g: 1st row 1st node values(0, 30, 30, 0) 1st row 2nd node
        /values(0, 60, 30, 30) 2nd row 1st node values(30, 30, 60, 0) etc.
        */
        HashMap<String, Integer[]>  dp_node_size = new HashMap<>();
        dp_node_size.put("top", new Integer[]{0, 0});
        dp_node_size.put("right", new Integer[]{30, 0});
        dp_node_size.put("bottom", new Integer[]{30, 30});
        dp_node_size.put("left", new Integer[]{0, 30});
        for(int i = 0; i <= y_length; i++){
            if(i > 0){
                dp_node_size.put("top", dp_node_size.get("top")[0] + 30);
                dp_node_size.put("bottom", dp_node_size.get("bottom") + 30);
            }
            for(int n = 0; n < x_length; n++){
                if(n > 0){
                    dp_node_size.put("right", dp_node_size.get("right") + 30);
                    dp_node_size.put("left", dp_node_size.get("left") + 30);
                }
                grid_nodes[i][n] = new Node(n, i, t_type, "floor", dp_node_size);
            }

        }

    }


}
