import javax.swing.*;
import java.awt.*;

import java.awt.event.*;


/**
 * Application window.
 * Holds the menu-bar etc.
 *
 * @author David Winter
 */
public class AppWindow extends JFrame 
    implements ActionListener, ComponentListener
{
    private GamePanel gamePanel;
    private Color defaultTableColour = new Color(6, 120, 0);
    
    private JMenuItem savePlayer = new JMenuItem("Save Current Player");
    private JMenuItem openPlayer = new JMenuItem("Open Existing Player");
    
    final int WIDTH = 600;
    final int HEIGHT = 500;

	public AppWindow()
    {
        super("Blackjack");
        
        addComponentListener(this);
        
        Dimension windowSize = new Dimension(WIDTH, HEIGHT);
        setSize(windowSize);
        setLocationRelativeTo(null); // put game in centre of screen
        
        this.setBackground(defaultTableColour);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // menu bar
        JMenuBar menuBar = new JMenuBar();
        
        JMenu playerMenu = new JMenu("Jogador");
        JMenuItem updatePlayerDetails = new JMenuItem("Atualizar dados do jogador");
        playerMenu.add(updatePlayerDetails);
        playerMenu.addSeparator();
        playerMenu.add(savePlayer);
        playerMenu.add(openPlayer);
        menuBar.add(playerMenu);
        
        JMenu actionMenu = new JMenu("Ações");
        JMenuItem dealAction = new JMenuItem("Chamar");
        JMenuItem hitAction = new JMenuItem("Bater");
        JMenuItem doubleAction = new JMenuItem("Dobro");
        JMenuItem standAction = new JMenuItem("Manter");
        actionMenu.add(dealAction);
        actionMenu.add(hitAction);
        actionMenu.add(doubleAction);
        actionMenu.add(standAction);
        menuBar.add(actionMenu);
        
        JMenu betMenu = new JMenu("Apostas");
        JMenuItem oneChip = new JMenuItem("$1");
        JMenuItem fiveChip = new JMenuItem("$5");
        JMenuItem tenChip = new JMenuItem("$10");
        JMenuItem twentyFiveChip = new JMenuItem("$25");
        JMenuItem hundredChip = new JMenuItem("$100");
        betMenu.add(oneChip);
        betMenu.add(fiveChip);
        betMenu.add(tenChip);
        betMenu.add(twentyFiveChip);
        betMenu.add(hundredChip);
        menuBar.add(betMenu);
        
        JMenu windowMenu = new JMenu("Janela");
        JMenuItem windowTableColourMenu = new JMenuItem("Trocar cor da mesa");
        windowMenu.add(windowTableColourMenu);
        menuBar.add(windowMenu);
        
        JMenu helpMenu = new JMenu("Ajuda");
        JMenuItem helpBlackjackRulesMenu = new JMenuItem("Regras do Blackjack");
        JMenuItem helpAboutMenu = new JMenuItem("Sobre Blackjack");
        helpMenu.add(helpBlackjackRulesMenu);
        helpMenu.addSeparator();
        helpMenu.add(helpAboutMenu);
        menuBar.add(helpMenu);
        
        setJMenuBar(menuBar);
        
        // keyboard shortcuts
        
        updatePlayerDetails.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_U,                                            
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        savePlayer.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_S,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        openPlayer.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_O,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));   
        dealAction.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_N,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        hitAction.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_C,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        doubleAction.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_D,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        standAction.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_F,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        oneChip.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_1,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        fiveChip.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_2,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        tenChip.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_3,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        twentyFiveChip.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_4,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        hundredChip.setAccelerator(
            KeyStroke.getKeyStroke( java.awt.event.KeyEvent.VK_5,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        
        
		// action listeners
		dealAction.addActionListener(this);
        hitAction.addActionListener(this);
        doubleAction.addActionListener(this);
        standAction.addActionListener(this);
		updatePlayerDetails.addActionListener(this);
		savePlayer.addActionListener(this);
		openPlayer.addActionListener(this);
		windowTableColourMenu.addActionListener(this);
		helpBlackjackRulesMenu.addActionListener(this);
        helpAboutMenu.addActionListener(this);
		oneChip.addActionListener(this);
        fiveChip.addActionListener(this);
        tenChip.addActionListener(this);
        twentyFiveChip.addActionListener(this);
        hundredChip.addActionListener(this);
        		
        gamePanel = new GamePanel();
        gamePanel.setBackground(defaultTableColour);
		add(gamePanel);
        
        setVisible(true);
    }

	public void actionPerformed(ActionEvent evt)
    {
        String act = evt.getActionCommand();
        
        if (act.equals("$1"))
        {
            gamePanel.increaseBet(1);
        }
        else if (act.equals("$5"))
        {
            gamePanel.increaseBet(5);
        }
        else if (act.equals("$10"))
        {
            gamePanel.increaseBet(10);
        }
        else if (act.equals("$25"))
        {
            gamePanel.increaseBet(25);
        }
        else if (act.equals("$100"))
        {
            gamePanel.increaseBet(100);
        }
        else if (act.equals("Chamar"))
        {
            gamePanel.newGame();
        }
        else if (act.equals("Bater"))
        {
            gamePanel.hit();
        }
        else if (act.equals("Dobro"))
        {
            gamePanel.playDouble();
        }
        else if (act.equals("Manter"))
        {
            gamePanel.stand();
        }
        else if (act.equals("Atualizar dados do jogador"))
        {
            gamePanel.updatePlayer();
        }
        else if (act.equals("Save Current Player"))
        {
            gamePanel.savePlayer();
        }
        else if (act.equals("Open Existing Player"))
        {
            gamePanel.openPlayer();
        }
		else if (act.equals("Trocar cor da mesa"))
		{
		    Color tableColour = JColorChooser.showDialog(this, "Select Table Colour", defaultTableColour);
		    this.setBackground(tableColour);
		    gamePanel.setBackground(tableColour);
		    gamePanel.repaint();
		    this.repaint();
		}
		else if (act.equals("Sobre Blackjack"))
		{
		    String aboutText = "<html><p align=\"center\" style=\"padding-bottom: 10px;\">Written by David Winter &copy; 2006<br>Version 1.0</p><p align=\"center\" style=\"padding-bottom: 10px;\"><small>Become such an expert while developing this, <br>I won $1000 online in a game of Blackjack!</small></p><p align=\"center\">email: djw@davidwinter.me.uk<br>web: davidwinter.me.uk</p></html>";
		    JOptionPane.showMessageDialog(this, aboutText, "Sobre Blackjack", JOptionPane.PLAIN_MESSAGE);
		}else if (act.equals("Regras do Blackjack"))
		{
		    String aboutText = "<html><p align=\"center\" style=\"padding-bottom: 10px;\">Blackjack<br>Version 1.0</p><p align=\"center\" style=\"padding-bottom: 10px;\"><small>Blackjack tem como objetivo atingir 21 pontos ou o mais proximo disso não ultrapassando essa pontuação<br><br>Como Jogar<br><br>Primeiro selecione a quantidade que gostaria de apostar<br>Chamar: Você finaliza a faze de aposta e chama a primeira carta<br>Bnater: Você bate na mesa pedindo mais uma carta<br>Dobro: Ambos os jogadores pegam 2 cartas<br>Manter: Mantem as cartas que tem em mãos. </small></p><p align=\"center\"></p></html>";
		    JOptionPane.showMessageDialog(this, aboutText, "Regras Blackjack", JOptionPane.PLAIN_MESSAGE);
		}
		
		gamePanel.updateValues();
	}
	
	public void componentResized(ComponentEvent e)
	{
	    int currentWidth = getWidth();
	    int currentHeight = getHeight();
	    
	    boolean resize = false;
	    
	    if (currentWidth < WIDTH)
	    {
	        resize = true;
	        currentWidth = WIDTH;
	    }
	    
	    if (currentHeight < HEIGHT)
	    {
	        resize = true;
	        currentHeight = HEIGHT;
	    }
	    
	    if (resize)
	    {
	        setSize(currentWidth, currentHeight);
	    }
	}
	
	public void componentMoved(ComponentEvent e) { }
	public void componentShown(ComponentEvent e) { }
	public void componentHidden(ComponentEvent e) { }
}