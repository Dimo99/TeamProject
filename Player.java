public class Player {
    static int[] position = new int[2];
    static int points = 0;
    public Player(int[] position,int points){

    }
    public int[] Up(){
        position[0] = position[0] - 1;
        return position;
    }
    public int[] Down(){
        position[0] = position[0] + 1;
        return position;
    }
    public int[] Left(){
        position[1] = position[1] -1;
        return position;
    }
    public int[] Rigght(){
        position[1] = position[1] + 1;
        return position;
    }
    public int Points(int[][] matrix,int[] pos){
        int point = matrix[pos[0]][pos[1]];
        return points+=point;
    }
    public static void PrintPoints(){
        System.out.println(points);
    }
}