import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Board{
  int [][]board;
  Map<Integer,Code> map;
  ArrayList list=new ArrayList();
   Board(){
    this.board=new int[3][3];
    map=new HashMap<Integer,Code>();
     populateMap();
  }

  void populateMap(){
    map.put(1,new Code(0,0));
    map.put(2,new Code(0,1));
    map.put(3,new Code(0,2));
    map.put(4,new Code(1,0));
    map.put(5,new Code(1,1));
    map.put(6,new Code(1,2));
    map.put(7,new Code(2,0));
    map.put(8, new Code(2, 1));




  }

 int[][]  exchange(int [][]b){
    int [][]x=new int[3][3];
   for(int i=0;i<3;i++) {
     for (int j = 0; j < 3; j++) {
       x[i][j]=b[i][j];
     }
   }

     


   return x;
 }




  void randomize(){

    boolean flag=false;
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){

        if(i==2 && j==2) {
          this. board[i][j]=0;
          flag=true;
        }
        if(flag)
          break;

        board[i][j]=getRandom();


        
      }
    }
  }


  int getHeuristic(int [][]arr){
    int heuristic=0;
    int h=0;

       int j;
      for (int i = 0; i < 3; i++) {
        for ( j = 0; j < 3; j++) {
          if(i==2 && j==2)
            break;

        int element=arr[i][j];
          Code c=(Code)map.get(element);
        //  System.out.println(c.x);
           h=c.diff(i, j);

        }
        if(i==2 && j==2)
          break;
        heuristic+=h;
      }
    return heuristic;
  }
  int getRandom(){
    int random=new Random().nextInt(9);
    if(random==0 || random==9)
      random=1;

  if(list.contains(random))
    return getRandom();

    else{
      list.add(random);
    return random;
  }
  }

  void solve(){
    int k=1;
    for(int i=0;i<3;i++) {
      for (int j = 0; j < 3; j++) {
          board[i][j]=k;
        k++;
      }
    }
    board[2][2]=0;
  }

  void reset(){
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
       this. board[i][j]=9;

      }
    }
  }

  boolean solved(){
    if(this.getHeuristic(this.board)==0)
            return true;
    else
      return false;
 }

  void printBoard(){

    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        System.out.print(board[i][j]+"\t");

      }
      System.out.println();
    }
  }




  void move(){
    int k=0,i,j;
    for( i=0;i<3;i++) {
      for ( j = 0; j < 3; j++) {
        if(board[i][j]==0)
          break;
      }
      if(board[i][j]==0)
        break;
    }




  }

}



public class Puzzle{
  public static void main(String args[]){
    Board puzzle=new Board();
    puzzle.reset();
    puzzle.randomize();
    puzzle.printBoard();
    System.out.println(puzzle.getHeuristic(puzzle.board));
    puzzle.solve();
    puzzle.printBoard();
    System.out.println(puzzle.getHeuristic(puzzle.board));
  }
}

class Code{
  public int x;
  public int y;
  Code(int x,int y){
    this.x=x;
    this.y=y;
  }
  int diff(int x ,int y){
    return Math.abs(x - this.x) +Math.abs(y - this.y);
  }
}