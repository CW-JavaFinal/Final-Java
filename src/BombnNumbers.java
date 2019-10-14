import java.util.Random;

public class BombnNumbers {
    public static void main(String[] args)
    {
        //new GridIdea();
        //I need to somehow connect the gridlayout to the grid MD array
        //need GameOption values to set MD array
        int rows = 0;
        int col = 0;
        int size;
        boolean bomb = false;

        int [][] grid = new int[rows][col];
        Random randNum = new Random();

        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid.length; ++j) {
                int rand = randNum.nextInt(4) + 1; //The bound must change with difficulty if easy = 4
                //normal = 3 hard = 2

                if (rand == 1) {
                    //  grid[i][j] = image for bomb ;
                    bomb = true;
                }


            }
    }

    //when game is over need to reset
}
