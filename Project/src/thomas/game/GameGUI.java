package thomas.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolTip;

import thomas.game.entities.Blob;
import thomas.game.entities.Enemy;
import thomas.game.entities.Entity;
import thomas.game.items.Item;
import thomas.game.spells.Spell;
import thomas.game.weapons.Sword;
import thomas.game.weapons.Weapon;

public class GameGUI extends JFrame implements ActionListener {

	JTextArea gameArea;
	JPanel comboPanel;
	JPanel playerPanel;
	JLabel playerStats;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	private JComboBox spellBox;
	private JComboBox entityBox;
	private JComboBox<Item> weaponBox;
	
	ImageIcon spellIcon;
	JToolTip spellTip;
	JMenu spellMenu;
	ArrayList<Weapon> inventory = GameObject.g.player.getWeaponList();
	ArrayList<Spell> spellList = GameObject.g.player.getSpellList();
	ArrayList<JLabel> labelList = new ArrayList<>();
	ArrayList<Entity> entityList = GameObject.g.player.getEntityList();
	ArrayList<Weapon> weaponList = new ArrayList<>();
	
	Spell spell;
	JPanel sp;
	public GameGUI() {
		playerStats = new JLabel();
		Weapon hand = new Sword("hand", 0, 0);		
		GameObject.g.player.getWeaponList().add(hand);
		weaponList.add(Weapon.weapons.get(hand.toItem().name));
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
		setSpellBox(new JComboBox<>(GameObject.player.getSpellList().toArray()));
		getSpellBox().addActionListener(this);
		this.add(getSpellBox(), BorderLayout.NORTH);

		entityList = GameObject.player.getEntityList();
		setEnemyBox(new JComboBox<>(entityList.toArray()));
		setWeaponBox(new JComboBox<>(GameObject.player.getWeaponList().toArray()));

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
		// playerPanel = new JPanel();
		// playerPanel.setLayout(new GridLayout(3,1));

		// playerPanel.add(new JLabel(),new
		// Rectangle(5,5,10*GameObject.player.health,5));
		// playerPanel.add(new JLabel(), new
		// Rectangle(5,5,10*GameObject.player.armor,5));
		controlPanel.setLayout(new GridLayout(2, 2));
		// playerStats = new JLabel(GameObject.player.toString());
		// playerStats.setFont(new Font ("sans",Font.BOLD, 16));
		// this.add(playerStats,BorderLayout.LINE_START);
		controlPanel.add(b1);
		controlPanel.add(b2);
		controlPanel.add(b3);
		controlPanel.add(b4);

		comboPanel.setLayout(new GridLayout(1, 3));
		comboPanel.add(getSpellBox());
		comboPanel.add(getWeaponBox());
		comboPanel.add(getEnemyBox());

		sp = new JPanel() {
			public void paintComponent(Graphics g) {
				Graphics g2 = g;
				super.paintComponent(g2);
				g2.setColor(Color.RED);
				g2.fillRect(5, 20, 10 * GameObject.g.player.getHealth(), 10);
				g2.setColor(Color.gray);
				for (int i = 0; i < GameObject.g.player.getArmor(); i++)
					g2.fillOval((10 * i) + 5, 35, 10, 10);
				// Shape rect = new Rectangle(5, 25, 10 * GameObject.player.health, 5);

			}
		};

		this.add(sp, BorderLayout.WEST);
		playerStats = new JLabel(GameObject.player.toString());
		sp.add(playerStats);
		this.add(controlPanel, BorderLayout.SOUTH);
		this.add(comboPanel, BorderLayout.NORTH);
		// this.add(playerPanel,BorderLayout.PAGE_END);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//		(Spell spell : p.spellList) {
//			spellCombo.add(spell.name);
//			((JComponent) spellCombo.getComponent()).createToolTip().setToolTipText(spell.toString());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("answer = " + GameObject.answer);
		if (e.getSource() == getSpellBox()) {
		//	GameObject.player.fixSpellList();
			spell = (Spell) getSpellBox().getSelectedItem();
			//System.out.println(GameObject.location);
			// updateBox();
		}
		if (e.getSource() == getEnemyBox()) {
			
			GameObject.g.setEnemy((Enemy) getEnemyBox().getSelectedItem());
			//System.out.println(GameObject.location);
			// updateBox();
		}
		if (e.getSource() == b1) {
			GameObject.answer = b1.getText();
			//System.out.println(GameObject.location);
			// updateBox();

		}
		if (e.getSource() == b2) {
			GameObject.answer = b2.getText();
			//System.out.println(GameObject.location);
			// updateBox();

		}
		if (e.getSource() == b3) {
			GameObject.answer = b3.getText();
			//System.out.println(GameObject.location);
			// updateBox();

		}
		if (e.getSource() == b4) {
			GameObject.answer = b4.getText();
			// updateBox();

		}
		//System.out.println(GameObject.answer);
	}
	
	public void setOptions(String a1, String a2, String a3, String a4) {
		this.b1.setText(a1);
		this.b2.setText(a2);
		this.b3.setText(a3);
		this.b4.setText(a4);
		//System.out.println("options answer: "+ GameObject.answer);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update() {

		Object spell = getSpellBox().getSelectedItem();
		comboPanel.remove(getSpellBox());
		setSpellBox(new JComboBox(GameObject.player.getSpellList().toArray()));
		comboPanel.add(getSpellBox());
		getSpellBox().setSelectedItem(spell);
		GameObject.player.setSelectedSpell(spell);
		updatePlayerInfo();

		Object weapon = getWeaponBox().getSelectedItem();
		comboPanel.remove(getWeaponBox());
		setWeaponBox(new JComboBox(GameObject.player.getWeaponList().toArray()));
		comboPanel.add(getWeaponBox());
		getWeaponBox().setSelectedItem(weapon);
		GameObject.player.setSelectedWeapon(weapon);
		updatePlayerInfo();

		Object enemy = getEnemyBox().getSelectedItem();
		comboPanel.remove(getEnemyBox());
		setEnemyBox(new JComboBox(GameObject.player.getEntityList().toArray()));
		comboPanel.add(getEnemyBox());
		getEnemyBox().setSelectedItem(enemy);
		updatePlayerInfo();

//		if(playerStats != null) {
//			this.remove(playerStats);
//		}
//		playerStats.setFont(new Font ("sans",Font.BOLD, 16));
//		playerStats.setText(p.toString());
		
		//playerStats.setFont(new Font("sans", Font.BOLD, 32));
	}

	public void updatePlayerInfo() {
		comboPanel.remove(sp);
		sp.remove(playerStats);
		playerStats = new JLabel(GameObject.player.toString());
		sp.add(playerStats);
		
	}

	public void updateEnemyBox() {
		if (GameObject.g.player.getEntityList().size() == 0) {
			GameObject.g.player.getEntityList().add(new Blob());
		}
	}

	public JComboBox getWeaponBox() {
		return weaponBox;
	}

	public void setWeaponBox(JComboBox weaponBox) {
		this.weaponBox = weaponBox;
	}

	public JComboBox getSpellBox() {
		return spellBox;
	}

	public void setSpellBox(JComboBox spellBox) {
		this.spellBox = spellBox;
	}

	public JComboBox getEnemyBox() {
		return entityBox;
	}

	public void setEnemyBox(JComboBox enemyBox) {
		this.entityBox = enemyBox;
	}
}
