package thomas.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolTip;

import thomas.game.entities.Blob;
import thomas.game.entities.Entity;
import thomas.game.entities.Player;
import thomas.game.items.Item;
import thomas.game.spells.Spell;
import thomas.game.spells.melee.Boomhands;
import thomas.game.weapons.Sword;
import thomas.game.weapons.Weapon;

public class GameGUI extends JFrame implements ActionListener {

	GameObject g = GameObject.g;
	JTextArea gameArea;
	JPanel comboPanel;
	JLabel playerStats;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JComboBox spellBox;
	JComboBox enemyBox;
	JComboBox weaponBox;
	ImageIcon spellIcon;
	JToolTip spellTip;
	JMenu spellMenu;
	Player p;
	ArrayList<Weapon> inventoryList = GameObject.inventoryList;
	ArrayList<Spell> spellList = GameObject.player.spellList;
	ArrayList<JLabel> labelList = new ArrayList<>();
	ArrayList<Entity> enemyList = GameObject.enemyList;
	Spell spell;


	public GameGUI() {
		spellList.add(null);
		enemyList.add(null);
		Weapon hand = new Sword("hand", 0, 0, null);
		inventoryList.add(hand);
		// ImageIcon spellIconT = new
		// ImageIcon("C:\\Users\\thoma\\Documents\\GitHub\\Text-game\\Project\\src\\thomas\\game\\assets\\spell.png");
		// Image newImage = spellIconT.getImage().getScaledInstance(-500,-200,
		// Image.SCALE_FAST);
		// spellIcon = new ImageIcon(newImage);

		// add elements
		// add text area
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(800, 800));
		gameArea = new JTextArea(40, 30);
		gameArea.setFont(new Font("sans", Font.BOLD, 16));
		this.add(gameArea, BorderLayout.CENTER);

		// menu
		// JMenuBar mb = new JMenuBar();
		// spellMenu = new JMenu();
		// spellMenu.setSize(new Dimension(20, 200));
		// spellMenu.setIcon(spellIcon);
		// spellMenu.setText("Spell List");

		// this.add(mb,BorderLayout.NORTH);
		// mb.add(spellMenu);
		// System.out.println(((JComponent) spellMenu.getComponent()));

//		}
		spellBox = new JComboBox<>(GameObject.player.spellList.toArray());
		spellBox.addActionListener(this);
		gameArea.add(spellBox, BorderLayout.NORTH);
		

		enemyList = GameObject.enemyList;
		enemyBox = new JComboBox<>(enemyList.toArray());
		
		weaponBox = new JComboBox<>(inventoryList.toArray());

		// JButton
		b1 = new JButton();
		b1.addActionListener(this);
		b2 = new JButton();
		b2.addActionListener(this);
		b3 = new JButton();
		b3.addActionListener(this);
		b4 = new JButton();
		b4.addActionListener(this);
		// JPanel
		JPanel controlPanel = new JPanel();
		comboPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3, 2));
		playerStats = new JLabel(GameObject.player.toString());
		playerStats.setFont(new Font ("sans",Font.BOLD, 16));
		this.add(playerStats,BorderLayout.LINE_START);
		controlPanel.add(b1);
		controlPanel.add(b2);
		controlPanel.add(b3);
		controlPanel.add(b4);
		
		

		comboPanel.setLayout(new GridLayout(1,3));
		comboPanel.add(spellBox);
		comboPanel.add(weaponBox);
		comboPanel.add(enemyBox);
	

		this.add(controlPanel, BorderLayout.SOUTH);
		this.add(comboPanel, BorderLayout.NORTH);

		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p = GameObject.player;

//		(Spell spell : p.spellList) {
//
//			spellCombo.add(spell.name);
//			((JComponent) spellCombo.getComponent()).createToolTip().setToolTipText(spell.toString());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == spellBox) {
			spell = (Spell) spellBox.getSelectedItem();
			System.out.println(GameObject.location);
			// updateBox();
		}
		if (e.getSource() == enemyBox) {
			GameObject.target = (Entity) enemyBox.getSelectedItem();
			System.out.println(GameObject.location);
			// updateBox();
		}
		if (e.getSource() == b1) {
			GameObject.answer = b1.getText();
			System.out.println(GameObject.location);

			// updateBox();

		}
		if (e.getSource() == b2) {
			GameObject.answer = b2.getText();
			System.out.println(GameObject.location);

			// updateBox();

		}
		if (e.getSource() == b3) {
			GameObject.answer = b3.getText();
			System.out.println(GameObject.location);

			// updateBox();

		}
		if (e.getSource() == b4) {
			GameObject.answer = b4.getText();
			// updateBox();

		}
	}

	public void setOptions(String a1, String a2, String a3, String a4) {
		this.b1.setText(a1);
		this.b2.setText(a2);
		this.b3.setText(a3);
		this.b4.setText(a4);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update() {
		Object spell = spellBox.getSelectedItem();
		comboPanel.remove(spellBox);
		spellBox = new JComboBox(GameObject.player.spellList.toArray());
		comboPanel.add(spellBox);
		spellBox.setSelectedItem(spell);
		
		Object item = weaponBox.getSelectedItem();
		comboPanel.remove(weaponBox);
		weaponBox = new JComboBox(GameObject.inventoryList.toArray());
		comboPanel.add(weaponBox);
		weaponBox.setSelectedItem(item);
		
		Object enemy = enemyBox.getSelectedItem();
		comboPanel.remove(enemyBox);
		enemyBox = new JComboBox(GameObject.enemyList.toArray());
		comboPanel.add(enemyBox);
		enemyBox.setSelectedItem(enemy);
		
		//playerStats.setFont(new Font("sans", Font.BOLD, 32));
		playerStats.setFont(new Font ("sans",Font.BOLD, 16));

		playerStats.setText(GameObject.player.toString());
	}

	public void updateEnemyBox() {
		if (GameObject.enemyList.size() == 0) {
			GameObject.enemyList.add(new Blob("", 0, 0, 0, 0));
		}
	}
}
