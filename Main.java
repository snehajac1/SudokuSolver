//rules: (1) only numbers 1-9 in each 3x3 box
      // (2) only numbers 1-9 (no repeats) in each row and column
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
      Scanner in = null;
      in = new Scanner(System.in);
      //initialize array size to be 9x9 to follow a standard sudoku puzzle
      int  array[][] = new int [9][9]; 
      System.out.println("Welcome to the Sudoku Solver!\n\nEnter in your puzzle from left to right and leave a '0' for the empty spaces.");

      for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
          array[i][j]  = in.nextInt(); //grabs next input 
        }
      }
      for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
          System.out.print(array[i][j] + " ");
          System.out.println();
        }
      }
      //print(array);
  if(solution(array)){
    System.out.println("yay! puzzle solved! :)");
  }
  else{
  System.out.println("oh no! this puzzle cannot be solved! :/");
  }
  print(array);
    }


      private static boolean PresentRow(int [][] array, int num, int row){
        for(int i = 0; i < 9; i++){
        if(array[row][i] == num){
          return true;
        }
        }
      return false;    
      }
      private static boolean PresentCol(int [][] array, int num, int col){
        for(int i = 0; i < 9; i++){
        if(array[i][col] == num){
          return true;
        }
        }
      return false;    
      }
      private static boolean PresentinBox(int [][] array, int num, int row, int col){
      int boxrow = row - row % 3;
      int colbox = col - col % 3;

      for(int i = boxrow; i < boxrow + 3; i++){
        for(int j = colbox; j < colbox + 3; j++){
          if(array[i][j] == num){
            return true;
          }
        }
      }
        return false;
      }
      private static boolean correctPlacement(int [][] array, int num, int row, int col){
          return !PresentRow(array, num, row) && !PresentCol(array, num, col)
            && !PresentinBox(array, num, row, col);
      }
  private static boolean solution(int[][] array) {
    for (int row = 0; row < 9; row++) {
      for (int column = 0; column < 9; column++) {
        if (array[row][column] == 0) {
          for (int numberToTry = 1; numberToTry <= 9; numberToTry++) {
            if (correctPlacement(array, numberToTry, row, column)) {
              array[row][column] = numberToTry;
              
              if (solution(array)) {
                return true;
              }
              else {
                array[row][column] = 0;
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }
  private static void print(int [][] array){
    for (int row = 0; row < 9; row++){
      if(row % 3 == 0 && row != 0){
        System.out.println("-----------");
      }
      for(int col = 0; col < 9; col++){
        if(col % 3 == 0 && col != 0){
          System.out.println("|");
        }
        System.out.print(array[row][col]);
      }
      System.out.println();
    }
  }
      
}