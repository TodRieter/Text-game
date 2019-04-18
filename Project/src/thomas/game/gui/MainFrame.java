package thomas.game.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	private AnswerPanel panelA = new AnswerPanel();

	public MainFrame(String title) {
		super(title);
		// set layout manager
		setLayout(new BorderLayout());

		// create Swing component
		final JTextArea textArea = new JTextArea(20, 20);
		JButton testButton = new JButton("test");
		// add Swing components to content pane
		Container c = getContentPane();
		c.add(panelA, BorderLayout.CENTER);
		c.add(textArea, BorderLayout.NORTH);
		c.add(testButton, BorderLayout.EAST);
		AnswerPanel answerPanel = new AnswerPanel();
		 
		answerPanel.addAnswerListener(new AnswerListener() {

			@Override
			public void answerEventOccured(AnswerEvent event) {
				String answer = event.getAnswer();			
				textArea.append(answer);
			}
		});
		// Add behavior
		
	}
}
