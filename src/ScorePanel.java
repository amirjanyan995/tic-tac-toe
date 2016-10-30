import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
	private JLabel labelScoreO,labelScoreX,labelScoreDraw;
	private Font scoreFont=new Font("", 0, 12);
	public ScorePanel() {
		
		labelScoreO=new JLabel(" ");
		labelScoreX=new JLabel(" ");
		labelScoreDraw=new JLabel(" ");
		
		labelScoreO.setForeground(Color.BLACK);
		labelScoreX.setForeground(Color.BLACK);
		labelScoreDraw.setForeground(Color.BLACK);
		
		labelScoreO.setFont(scoreFont);
		labelScoreX.setFont(scoreFont); 
		labelScoreDraw.setFont(scoreFont);
		
		setLayout(new GridLayout(3, 1));
		setBackground(Color.WHITE);
		
		add(labelScoreX);
		add(labelScoreO);
		add(labelScoreDraw);
	}
	public void updateScorePanel(int userScore,int computerScore,int drawScore){
		labelScoreX.setText(" Player - "+Integer.toString(userScore));
		labelScoreO.setText(" Comp - "+Integer.toString(computerScore));
		labelScoreDraw.setText(" Draw -"+Integer.toString(drawScore));
	}
}
