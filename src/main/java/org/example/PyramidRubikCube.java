package org.example;
import java.util.Arrays;

enum Color {Red, Green, Blue, Yellow}

class Face{
    private Color[] tiles;

    public Face(Color color){
        tiles = new Color[9];
        Arrays.fill(tiles, color);
    }

    public Color[] getTiles(){
        return tiles;
    }
}

public class PyramidRubikCube {
    private Face[] faces;

    public PyramidRubikCube(){
        //A pyramid rubik cube has 4 faces
        faces = new Face[4];
        initializeFaces();
        initializeEdges();
    }

    public Face[] getFaces(){
        return faces;
    }

    private void initializeFaces(){
        Color[] colors = {Color.Red, Color.Green, Color.Blue, Color.Yellow};

        for(int i = 0; i < faces.length; i++){
            faces[i] = new Face(colors[i]);
        }
    }

    private void initializeEdges() {


    }


    public boolean validateCube(){
        //created a counter to count each color
        int redCount = 0, greenCount = 0, blueCount = 0, yellowCount = 0;

        //increase counter of specific color as it goes through all the faces
        for(Face face : faces) {
            for(Color tile : face.getTiles()) {
                switch(tile){
                    case Red :
                        redCount++;
                        break;
                        case Green :
                            greenCount++;
                            break;
                            case Blue :
                                blueCount++;
                                break;
                                case Yellow :
                                    yellowCount++;
                                    break;
                }
            }
        }

        return redCount == 9 && greenCount == 9 && blueCount == 9 && yellowCount == 9;
    }

}
