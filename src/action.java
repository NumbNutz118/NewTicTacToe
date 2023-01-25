import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class action implements ActionListener
{
	public static int[] playerPos = new int[9];
	public static int[] cpuPos = new int[9];
	public int[] totalPos = new int[9];
	public static int available = 9;
    
	static JFrame frame;
    public static JPanel panel;
    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JButton button5;
    public JButton button6;
    public JButton button7;
    public JButton button8;
    public JButton button9;
	
	public action()
	{
		frame = new JFrame();
		
		button1 = new JButton(" ");
		button2 = new JButton(" ");
		button3 = new JButton(" ");
		button4 = new JButton(" ");
		button5 = new JButton(" ");
		button6 = new JButton(" ");
		button7 = new JButton(" ");
		button8 = new JButton(" ");
		button9 = new JButton(" ");
		
		createButton(button1);
		createButton(button2);
		createButton(button3);
		createButton(button4);
		createButton(button5);
		createButton(button6);
		createButton(button7);
		createButton(button8);
		createButton(button9);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		
		frame.setSize(600, 600);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TicTacToe");
		frame.setVisible(true);
	}
	
	public void createButton(JButton button)
	{
		button.addActionListener(this);
		button.setFont(new Font("Arial", Font.BOLD, 80));
		if(button == button1)
		{
			button.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 5, Color.black));
		}
		else if(button == button2)
		{
			button.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.black));
		}
		else if(button == button3)
		{
			button.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 0, Color.black));
		}
		else if(button == button4)
		{
			button.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.black));
		}
		else if(button == button5)
		{
			button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
		}
		else if(button == button6)
		{
			button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 0, Color.black));
		}
		else if(button == button7)
		{
			button.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 5, Color.black));
		}
		else if(button == button8)
		{
			button.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5, Color.black));
		}
		else if(button == button9)
		{
			button.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 0, Color.black));
		}
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton button = (JButton) e.getSource();
		
		char[][] play = new char[3][3];
		int buttonNum = 0;
		if(button == button1)
		{
			buttonNum = 1;
		}
		else if(button == button2)
		{
			buttonNum = 2;
		}
		else if(button == button3)
		{
			buttonNum = 3;
		}
		else if(button == button4)
		{
			buttonNum = 4;
		}
		else if(button == button5)
		{
			buttonNum = 5;
		}
		else if(button == button6)
		{
			buttonNum = 6;
		}
		else if(button == button7)
		{
			buttonNum = 7;
		}else if(button == button8)
		{
			buttonNum = 8;
		}
		else if(button == button9)
		{
			buttonNum = 9;
		}
		
		if(button.getText() == "X" || button.getText() == "O")
		{
			return;
		}
		else
		{
			button.setText("X");
			playerPos[buttonNum - 1] = buttonNum;
			totalPos[buttonNum - 1] = buttonNum;
			board.UpdateBoardWithPlayer(buttonNum);
			available -= 1;
			checkWin.CheckWin();
		}
		
		
		//Random rand = new Random();
	    //int cpuPosition = rand.nextInt(9) + 1;
	    
		int cpuPosition = board.findBestMove(board.gameBoard);
		
//	    while(check(playerPos, cpuPosition) || check(cpuPos, cpuPosition))
//	    {
//	    	if(available == 0)
//	    	{
//	    		return;
//	    	}
//	    	cpuPosition = rand.nextInt(9) + 1;
//	    }
		
	    switch(cpuPosition)
	    {
	    	case 0:
	    		break;
	    	case 1:
	    		button1.setText("O");
	    		cpuPos[0] = cpuPosition;
	    		totalPos[0] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 2:
	    		button2.setText("O");
	    		cpuPos[1] = cpuPosition;
	    		totalPos[1] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 3:
	    		button3.setText("O");
	    		cpuPos[2] = cpuPosition;
	    		totalPos[2] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 4:
	    		button4.setText("O");
	    		cpuPos[3] = cpuPosition;
	    		totalPos[3] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 5:
	    		button5.setText("O");
	    		cpuPos[4] = cpuPosition;
	    		totalPos[4] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 6:
	    		button6.setText("O");
	    		cpuPos[5] = cpuPosition;
	    		totalPos[5] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 7:
	    		button7.setText("O");
	    		cpuPos[6] = cpuPosition;
	    		totalPos[6] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 8:
	    		button8.setText("O");
	    		cpuPos[7] = cpuPosition;
	    		totalPos[7] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 9:
	    		button9.setText("O");
	    		cpuPos[8] = cpuPosition;
	    		totalPos[8] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    }
	    
	    for(int i = 0; i < 9; i++)
		{
			System.out.print(cpuPos[i]);
		}
	    
//	    for(int i = 0; i < 3; i++)
//	    {
//	    	for(int j = 0; j < 3; j++)
//	    	{
//	    		System.out.print(board.gameBoard[i][j]);
//	    	}
//	    	System.out.print("\n");
//	    }
//	    int bestMove = board.findBestMove(board.gameBoard);
//	    System.out.print(bestMove);
	}
	
	public static boolean check(int[] arr, int toCheckValue)
	{
		boolean test = false;
        for (int element : arr) 
        {
            if (element == toCheckValue) 
            {
                test = true;
            }
        }
        return test;
	}
}
