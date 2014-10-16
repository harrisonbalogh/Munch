package platform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import entities.Food;
import entities.Player;

public class InterfaceItem {
	
	public static final int        WINDOW_X = 400;
	public static final int        WINDOW_Y = 600;
	public static final int WINDOW_X_OFFSET = 0;
	public static final int WINDOW_Y_OFFSET = 22;
	
	public JFrame frame_main		= new MainFrame();
	public JPanel panel_menu 		= new JPanel(new BorderLayout());
	public JPanel panel_game 		= new GamePanel();
	public JPanel panel_score		= new JPanel(new BorderLayout());
	public JLabel scene_logo 		= new JLabel(new ImageIcon("src/resources/scene_logo.png"));
	public JLabel scene_play 		= new JLabel(new ImageIcon("src/resources/scene_play.png"));
	public JLabel scene_menu 		= new JLabel(new ImageIcon("src/resources/scene_menu.png"));
	public JLabel scene_stats 		= new JLabel(new ImageIcon("src/resources/scene_stats.png"));
	public JLabel scene_about 		= new JLabel(new ImageIcon("src/resources/scene_about.png"));
	public JLabel scene_credits 	= new JLabel(new ImageIcon("src/resources/scene_credits.png"));
	public JButton button_play 		= new JButton(new ImageIcon("src/resources/button_play.png"));
	public JButton button_stats 	= new JButton(new ImageIcon("src/resources/button_stats.png"));
	public JButton button_about 	= new JButton(new ImageIcon("src/resources/button_about.png"));
	public JButton button_credits 	= new JButton(new ImageIcon("src/resources/button_credits.png"));
	public JButton button_back 		= new JButton(new ImageIcon("src/resources/button_back.png"));
	public JButton button_reload 	= new JButton(new ImageIcon("src/resources/button_reload.png"));
	public JTextArea text_score 	= new JTextArea("0");
	public JTextArea text_food 		= new JTextArea("0 / 10");
	

