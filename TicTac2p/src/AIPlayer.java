
class GameMain{
	public static int ROWS=3;
	public static int COLS=3;
};

public abstract class AIPlayer {
	protected int ROWS=GameMain.ROWS;
	protected int COLS=GameMain.COLS;
	
	protected Cell[][] cells;
	protected Seed mySeed;
	protected Seed oppSeed;
	
	public AIPlayer(Board board){
		cells=board.cells;
	}
	
	abstract int[] move(); // the array returned is a move at position (x,y)
};

class Cell{
	char mark;
}

class Seed{
	char symbol;
}

class Board{
	public Cell [][]cells;
	
	public Board(){
		cells=new Cell[GameMain.ROWS][GameMain.COLS];
		
	}
	void reset(){
		for(int i=0;i<GameMain.ROWS;i++){
			for(int j=0;j<GameMain.COLS;j++){
				cells[i][j].mark='x';
			}
		}
		
	}
}