package org.example;

import java.util.Arrays;

enum Color {Red, Green, Blue, Yellow}

class Face{
    private Color[] tiles;

    public Face(Color color){
        tiles = new Color[9];
        Arrays.fill(tiles, color);
    }

    //this will get the tiles of a Face
    public Color[] getTiles(){
        return tiles;
    }

    //This will set the tiles on a face if we want to change it
    public void setTiles(int index, Color color){
        if(index >= 0 && index < tiles.length){
            tiles[index] = color;
        } else {
            throw new IndexOutOfBoundsException("Tile index out of bounds. ");
        }
    }

}

public class PyramidRubiksCube {
    private Face[] faces;

    public PyramidRubiksCube(){
        //A pyramid rubik cube has 4 faces
        faces = new Face[4];
        initializeFaces();
        initializeEdges();
    }

    //return the Face
    public Face[] getFaces(){
        return faces;
    }

    private void initializeFaces(){
        Color[] colors = {Color.Red, Color.Green, Color.Blue, Color.Yellow};

        //assigning each face a color
        for(int i = 0; i < faces.length; i++){
            faces[i] = new Face(colors[i]);
        }
    }

    private void initializeEdges() {
        // Each face has 3 other faces it connects to
        int[][] adjacencyFaces = {
                {1, 2, 3},      //ex. Face 0 (red) is connected to Green (1), Blue (2), and Yellow (3)
                {0, 3, 2},
                {0, 1, 3},
                {0, 2, 1}
        };

         //Each face has 3 edges on tiles 2, 4, and 7
        int[][] edgeIndices = {
                {2, 4, 7},
                {2, 4, 7},
                {2, 4, 7},
                {2, 4, 7}
        };

        for(int i = 0; i < adjacencyFaces.length; i++){         //this loop iterate through all the faces
            for(int j = 0; j < edgeIndices[i].length; j++){     //this loop iterate through all the edges

                //retrieve the specific edge index and adjacent face to get the correct position and color of the face
                int edgeIndex = edgeIndices[i][j];
                int adjacentFace = adjacencyFaces[i][j];

                //get the current color from current face
                Color sharedColor = faces[i].getTiles()[edgeIndex];

                //assign edge to the current face if it has not already been assigned
                if(faces[adjacentFace].getTiles()[edgeIndex] == null){
                    faces[adjacentFace].setTiles(edgeIndex, sharedColor);
                }
            }
        }
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


    public static void main(String[] args) {
        PyramidRubiksCube cube = new PyramidRubiksCube();
        System.out.println(cube.validateCube());
    }
}
