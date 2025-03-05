import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Face[] faces = {
                new Face(Color.Red),
                new Face(Color.Green),
                new Face(Color.Blue),
                new Face(Color.Yellow)
        };

        // Create PyramidRubik with faces
        //PyramidRubik rubik = new PyramidRubik();



        PyramidRubik rubik = new PyramidRubik();
        System.out.println("Validating the Pyramid Rubik:");
        if (rubik.validateCube()) {
            System.out.println("The Pyramid Rubik is valid!");
        } else {
            System.out.println("The Pyramid Rubik is invalid!");
        }


    }
}