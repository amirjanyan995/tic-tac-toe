import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SouthPanel extends JPanel {
	private ScorePanel scorePanel=new ScorePanel(); 
	private static JLabel pobeda = new JLabel(" ");
	private static JLabel player = new JLabel(" ");
	private static Font but = new Font("", 0, 19);
	public SouthPanel() {	
		initPobedaLabel();
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));
		add(pobeda, BorderLayout.CENTER);
		add(player, BorderLayout.EAST);
		add(scorePanel, BorderLayout.WEST);
		
	}
	private static void initPobedaLabel(){
		pobeda.setHorizontalAlignment(JTextField.CENTER);
		pobeda.setFont(but);
		pobeda.setForeground(Color.black);
	}
	public static void setPobedaText(String text) {
		SouthPanel.pobeda.setText(text);;
	}
	private static void initPlayerLabel(){
		player.setFont(but);
		player.setForeground(Color.black);
	}
	/*
	 * katarum e stugum  ev hajord xaxacoxi  xaxi hushum 
	 */
	public void playerCheck(boolean t) {
		if (t)
			player.setText(" X ");
		else
			player.setText(" O ");
	}
	
	public void updateScorePanel(int userScore,int computerScore,int drawScore){
		
		scorePanel.updateScorePanel(userScore, computerScore,drawScore);
	}
}
