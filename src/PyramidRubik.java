import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//PYRAMID LAYOUT
//           0
//      1   2   3
//  4   5   6   7   8
// NOTES: must always have 9 tiles per face or else automatically invalid rubik
//STEPS: check if have 9 tiles --> create hashmap for colors and their respective counts --> check if all colors have EXACTLY 9 ---> if not return false if passed all tests return true for valid rubik

//CONSTRUCTORS: Didn't use Faces[4] as it would initialize the values to NULL until they are specified, even when specified all Rubiks will be created identical. Thus, manually passing new Face(Color.X) provides more configurations
//Still need default constructor -->adjust to have no parameters





enum Color {Red, Green, Blue, Yellow}

//Class representing a face of the pyramid Rubik
class Face {

    private Color[] tiles;

    //Default Constructor: makes a face with 9 tiles of the same color
    public Face (Color color) {
        tiles = new Color[9];
        Arrays.fill(tiles, color);


    }

    //Returns the arrays of tiles for a specific face
    public Color[] getTiles(){
        return tiles;
    }

    //Updates the color of a specific tile in a face
    public void setTile (int index, Color color){
        if (index >= 0 && index < tiles.length)
        {
            tiles[index] = color;
        }
    }

}

//CLASS REPRESENTING THE ENTIRE RUBIK
public class PyramidRubik {
    private Face[] faces;

    //Default constructor: Initializes the pyramid Rubik
    public PyramidRubik()
    {
        this.faces = new Face[4];
        InitializeFaces();

        // Print each face before modifying edges
        //System.out.println("\n Faces BEFORE initializing edges:");
        //printFaces();

        InitializeEdges();  // This is the problematic method

        // Print each face after modifying edges
        //System.out.println("\n Faces AFTER initializing edges:");
        //printFaces();

    }

    //Returns the array of faces
    public Face[] getFaces()
    {
        return faces;
    }

    //Assigns each face a unique color from ENUM
    private void InitializeFaces() {
        Color[] colors = Color.values();
        for(int i = 0; i < faces.length; i++)
        {
            faces[i] = new Face(colors[i]);
        }
    }

    //Ensures the adjacent faces share common edge tiles
    public void InitializeEdges()
    {
        // Define shared edges between specific faces
        // Set shared edges to be the same color

        // Face 0 Red shares edges with others
        faces[0].setTile(5, Color.Green);   // Top left edge tile of face 1
        faces[0].setTile(7, Color.Blue);    // Top left edge tile of face 2
        faces[0].setTile(3, Color.Yellow);  // Top left edge tile of face 3

        // Face 1 Green shares edges
        faces[1].setTile(3, Color.Red);     // Edge with face 0
        faces[1].setTile(7, Color.Blue);    // Edge with face 2
        faces[1].setTile(5, Color.Yellow);  // Edge with face 3

        // Face 2 Blue shares edges
        faces[2].setTile(3, Color.Red);     // Edge with face 0
        faces[2].setTile(1, Color.Green);   // Edge with face 1
        faces[2].setTile(7, Color.Yellow);  // Edge with face 3

        // Face 3 Yellow shares edges
        faces[3].setTile(7, Color.Red);     // Edge with face 0
        faces[3].setTile(1, Color.Green);   // Edge with face 1
        faces[3].setTile(5, Color.Blue);    // Edge with face 2








//        ORIGINAL IMPLEMENTATION
//        int[][] adjacentFaces = {
//                {0,1},
//                {0,2},
//                {0,3},
//                {1,2},
//                {1,3},
//                {2,3}
//        };
//        int[][] edgeIndices = {
//                {5,3},
//                {7,1},
//                {3,5},
//                {1,7},
//                {7,1},
//                {5,3}
//        };
//        for (int i = 0; i < adjacentFaces.length; i++)
//        {
//            int face1 = adjacentFaces[i][0];
//            int face2 = adjacentFaces[i][1];
//            int tile1 = edgeIndices[i][0];
//            int tile2 = edgeIndices[i][1];
//
//            //Get color from face1 and assign it to face2 at the shared edge
//            Color sharedColor = faces[face1].getTiles()[tile1];
//            faces[face2].setTile(tile2, sharedColor);
//        }


    }

    //Check whether the pyramid is correctly formed
    public boolean validateCube(){


        //First checks if there are exactly 9 tiles per face
        for (Face faces: faces )
        {
            if(faces.getTiles().length != 9)
                return false;                               //return false immediately if not
        }

        //Initialize hashmap where each key would be the colors, the values are set to 0
        Map<Color, Integer> colorCount = new HashMap<>();
        for(Color color: Color.values()){
            colorCount.put(color, 0);
        }

        //iterate through the faces, then iterate through the hashmap and update each color with the number of times it appears
        for(Face face: faces){
            for(Color tile : face.getTiles()){
                colorCount.put(tile, colorCount.get(tile) + 1);
            }
        }




        //if the count for any color does not equal 9, which would be invalid cube, return false immediately
        for (int count: colorCount.values())
        {
            if (count != 9)
            {
                return false;
            }
        }

        //IF ALL OTHER TESTS PASSED, THE CUBE IS VALID
        return true;

    }

    //Printing method used to debugging
    private void printFaces() {
        for (int i = 0; i < faces.length; i++) {
            System.out.print("Face " + i + ": ");
            for (Color tile : faces[i].getTiles()) {
                System.out.print(tile + " ");
            }
            System.out.println(); // New line for each face
        }
    }


}
