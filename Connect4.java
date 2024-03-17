import java.util.Scanner;

public class Connect4 {

	public static char[][] board = new char[6][7];
	
	public static int player1Move() {
		///TODO: Examine the board and return the column where you want to drop your next token
		
		return (int)(Math.random()*7);
	}
	
	public static int player2Move() {
		///TODO: Examine the board and return the column where you want to drop your next token
		
		return (int)(Math.random()*7);
	}
	
	
	public static void showBoard(){
		
		System.out.println("|0|1|2|3|4|5|6|");
		System.out.println("===============");
		
		for(int x = 0; x < 6; x++) {
			for(int y = 0; y < 7; y++)
				System.out.print("|" + board[x][y]);			
			System.out.println("|");
		}
		System.out.println("===============");
	}
	
	public static boolean makeMove(char ch, int column)
	{
		if(column >= 0 && column <= 6 && board[0][column] == ' ') {
			int depth = 0;
			while(depth < 6 && board[depth][column] == ' ')
				depth++;
			board[depth-1][column] = ch;
			return true;
		}
		return false;
	}
	
	public static boolean detectWin(){
		
		for(int x = 0; x < 6; x++)
			for(int y = 0; y < 7; y++)
				if(board[x][y] != ' ')
				{
					char letter = board[x][y];
					//checking up
					//if(x >= 3 && board[x-1][y] == letter && board[x-2][y] == letter && board[x-3][y] == letter)
						//return true;
					//checking vertical
					if(x <= 2 && board[x+1][y] == letter && board[x+2][y] == letter && board[x+3][y] == letter)
						return true;
					//checking horizontal
					if(y <= 3 && board[x][y+1] == letter && board[x][y+2] == letter && board[x][y+3] == letter)
						return true;
					//checking left to right down diagonal
					if(y <= 3 && x <=2 && board[x+1][y+1] == letter && board[x+2][y+2] == letter && board[x+3][y+3] == letter)
						return true;
					//checking right to left down diagonal
					if(y >= 3 && x <=2 && board[x+1][y-1] == letter && board[x+2][y-2] == letter && board[x+3][y-3] == letter)
						return true;
				}

		return false;
	}
	
	public static void main(String[] args) {
		
		int spot = 0;
		
		for(int x = 0; x < 6; x++)
			for(int y = 0; y < 7; y++)
				board[x][y] = ' ';
		
		while(!detectWin()) {
			showBoard();
			do
			{
				System.out.println("Red to move: ");
				spot = player1Move();
			}while(makeMove('R',spot) == false);
			
			if(detectWin())
				System.out.println("Red Wins!");
			else
			{
				showBoard();
				do
				{
					System.out.println("Yellow to move: ");
					spot = player2Move();
				}while( makeMove('Y',spot) == false);
				
				if(detectWin())
					System.out.println("Yellow Wins!");
			}
			
		}
		showBoard();
		
		
		
		
		

	}

}
