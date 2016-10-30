import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar implements ActionListener{
	private static SouthPanel southPanel=new SouthPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu file = new JMenu("Ֆայլ");
	private JMenuItem startX = new JMenuItem("  O");
	private JMenuItem startO = new JMenuItem("  X");
	private JMenu startGame = new JMenu("Նոր խաղ");
	private JMenuItem reset = new JMenuItem("Սկսել նորից");
	private JMenuItem exit = new JMenuItem("Ելք");
	public MenuBar() {
		file.add(startGame);
		startGame.add(startX);
		startGame.add(startO);
		file.add(reset);
		file.addSeparator();
		file.add(exit);
		add(file);
		menuBar.setBackground(Color.white);
		menuBar.setForeground(Color.black);
		menuBar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 2, Color.black));
		file.setBackground(new Color(180, 180, 180));
		file.setForeground(Color.black);
		
		reset.addActionListener(this);
		exit.addActionListener(this);
		startX.addActionListener(this);
		startO.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startO) {
			gameFrame.startNewFrame();
			gameFrame.setT(true);
			gameFrame.statGamer("X");
			southPanel.playerCheck(gameFrame.getT());
		}
		//new game start X
		if (e.getSource() == startX) {
			gameFrame.startNewFrame();
			gameFrame.setT(false);
			gameFrame.statGamer("O");
			southPanel.playerCheck(gameFrame.getT());
		}
		//restart game
		if (e.getSource() == reset) {
			gameFrame.startNewFrame();
		}
		//exit game
		if (e.getSource() == exit) {
			System.exit(0);
		}
		
	}
}
