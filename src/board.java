
public class board 
{
	
	public static char[][] gameBoard = {{'_','_','_'}, {'_','_','_'}, {'_','_','_'}};
	static char player = 'x', cpu = 'o';
	
	public static void UpdateBoardWithCPU(int cpuMove)
	{
		switch(cpuMove)
		{
			case 1:
				gameBoard[0][0] = 'o';
				break;
			case 2:
				gameBoard[0][1] = 'o';
				break;
			case 3:
				gameBoard[0][2] = 'o';
				break;
			case 4:
				gameBoard[1][0] = 'o';
				break;
			case 5:
				gameBoard[1][1] = 'o';
				break;
			case 6:
				gameBoard[1][2] = 'o';
				break;
			case 7:
				gameBoard[2][0] = 'o';
				break;
			case 8:
				gameBoard[2][1] = 'o';
				break;
			case 9:
				gameBoard[2][2] = 'o';
				break;
		}
	}
	
	public static void UpdateBoardWithPlayer(int pMove)
	{
		switch(pMove)
		{
			case 1:
				gameBoard[0][0] = 'x';
				break;
			case 2:
				gameBoard[0][1] = 'x';
				break;
			case 3:
				gameBoard[0][2] = 'x';
				break;
			case 4:
				gameBoard[1][0] = 'x';
				break;
			case 5:
				gameBoard[1][1] = 'x';
				break;
			case 6:
				gameBoard[1][2] = 'x';
				break;
			case 7:
				gameBoard[2][0] = 'x';
				break;
			case 8:
				gameBoard[2][1] = 'x';
				break;
			case 9:
				gameBoard[2][2] = 'x';
				break;
		}
	}
	
	static Boolean isMovesLeft(char board[][])
	{
	    for (int i = 0; i < 3; i++)
	        for (int j = 0; j < 3; j++)
	            if (board[i][j] == '_')
	                return true;
	    return false;
	}
	
	static int evaluate(char b[][])
	{
	    // Checking for Rows for X or O victory.
	    for (int row = 0; row < 3; row++)
	    {
	        if (b[row][0] == b[row][1] &&
	            b[row][1] == b[row][2])
	        {
	            if (b[row][0] == cpu)
	                return +10;
	            else if (b[row][0] == player)
	                return -10;
	        }
	    }
	 
	    // Checking for Columns for X or O victory.
	    for (int col = 0; col < 3; col++)
	    {
	        if (b[0][col] == b[1][col] &&
	            b[1][col] == b[2][col])
	        {
	            if (b[0][col] == cpu)
	                return +10;
	 
	            else if (b[0][col] == player)
	                return -10;
	        }
	    }
	 
	    // Checking for Diagonals for X or O victory.
	    if (b[0][0] == b[1][1] && b[1][1] == b[2][2])
	    {
	        if (b[0][0] == cpu)
	            return +10;
	        else if (b[0][0] == player)
	            return -10;
	    }
	 
	    if (b[0][2] == b[1][1] && b[1][1] == b[2][0])
	    {
	        if (b[0][2] == cpu)
	            return +10;
	        else if (b[0][2] == player)
	            return -10;
	    }
	 
	    // Else if none of them have won then return 0
	    return 0;
	}
	
	static int minimax(char board[][], int depth, Boolean isMax)
	{
		int score = evaluate(board);
		
		// If Maximizer has won the game
		// return his/her evaluated score
		if (score == 10)
		return score;
		
		// If Minimizer has won the game
		// return his/her evaluated score
		if (score == -10)
		return score;
		
		// If there are no more moves and
		// no winner then it is a tie
		if (isMovesLeft(board) == false)
		return 0;
		
		// If this maximizer's move
		if (isMax)
		{
		int best = -1000;
		
		// Traverse all cells
		for (int i = 0; i < 3; i++)
		{
		    for (int j = 0; j < 3; j++)
		    {
		        // Check if cell is empty
		        if (board[i][j]=='_')
		        {
		            // Make the move
		            board[i][j] = cpu;
		
		            // Call minimax recursively and choose
		            // the maximum value
		            best = Math.max(best, minimax(board, depth + 1, !isMax));
		
		            // Undo the move
		            board[i][j] = '_';
		        }
		    }
		}
		return best;
		}
		
		// If this minimizer's move
		else
		{
			int best = 1000;
			
			// Traverse all cells
			for (int i = 0; i < 3; i++)
			{
			    for (int j = 0; j < 3; j++)
			    {
			        // Check if cell is empty
			        if (board[i][j] == '_')
			        {
			            // Make the move
			            board[i][j] = player;
			
			            // Call minimax recursively and choose
			            // the minimum value
			            best = Math.min(best, minimax(board, depth + 1, !isMax));
			
			            // Undo the move
			            board[i][j] = '_';
			        }
			    }
			}
			return best;
		}
	}
	
	static int findBestMove(char board[][])
	{
	    int bestVal = -1000;
	    Move bestMove = new Move();
	    bestMove.row = -1;
	    bestMove.col = -1;
	 
	    // Traverse all cells, evaluate minimax function
	    // for all empty cells. And return the cell
	    // with optimal value.
	    for (int i = 0; i < 3; i++)
	    {
	        for (int j = 0; j < 3; j++)
	        {
	            // Check if cell is empty
	            if (board[i][j] == '_')
	            {
	                // Make the move
	                board[i][j] = cpu;
	 
	                // compute evaluation function for this
	                // move.
	                int moveVal = minimax(board, 0, false);
	 
	                // Undo the move
	                board[i][j] = '_';
	 
	                // If the value of the current move is
	                // more than the best value, then update
	                // best/
	                if (moveVal > bestVal)
	                {
	                    bestMove.row = i;
	                    bestMove.col = j;
	                    bestVal = moveVal;
	                }
	            }
	        }
	    }
	 
//	    System.out.printf("The value of the best Move " +
//	                             "is : %d\n\n", bestVal);
	    
	    if(bestMove.row == 0 && bestMove.col == 0)
	    {
	    	return 1;
	    }
	    else if(bestMove.row == 0 && bestMove.col == 1)
	    {
	    	return 2;
	    }
	    else if(bestMove.row == 0 && bestMove.col == 2)
	    {
	    	return 3;
	    }
	    else if(bestMove.row == 1 && bestMove.col == 0)
	    {
	    	return 4;
	    }
	    else if(bestMove.row == 1 && bestMove.col == 1)
	    {
	    	return 5;
	    }
	    else if(bestMove.row == 1 && bestMove.col == 2)
	    {
	    	return 6;
	    }
	    else if(bestMove.row == 2 && bestMove.col == 0)
	    {
	    	return 7;
	    }
	    else if(bestMove.row == 2 && bestMove.col == 1)
	    {
	    	return 8;
	    }
	    else if(bestMove.row == 2 && bestMove.col == 2)
	    {
	    	return 9;
	    }
	 
	    return 0;
	}
	
}
