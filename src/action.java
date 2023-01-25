import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class action implements ActionListener
{
	public static int[] playerPos = new int[9];
	public static int[] cpuPos = new int[9];
	public static int[] totalPos = new int[9];
	public static int available = 9;
    
	static JFrame frame;
    public static JPanel panel;
    public static JButton button1;
    public static JButton button2;
    public static JButton button3;
    public static JButton button4;
    public static JButton button5;
    public static JButton button6;
    public static JButton button7;
    public static JButton button8;
    public static JButton button9;
    
    public JButton retryY = new JButton("Yes");
	public JButton retryN = new JButton("No");
	
	static JFrame result;
	static JPanel finale;
	static JLabel label;
	
	public action()
	{		
		result = new JFrame();
		finale = new JPanel();
		label = new JLabel();
		
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
		
		createButton(retryY);
		createButton(retryN);
		
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
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (dimension.getWidth() - frame.getWidth()) / 2;
		int y = (int) (dimension.getHeight() - frame.getHeight()) / 2;
		int resultx = (int) ((dimension.getWidth() - frame.getWidth()) / 2) - (frame.getWidth() - 100);
		int winx = (int) ((dimension.getWidth() - frame.getWidth()) / 2) + (frame.getWidth());
		frame.setLocation(x, y);
		result.setLocation(resultx, y);
		checkWin.result.setLocation(winx, y);
		
		label.setFont(new Font("Arial", Font.BOLD, 30));
		label.setForeground(Color.black);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		finale = new JPanel();
		finale.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		finale.setLayout(new GridLayout(3, 1));
		
		result.setSize(500, 500);
		result.add(finale, BorderLayout.CENTER);
		result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		result.setTitle("TicTacToe");
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
		
		else if(button == retryY)
		{
			frame.dispose();
			checkWin.result.dispose();
			result.dispose();
			playerPos = new int[9];
			cpuPos = new int[9];
			totalPos = new int[9];
			available = 9;
			new checkWin();
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					board.gameBoard[i][j] = '_';
				}
			}
			new action();
			return;
		}
		else if(button == retryN)
		{
			System.exit(1);
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
		
		int cpuPosition = board.findBestMove(board.gameBoard);
		
		switch(cpuPosition)
	    {
	    	case 0:
	    		break;
	    	case 1:
	    		action.button1.setText("O");
	    		action.cpuPos[0] = cpuPosition;
	    		action.totalPos[0] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		action.available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 2:
	    		action.button2.setText("O");
	    		action.cpuPos[1] = cpuPosition;
	    		action.totalPos[1] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		action.available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 3:
	    		action.button3.setText("O");
	    		action.cpuPos[2] = cpuPosition;
	    		action.totalPos[2] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		action.available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 4:
	    		action.button4.setText("O");
	    		action.cpuPos[3] = cpuPosition;
	    		action.totalPos[3] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		action.available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 5:
	    		action.button5.setText("O");
	    		action.cpuPos[4] = cpuPosition;
	    		action.totalPos[4] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		action.available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 6:
	    		action.button6.setText("O");
	    		action.cpuPos[5] = cpuPosition;
	    		action.totalPos[5] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		action.available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 7:
	    		action.button7.setText("O");
	    		action.cpuPos[6] = cpuPosition;
	    		action.totalPos[6] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		action.available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 8:
	    		action.button8.setText("O");
	    		action.cpuPos[7] = cpuPosition;
	    		action.totalPos[7] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		action.available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    	case 9:
	    		action.button9.setText("O");
	    		action.cpuPos[8] = cpuPosition;
	    		action.totalPos[8] = cpuPosition;
	    		board.UpdateBoardWithCPU(cpuPosition);
	    		action.available -= 1;
	    		checkWin.CheckWin();
	    		break;
	    }
	    
	    if(checkWin.CheckWin())
	    {			
			action.label.setText("Retry?");
			action.finale.add(action.label);
			action.finale.add(retryY);
			action.finale.add(retryN);
			action.result.setVisible(true);
	    }
	    
	    if(checkWin.checkPlayerWin())
		{
			checkWin.label.setText("Congratulations you won!");
			checkWin.finale.add(checkWin.label);
			checkWin.result.setVisible(true);
		}
		else if(checkWin.checkCpuWin())
		{
			checkWin.label.setText("CPU Wins!");
			checkWin.finale.add(checkWin.label);
			checkWin.result.setVisible(true);
		}
		else if(action.available == 0)
		{
			checkWin.label.setText("CAT!");
			checkWin.finale.add(checkWin.label);
			checkWin.result.setVisible(true);
		}

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
