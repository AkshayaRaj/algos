import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotPrincess {
static void nextMove(int n, int r, int c, String [] grid){
   for(int i=0;i<grid.length;i++){
	for(int j=0;j<n;j++){
		if(grid[i].charAt(j)=='p')
			System.out.println(i+","+j);
		
	}
    }
   	//System.out.println(grid[i]);
  }

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];


        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

    nextMove(n,r,c,grid);

    }
}