	public InterfaceItem(){
		// Once Launch initiates a new InterfaceItem object... all the below JComponents are initiated with the following properties...
		panel_game.setVisible(false);
		panel_menu.setSize(WINDOW_X, WINDOW_Y);
		panel_game.setSize(WINDOW_X, WINDOW_Y-39);

		button_play.setBounds(87, 237, 229, 39);
		button_play.setPressedIcon(new ImageIcon("src/resources/button_play_pressed.png"));
		button_play.setRolloverIcon(new ImageIcon("src/resources/button_play_rollover.png"));
		button_play.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			endMenuScene();
			runPlayScene();
		}});
		panel_menu.add(button_play);
		button_stats.setBounds(87, 291, 229, 39);
		button_stats.setPressedIcon(new ImageIcon("src/resources/button_stats_pressed.png"));
		button_stats.setRolloverIcon(new ImageIcon("src/resources/button_stats_rollover.png"));
		button_stats.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			endScenes();
			runStatsScene();
		}});
		panel_menu.add(button_stats);
		button_about.setBounds(87, 345, 229, 39);
		button_about.setPressedIcon(new ImageIcon("src/resources/button_about_pressed.png"));
		button_about.setRolloverIcon(new ImageIcon("src/resources/button_about_rollover.png"));
		button_about.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			endScenes();
			runAboutScene();
		}});
		panel_menu.add(button_about);
		button_credits.setBounds(87, 399, 229, 39);
		button_credits.setPressedIcon(new ImageIcon("src/resources/button_credits_pressed.png"));
		button_credits.setRolloverIcon(new ImageIcon("src/resources/button_credits_rollover.png"));
		button_credits.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			endScenes();
			runCreditsScene();
		}});
		panel_menu.add(button_credits);
		button_back.setBounds(0, 561, 39, 39);
		button_back.setPressedIcon(new ImageIcon("src/resources/button_back_pressed.png"));
		button_back.setRolloverIcon(new ImageIcon("src/resources/button_back_rollover.png"));
		button_back.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			endScenes();
			runMenuScene();
		}});
		button_back.setVisible(false);
		panel_menu.add(button_back);
		button_reload.setBounds(39, 561, 39, 39);
		button_reload.setPressedIcon(new ImageIcon("src/resources/button_reload_pressed.png"));
		button_reload.setRolloverIcon(new ImageIcon("src/resources/button_reload_rollover.png"));
		button_reload.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){runPlayScene();}});
		button_reload.setVisible(false);
		panel_menu.add(button_reload);
		
		text_score.setBounds(88, 568, 150, 25);
		text_score.setForeground(Color.BLACK);
		text_score.setBackground(Color.WHITE);
		text_score.setEditable(false);
		text_score.setHighlighter(null);
		text_score.setVisible(false);
		text_score.setFont(new Font("LeviWindows", Font.PLAIN, 35));
		panel_menu.add(text_score);
		text_food.setBounds(248, 568, 115, 25);
		text_food.setForeground(Color.BLACK);
		text_food.setBackground(Color.WHITE);
		text_food.setEditable(false);
		text_food.setHighlighter(null);
		text_food.setVisible(false);
		text_food.setFont(new Font("LeviWindows", Font.PLAIN, 35));
		panel_menu.add(text_food);
		scene_play.setVisible(false);
		scene_play.setBounds(0, 0, WINDOW_X, WINDOW_Y);
		panel_menu.add(scene_play);
		scene_logo.setBounds(0, 0, WINDOW_X, WINDOW_Y);
		scene_logo.setVisible(false);
		panel_menu.add(scene_logo);
		scene_menu.setBounds(0, 0, WINDOW_X, WINDOW_Y);
		scene_menu.setVisible(false);
		panel_menu.add(scene_menu);
		scene_about.setBounds(0, 0, WINDOW_X, WINDOW_Y);
		scene_about.setVisible(false);
		panel_menu.add(scene_about);
		scene_stats.setBounds(0, 0, WINDOW_X, WINDOW_Y);
		scene_stats.setVisible(false);
		panel_menu.add(scene_stats);
		scene_credits.setBounds(0, 0, WINDOW_X, WINDOW_Y);
		scene_credits.setVisible(false);
		panel_menu.add(scene_credits);
		
		// The next 7 lines are properties initialized for the JFrame.
		frame_main.setTitle("Munch");
		frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_main.setSize(WINDOW_X + WINDOW_X_OFFSET, WINDOW_Y + WINDOW_Y_OFFSET);
		frame_main.getContentPane().setBackground(Color.WHITE);
		frame_main.setLocationRelativeTo(null);
		frame_main.setLayout(null);
		frame_main.setResizable(false);
		
		// The next set of code adds two JPanel's to the JFrame and adds the advanced equivalent of KeyListeners (In this case called Key Bindings) to those JPanels.
		frame_main.getContentPane().add(panel_game);
		frame_main.getContentPane().add(panel_menu);
		// We use KeyBindings below instead of KeyListeners because KeyListeners rely on a JComponent being "focused" upon. Whenever a button is clicked
		// in a JFrame, you have to refocus the JPanel with the KeyListener to actually continue "listening" for key presses.
		// Basically this property called "focus" is moved around a lot, and KeyListeners are unreliable when focus is changing often.
		InputMap in = panel_game.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = panel_game.getActionMap();
		if(Launch.ARROW_MOVEMENT){
			in.put(KeyStroke.getKeyStroke("LEFT"), "doA_Pressed");
			am.put( "doA_Pressed", new InputController.A_Pressed());
			in.put( KeyStroke.getKeyStroke("RIGHT"), "doD_Pressed");
			am.put( "doD_Pressed", new InputController.D_Pressed());
		} else {
			in.put(KeyStroke.getKeyStroke('a'), "doA_Pressed");
			am.put( "doA_Pressed", new InputController.A_Pressed());
			in.put( KeyStroke.getKeyStroke('d'), "doD_Pressed");
			am.put( "doD_Pressed", new InputController.D_Pressed());
		}
		in.put(KeyStroke.getKeyStroke('p'), "doP_Pressed");
		am.put( "doP_Pressed", new InputController.P_Pressed());
		// You always set the JFrame to visible after all of its components have been added... Using: add(name_of_a_jcomponent);
		frame_main.setVisible(true);
	}
	
	public static void fadeIn(JLabel img){
		// Fading in/out the logo screen. Not yet implemented.
	}
	
	public static void fadeOut(JLabel img){
		// Fading in/out the logo screen. Not yet implemented.
	}
	
	public void runMenuScene(){
		GameClock.stopGameClock();
		SoundBank.sound_play_theme();
		Launch.playing = false;
		Food.food.clear();
		Launch.p.setScore(0);
		Launch.p.setFood(0);
		scene_menu.setVisible(true);
		button_play.setVisible(true);
		button_stats.setVisible(true);
		button_about.setVisible(true);
		button_credits.setVisible(true);
	}
	private void endMenuScene(){
		scene_menu.setVisible(false);
		button_play.setVisible(false);
		button_stats.setVisible(false);
		button_about.setVisible(false);
		button_credits.setVisible(false);
	}
	public void runPlayScene(){
		//SoundBank.sound_play_simpleTheme();
		GameClock.startGameClock();
		text_food.setVisible(true);
		text_score.setVisible(true);
		text_food.setText("Food: 0/10");
		text_score.setText("Score: 0");
		Food.food.clear();
		Launch.p = new Player();
		Launch.playing = true;
		button_back.setLocation(0, 561);
		button_reload.setLocation(39, 561);
		panel_game.setVisible(true);
		scene_play.setVisible(true);
		button_back.setVisible(true);
		button_reload.setVisible(true);
	}
	private void endPlayScene(){
		GameClock.stopGameClock();
		text_food.setVisible(false);
		text_score.setVisible(false);
		panel_game.setVisible(false);
		button_reload.setVisible(false);
		button_back.setVisible(false);
		scene_play.setVisible(false);
	}
	public void runStatsScene(){
		scene_stats.setVisible(true);
		button_back.setVisible(true);
	}
	private void endStatsScene(){
		scene_stats.setVisible(false);
		button_back.setVisible(false);
	}
	public void runAboutScene(){
		scene_about.setVisible(true);
		button_back.setVisible(true);
	}
	private void endAboutScene(){
		scene_about.setVisible(false);
		button_back.setVisible(false);
		
	}
	public void runCreditsScene(){
		scene_credits.setVisible(true);
		button_back.setVisible(true);
	}
	private void endCreditsScene(){
		scene_credits.setVisible(false);
		button_back.setVisible(false);
	}
	private void endScenes(){
		endMenuScene();
		endCreditsScene();
		endAboutScene();
		endStatsScene();
		endPlayScene();
	}
	
	public static class MainFrame extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public MainFrame(){
			setLayout(new BorderLayout());
		}
		public void paint(Graphics g) { 
			// Paint currently does nothing by our JFrame, GOTO bottom of InterfaceItem class to see where painting of food and players is done.
			super.paint(g);
			paintComponent(g);

		}
		
		public void paintComponent(Graphics g){
			repaint();
		}
	}
	
	public static class GamePanel extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public GamePanel(){
			setLayout(new BorderLayout());
		}
		@Override 
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			
			Launch.p.draw(g2d);
			g2d.setColor(Color.BLACK);
			if(!Launch.p.getAlive()) g2d.drawString("GAME OVER", 155, 300);
			else if(!Launch.playing) g2d.drawString("PAUSED", 155, 300);
			for(Food f : Food.food){
				f.draw(g2d);
			}
			g2d.dispose();
			try {
		    	Thread.sleep(10);
		    	}
		    catch(InterruptedException ex) {}
	    }		
	}
}