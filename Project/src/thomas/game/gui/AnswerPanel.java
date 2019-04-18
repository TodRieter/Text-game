package thomas.game.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import thomas.game.GameObject;

public class AnswerPanel extends JPanel {
	
	private EventListenerList listenerList = new EventListenerList();

	public AnswerPanel() {
		Dimension size = getPreferredSize();
		size.width = 700;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("Player"));

		JButton yesButton = new JButton("yes");
		JButton noButton = new JButton("no");

		yesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String answer = "yes";
				fireAnswerEvent(new AnswerEvent(this, answer));

			}
		});
		noButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String answer = "no";
				fireAnswerEvent(new AnswerEvent(this, answer));

			}
		});

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		/*
		 * Button Layout
		 */
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;

		add(yesButton, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;

		gbc.gridx = 1;
		gbc.gridy = 0;

		add(noButton, gbc);
	}
	
	public void fireAnswerEvent(AnswerEvent event) {
		Object[] listeners = listenerList.getListenerList();
		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == AnswerListener.class){
				((AnswerListener)listeners[i++]).answerEventOccured(event);
			}
		}
	}

	public void addAnswerListener(AnswerListener listener) {

		listenerList.add(AnswerListener.class, listener);
	}

	public void removeAnswerListener(AnswerListener listener) {

		listenerList.remove(AnswerListener.class, listener);

	}
}
