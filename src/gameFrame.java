import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class gameFrame extends JFrame implements ActionListener {
	private static String stat="X",backStat="O";
	private static final String comp="Comp",player="Player";
	private static Random r=new Random();
	private static int algorithmReturnValue;
	/*
	 * artaqin tesqi  kazmakerpummm 
	 */
	private static int a = 0;								//dashti zbaxvacucyan hashvich
	private static int userScore=0,computerScore=0,drawScore=0; 
	private static boolean t = true;						//voroshum e vor xaxacoxi hertn e	
	private static boolean overGame = false;				//hasel e xaxi verj
	private JPanel gamePanel = new JPanel();				//xaxayn dasht
	private static SouthPanel southPanel;					//miavorneri ev haxtanakneri dasht nerqevi masum
	private static MenuBar menuBar=new MenuBar();			//menu bar
	private final ImageIcon icon = new ImageIcon("icon.png");//framei icon
	private static final Icon X = new ImageIcon("x.png");	//X icon
	private static final Icon O = new ImageIcon("o.png");	//O icon
	private static Icon statIcon=X,backStatIcon=O; 			
	private static JButton labelButton[] = new JButton[9];	//3x3 dashter
	private static String buttonArray[] = new String[9];	//nerqin hashvarkayin dasht
	gameFrame() {
		super("Крестики-нолики");
		setBounds(200, 200, 450, 520);						//size//position
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(icon.getImage());						//frame icon
		setLayout(new BorderLayout());
		
		//xaxayin dashti avelacum freymi vra
		gamePanel.setLayout(new GridLayout(3, 3, 4, 4));
		gamePanel.setBackground(Color.black);
		add(gamePanel, BorderLayout.CENTER);
		
		//miavorneri dashti avelacum freymi vra
		southPanel=new SouthPanel();
		southPanel.playerCheck(t);
		southPanel.updateScorePanel(userScore,computerScore,drawScore);
		add(southPanel, BorderLayout.SOUTH);
		
		setJMenuBar(menuBar);
		//3x3 dashteri haytararum
		for (int i = 0; i < labelButton.length; i++) {
			labelButton[i] = new JButton();
			//labelButton[i].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
			labelButton[i].setFocusPainted(false);
			labelButton[i].addActionListener(this);
			labelButton[i].setBackground(Color.white);
			labelButton[i].setRolloverEnabled(false);
			buttonArray[i] = "-";
			gamePanel.add(labelButton[i]);
		}
		setVisible(true);
	}
	/*
	 * Freamin nor xaxi patrastum (amen inch skzbnakan vichak)
	 */
	public static void startNewFrame() {
		for (int i = 0; i < labelButton.length; i++) {
			buttonArray[i] = "-";
			labelButton[i].setIcon(null);
		}
		stat="X";
		statIcon=X;
		backStat="O";
		backStatIcon=O;
		overGame = false;
		a = 0;
		southPanel.playerCheck(true);
		southPanel.setPobedaText("  ");
	}
	public static boolean getT() {
		return t;
	}

	public static void setT(boolean t) {
		gameFrame.t = t;
	}
	public static void statGamer(String temp){
		if(temp.equals("X")){//gamer==true
			stat="X";
			statIcon=X;
			backStat="O";
			backStatIcon=O;
		}else if(temp.equals("O")){//gamer==false
			stat="O";
			statIcon=O;
			backStat="X";
			backStatIcon=X;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!overGame) {
			//sxmvelit buttoni stugum
			for (int i = 0; i < labelButton.length; i++) {
				//hamapatasxanecman stugum
				if (e.getSource() == labelButton[i]&& buttonArray[i].equals("-")) {
					if (labelButton[i].getIcon() != statIcon && labelButton[i].getIcon() != backStatIcon ) {
						System.out.println("i-"+i);
						a++;
						labelButton[i].setIcon(statIcon);
						buttonArray[i] = stat;
						if (check.check(i, buttonArray)) {
							victory(player);
							userScore++;
							break;
						} else if (check.nichiya(buttonArray))	draw();
					}
					/*
					 *algorithm 
					 */
					if(a!=9){
						if((algorithmReturnValue=GameAlgorithm.hardzakum(buttonArray, stat, backStat))!=-1){
							a++;//
							//System.out.println(a);
							labelButton[algorithmReturnValue].setIcon(backStatIcon);
							buttonArray[algorithmReturnValue]=backStat;
							System.out.println("comp-"+algorithmReturnValue);
						}else{
							a++;//
							//System.out.println(a);
							algorithmReturnValue=GameAlgorithm.pashapan(buttonArray, stat, backStat);
							labelButton[algorithmReturnValue].setIcon(backStatIcon);
							buttonArray[algorithmReturnValue]=backStat;
							System.out.println("comp-"+algorithmReturnValue);
						}
						if (check.check(algorithmReturnValue, buttonArray)) {
							victory(comp);
							computerScore++;
							break;
						} else if (check.nichiya(buttonArray)) draw();
					}
					if(a==8){
						if(check.shutStugum(buttonArray))
							draw();
					}
						
					
					
				}
			}	
		}
		else if(overGame)
			startNewFrame();
	}
	private static void draw(){
		drawScore++;
		southPanel.setPobedaText("Ոչ-ոքի");
		overGame = true;
		southPanel.updateScorePanel(userScore, computerScore, drawScore);
	}
	private static void victory(String name){
		southPanel.setPobedaText(name +"Հաղթեց");
		overGame = true;
		southPanel.updateScorePanel(userScore,computerScore,drawScore);
	}
}
