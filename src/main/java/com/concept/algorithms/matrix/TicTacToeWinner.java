package com.concept.algorithms.matrix;

/**
 * Find out if the given board is valid, i.e., is it possible to reach this board position after 
 * some moves or not
 * 
 * To find the validity of an input grid, we can think of the conditions when an input grid is invalid. Let no. of “X”s be countX and no. of “O”s be countO. Since we know that the game starts with X, a given grid of Tic-Tac-Toe game would be definitely invalid if following two conditions meet
 * 
 * a) countX != countO AND
 * b) countX != countO + 1 (Since “X” is always the first move, second condition is also required.)
 * c) If input grid shows that both the players are in winning situation, it’s an invalid position.
 * d) If input grid shows that the player with O has put a straight-line (i.e. is in win condition) and countX != countO, it’s an invalid position. The reason is that O plays his move only after X plays his move. Since X has started the game, O would win when both X and O has played equal no. of moves.
 * e) If input grid shows that X is in winning condition than xCount must be one greater that oCount.
 *
 * 1)  countX == countO or countX == countO + 1
 * 2)  If O is in win condition then check 
 *      a)     If X also wins, not valid
 *      b)     If xbox != obox , not valid
 * 3)  If X is in win condition then check if xCount is
 *     one more than oCount or not  
 */
public class TicTacToeWinner {
	
	// This matrix is used to find indexes to check all
	// possible wining triplets in board[0..8]
	private static int win[][] = {{0, 1, 2}, // Check first row.
	                {3, 4, 5}, // Check second Row
	                {6, 7, 8}, // Check third Row
	                {0, 3, 6}, // Check first column
	                {1, 4, 7}, // Check second Column
	                {2, 5, 8}, // Check third Column
	                {0, 4, 8}, // Check first Diagonal
	                {2, 4, 6}}; // Check second Diagonal

	public static void main(String[] args) {
		char board[] = {'X', 'X', 'O',
                'O', 'O', 'X',
                'X', 'O', 'X'};
		System.out.println(isValid(board)?  "Given board is valid":
                 "Given board is not valid");

	}
	
	// Returns true if character 'c' wins. c can be either
	// 'X' or 'O'
	private static boolean isCWin(char[] board, char c) {
	    // Check all possible winning combinations
	    for (int i=0; i<8; i++)
	        if (board[win[i][0]] == c &&
	            board[win[i][1]] == c &&
	            board[win[i][2]] == c )
	            return true;
	    return false;
	}

	private static boolean isValid(char[] board) {
		
		// Count number of 'X' and 'O' in the given board
	    int xCount=0, oCount=0;
	    for (int i=0; i<9; i++) {
	       if (board[i]=='X') xCount++;
	       if (board[i]=='O') oCount++;
	    }
	    
	    // Board can be valid only if either xCount and oCount
	    // is same or xount is one more than oCount
	    if (xCount==oCount || xCount==oCount+1) {
	        // Check if 'O' is winner
	        if (isCWin(board, 'O')) {
	            // Check if 'X' is also winner, then
	            // return false
	            if (isCWin(board, 'X'))
	                 return false;
	 
	            // Else return true xCount and yCount are same
	            return (xCount == oCount);
	        }
	        
	        // If 'X' wins, then count of X must be greater
	        if (isCWin(board, 'X') && xCount != oCount + 1)
	        return false;  
	        
	        // If 'O' is not winner, then return true
	        return true;
	    }
	    return false;
	}

}
