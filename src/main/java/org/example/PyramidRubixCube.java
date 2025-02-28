package org.example;
import java.util.Arrays;

enum Color {Red, Green, Blue, Yellow}

class Face{
    private Color[] tiles;

    public Face(Color[] color){
        tiles = new Color[9];
        Arrays.fill(tiles, color);
    }

    public Color[] getTiles(){
        return tiles;
    }
}

public class PyramidRubixCube {
    private Face[] faces;

    public PyramidRubixCube(){
        this.faces = faces;
        initializeFaces();
        initializeEdges();
    }

    public Face[] getFaces(){
        return faces;
    }

    private void initializeFaces(){

    }

    private void initializeEdges(){

    }


    public boolean validateCube(){


        //temporary return
        return true;
    }

}
