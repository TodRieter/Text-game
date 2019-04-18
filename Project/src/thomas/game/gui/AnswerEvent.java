package thomas.game.gui;

import java.util.EventObject;

public class AnswerEvent extends EventObject{
	private String answer;
	public AnswerEvent(Object source, String answer) {
		super(source);
		
		this.answer = answer;
	}
public String getAnswer(){
	return answer;
}
}
