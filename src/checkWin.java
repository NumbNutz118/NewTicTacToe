import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class checkWin 
{	
	
	public static boolean checkPlayerWin()
	{
		int topRow [] = {1, 2, 3};
		int midRow [] = {4, 5, 6};
		int botRow [] = {7, 8, 9};
		
		int leftCol [] = {1, 4, 7};
		int midCol [] = {2, 5, 8};
		int rightCol [] = {3, 6, 9};
		
		int cross1 [] = {1, 5, 9};
		int cross2 [] = {3, 5, 7};
		
		//SETTING PLAYER ROWS
		int[] pTopRow = new int[3];
		for(int i = 0; i < 3; i++)
		{
			pTopRow[i] = action.playerPos[i];
		}
		int[] pMidRow = new int[3];
		for(int i = 3; i < 6; i++)
		{
			pMidRow[i-3] = action.playerPos[i];
		}
		int[] pBotRow = new int[3];
		for(int i = 6; i < 9; i++)
		{
			pBotRow[i-6] = action.playerPos[i];
		}
		
		//ROWS
		if(pTopRow[0] == topRow[0] && pTopRow[1] == topRow[1] && pTopRow[2] == topRow[2])
		{
			return true;
		}
		else if(pMidRow[0] == midRow[0] && pMidRow[1] == midRow[1] && pMidRow[2] == midRow[2])
		{
			return true;
		}
		else if(pBotRow[0] == botRow[0] && pBotRow[1] == botRow[1] && pBotRow[2] == botRow[2])
		{
			return true;
		}
		
		//SETTING PLAYER COLS
		int x = 0;
		int y = 0;
		int z = 0;
		
		int pLeftCol[] = new int[3];
		for(int i = 0; i <= 7; i += 3)
		{
			pLeftCol[x] = action.playerPos[i];
			x++;
		}
		int pMidCol[] = new int[3];
		for(int i = 1; i <= 8; i += 3)
		{
			pMidCol[y] = action.playerPos[i];
			y++;
		}
		int pRightCol[] = new int[3];
		for(int i = 2; i <= 9; i += 3)
		{
			pRightCol[z] = action.playerPos[i];
			z++;
		}
		
		//COLS
		if(pLeftCol[0] == leftCol[0] && pLeftCol[1] == leftCol[1] && pLeftCol[2] == leftCol[2])
		{
			return true;
		}
		else if(pMidCol[0] == midCol[0] && pMidCol[1] == midCol[1] && pMidCol[2] == midCol[2])
		{
			return true;
		}
		else if(pRightCol[0] == rightCol[0] && pRightCol[1] == rightCol[1] && pRightCol[2] == rightCol[2])
		{
			return true;
		}
		
		//SETTING PLAYER DIAGS
		int a = 0;
		int b = 0;
		int pCross1[] = new int[3];
		for(int i = 0; i <= 9; i += 4)
		{
			pCross1[a] = action.playerPos[i];
			a++;
		}
		
		int pCross2[] = new int[3];
		for(int i = 2; i <= 6; i += 2)
		{
			pCross2[b] = action.playerPos[i];
			b++;
		}
		
		//DIAGS
		if(pCross1[0] == cross1[0] && pCross1[1] == cross1[1] && pCross1[2] == cross1[2])
		{
			return true;
		}
		else if(pCross2[0] == cross2[0] && pCross2[1] == cross2[1] && pCross2[2] == cross2[2])
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean checkCpuWin()
	{
		int topRow [] = {1, 2, 3};
		int midRow [] = {4, 5, 6};
		int botRow [] = {7, 8, 9};
		
		int leftCol [] = {1, 4, 7};
		int midCol [] = {2, 5, 8};
		int rightCol [] = {3, 6, 9};
		
		int cross1 [] = {1, 5, 9};
		int cross2 [] = {3, 5, 7};
		
		//SETTING CPU ROWS
		int[] cTopRow = new int[3];
		for(int i = 0; i < 3; i++)
		{
			cTopRow[i] = action.cpuPos[i];
		}
		int[] cMidRow = new int[3];
		for(int i = 3; i < 6; i++)
		{
			cMidRow[i-3] = action.cpuPos[i];
		}
		int[] cBotRow = new int[3];
		for(int i = 6; i < 9; i++)
		{
			cBotRow[i-6] = action.cpuPos[i];
		}
		
		//ROWS
		if(cTopRow[0] == topRow[0] && cTopRow[1] == topRow[1] && cTopRow[2] == topRow[2])
		{
			return true;
		}
		else if(cMidRow[0] == midRow[0] && cMidRow[1] == midRow[1] && cMidRow[2] == midRow[2])
		{
			return true;
		}
		else if(cBotRow[0] == botRow[0] && cBotRow[1] == botRow[1] && cBotRow[2] == botRow[2])
		{
			return true;
		}
		
		//SETTING CPU COLS
		int x = 0;
		int y = 0;
		int z = 0;
		
		int cLeftCol[] = new int[3];
		for(int i = 0; i <= 7; i += 3)
		{
			cLeftCol[x] = action.cpuPos[i];
			x++;
		}
		int cMidCol[] = new int[3];
		for(int i = 1; i <= 8; i += 3)
		{
			cMidCol[y] = action.cpuPos[i];
			y++;
		}
		int cRightCol[] = new int[3];
		for(int i = 2; i <= 9; i += 3)
		{
			cRightCol[z] = action.cpuPos[i];
			z++;
		}
		
		//COLS
		if(cLeftCol[0] == leftCol[0] && cLeftCol[1] == leftCol[1] && cLeftCol[2] == leftCol[2])
		{
			return true;
		}
		else if(cMidCol[0] == midCol[0] && cMidCol[1] == midCol[1] && cMidCol[2] == midCol[2])
		{
			return true;
		}
		else if(cRightCol[0] == rightCol[0] && cRightCol[1] == rightCol[1] && cRightCol[2] == rightCol[2])
		{
			return true;
		}
		
		//SETTING CPU DIAGS
		int a = 0;
		int b = 0;
		int cCross1[] = new int[3];
		for(int i = 0; i <= 9; i += 4)
		{
			cCross1[a] = action.cpuPos[i];
			a++;
		}
		int cCross2[] = new int[3];
		for(int i = 2; i <= 6; i += 2)
		{
			cCross2[b] = action.cpuPos[i];
			b++;
		}
		
		//DIAGS
		if(cCross1[0] == cross1[0] && cCross1[1] == cross1[1] && cCross1[2] == cross1[2])
		{
			return true;
		}
		else if(cCross2[0] == cross2[0] && cCross2[1] == cross2[1] && cCross2[2] == cross2[2])
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean CheckWin()
	{
		JFrame result = new JFrame();
		JPanel finale = new JPanel();
		JLabel label = new JLabel();
		
		label.setFont(new Font("Arial", Font.BOLD, 30));
		label.setForeground(Color.black);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		finale = new JPanel();
		finale.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		finale.setLayout(new GridLayout(0, 1));
		
		result.setSize(500, 500);
		result.add(finale, BorderLayout.CENTER);
		result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		result.setTitle("TicTacToe");
		
		if(checkPlayerWin())
		{
			label.setText("Congratulations you won!");
			finale.add(label);
			result.setVisible(true);
			return true;
		}
		else if(checkCpuWin())
		{
			label.setText("CPU Wins!");
			finale.add(label);
			result.setVisible(true);
			return false;
		}
		else if(action.available == 0)
		{
			label.setText("CAT!");
			finale.add(label);
			result.setVisible(true);
			return false;
		}
		
		return false;
	}
}
