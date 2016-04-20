import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Questions {
    public static void FillTheMatrix(int[][] matrix){
        Random rndm = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = rndm.nextInt(5);
            }
        }
    }
    public static int IsFlagged(int n){
        n=5;
        return n;
    }
    public static void runQuestionGame() {
        Scanner console = new Scanner(System.in);
        HashMap<String,String> questions = new HashMap<>();
        questions.put("Who has won the Champions League in 2015?\na. Barcelona\nb.Chelsea\nc.Liverpool\nd.Real Madrid","a");
        questions.put("How high is mount Musala?\na. 2916\nb.2939\nc.8848\nd.2925","d");
        questions.put("Which is the capital of Slovakia?\na. Lublana\nb.]Budapeshta\nc.Praga\nd.Bratislava","d");
        questions.put("Bill gates was qualified by Forbes as the richest man in the world 2015.How much is his net worth?\na. 79 billions\nb.73 billions\nc.24 millions\nd.82 billions","a");
        questions.put("What kind of animmal is the dolphin?\na. Mammal\nb.Reptail\nc.Fish\nd.amphibian","a");
        int[][] matrix = new int[5][5];
        FillTheMatrix(matrix);
        System.out.println("Player 1 Turn :) ");
        System.out.println("Choose Your Starting position withing the matrix[0-4][0-4]: ");
        System.out.print("Input the numbers separated with a space: ");
        String[] input = console.nextLine().split(" ");
        int[] position = new int[2];
        position[0] = Integer.parseInt(input[0]);
        position[1] = Integer.parseInt(input[1]);
        Player playerOne = new Player(position,0);
        playerOne.Points(matrix,position);
        int counter=0;
        while(counter<=5){
            System.out.println("Choose your direction with words[up,down,left,right]: ");
            String move = console.nextLine();
            switch(move){
                case "up":
                    playerOne.Up() ;
                    position[0] =position[0]-1;
                    playerOne.Points(matrix,position);
                    System.out.printf("Your current position : [%d,%d]",position[0]  ,position[1]);
                    int index = 1;
                    for (String s : questions.keySet()) {
                        if(index == matrix[position[0]][position[1]])
                        {
                            System.out.println(s);
                            String ch = console.next();
                            if(ch.equals(questions.get(s)))
                            {
                                System.out.println("Congratulations!");
                                counter++;
                            }
                            else
                            {
                                System.out.println("Wrong answer");
                            }
                            break;
                        }
                        index++;
                    }
                    break;
                case "down":
                    playerOne.Down();
                    position[0] = position[0]+1;
                    playerOne.Points(matrix,position);
                    System.out.printf("Your current position : [%d,%d]",position[0]  ,position[1]);
                    System.out.println();
                    index = 0;
                    for (String s : questions.keySet()) {
                        if(index == matrix[position[0]][position[1]])
                        {
                            System.out.println(s);
                            String ch = console.next();
                            if(ch.equals(questions.get(s)))
                            {
                                System.out.println("Congratulations!");
                                counter++;
                            }
                            else
                            {
                                System.out.println("Wrong answer");
                            }
                            break;
                        }
                        index++;
                    }
                    break;
                case "left":
                    playerOne.Left();
                    position[1] = position[1] -1;
                    playerOne.Points(matrix,position);
                    System.out.printf("Your current position : [%d,%d]",position[0]  ,position[1]);
                    System.out.println();
                    index = 0;
                    for (String s : questions.keySet()) {
                        if(index == matrix[position[0]][position[1]])
                        {
                            System.out.println(s);
                            String ch = console.next();
                            if(ch.equals(questions.get(s)))
                            {
                                System.out.println("Congratulations!");
                                counter++;
                            }
                            else
                            {
                                System.out.println("Wrong answer");
                            }
                            break;
                        }
                        index++;
                    }
                    break;
                case "right":
                    playerOne.Rigght();
                    position[1] = position[1] + 1;
                    playerOne.Points(matrix,position);
                    System.out.printf("Your current position : [%d,%d]",position[0]  ,position[1]);
                    System.out.println();
                    index = 0;
                    for (String s : questions.keySet()) {
                        if(index == matrix[position[0]][position[1]])
                        {
                            System.out.println(s);
                            String ch = console.next();
                            if(ch.equals(questions.get(s)))
                            {
                                System.out.println("Congratulations!");
                                counter++;
                            }
                            else
                            {
                                System.out.println("Wrong answer");
                            }
                            break;
                        }
                        index++;
                    }
                    break;

            }
            console.nextLine();
        }
        System.out.println();
        System.out.println("Player position : ");
        playerOne.PrintPoints();
    }
}
