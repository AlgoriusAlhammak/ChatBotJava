import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.lang.Math;

public class ChatBot extends JFrame implements KeyListener{

	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(20,50);
	JTextArea input=new JTextArea(1,50);
	JScrollPane scroll=new JScrollPane(
		dialog,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	);
	
	String[][] chatBot={
		 //standard greetings
		 {"hi", "hello", "hola", "ola", "howdy", "greetings", "hey there", "what's up", "good day", "yo"},
		 {"hi", "hello", "hey", "hi there", "hello there", "greetings!", "hey!"},
		 //question greetings
		 {"how are you", "how r you", "how r u", "how are u", "what's up", "how's it going", "how have you been?", "how are things?", "how do you do?"},
		 {"good", "doing well", "I'm fine, thanks", "great", "I'm good, how about you?", "I'm okay", "I'm fantastic", "I've been better", "not too bad"},
		 //questions about identity
		 {"what's your name?", "who are you?", "what do I call you?", "who am I talking to?", "what's your bot name?", "identify yourself", "who is this?", "what are you?"},
		 {"I'm your chatbot", "You can call me Bot", "I'm here to assist you", "I'm your virtual assistant", "I'm a chatbot designed to help you", "I'm a virtual assistant created to chat with you", "I’m your digital assistant"},
		 //yes
		 {"yes", "yep", "yeah", "sure", "definitely", "of course", "absolutely", "yup", "you bet", "affirmative"},
		 //no
		 {"no", "NO", "NO!!!!!!!", "nah", "nope", "not really", "I don't think so", "negative", "not at all", "no way"},
		 //thank you
		 {"thank you", "thanks", "thx", "thank you very much", "thanks a lot", "thanks so much", "much appreciated", "thanks a bunch", "cheers", "many thanks"},
		 {"you're welcome", "no problem", "anytime", "my pleasure", "happy to help", "no worries", "don't mention it", "glad to help", "sure thing", "you bet"},
		 //farewell
		 {"bye", "goodbye", "see you", "later", "catch you later", "see you soon", "take care", "farewell", "until next time", "peace out"},
		 {"bye", "goodbye", "see you soon", "take care", "stay safe", "later alligator", "adios", "ciao", "see ya", "so long"},
		 //apologies
		 {"sorry", "I'm sorry", "my apologies", "I apologize", "forgive me", "pardon me", "my bad", "I didn't mean to", "oops", "excuse me"},
		 {"no problem", "it's okay", "don't worry about it", "no worries", "all good", "it's fine", "no big deal", "you're forgiven", "no harm done", "all is forgiven"},
		 //thanks or appreciation
		 {"thank you", "thanks", "thx", "thanks a lot", "thanks so much", "much appreciated", "thanks a bunch", "thank you kindly", "many thanks", "gracias"},
		 {"you're welcome", "no problem", "anytime", "my pleasure", "happy to help", "no worries", "don't mention it", "glad to help", "sure thing", "you bet"},
		 //age-related questions
		 {"how old are you?", "what's your age?", "when were you created?", "how long have you been around?"},
		 {"I'm timeless", "Age is just a number", "I'm as old as the internet", "I'm perpetually young", "Bots don't age"},
		 //functionality questions
		 {"what can you do?", "what are your functions?", "how can you help me?", "what's your purpose?", "what services do you offer?", "how can I use you?"},
		 {"I can chat with you", "I can answer questions", "I can assist you with information", "I'm here to help", "I can provide support", "I can assist with various tasks", "I'm here to make your life easier"},
		 //location questions
		 {"where are you from?", "where do you live?", "where's your home?", "what's your origin?", "where are you based?", "where do you reside?"},
		 {"I live in the cloud", "I'm from the internet", "I exist in cyberspace", "My home is in the data centers", "I'm from the digital world", "I reside on servers"},
		 //purpose questions
		 {"why are you here?", "what's your purpose?", "why do you exist?", "what's your reason for being?", "what's your mission?", "why were you created?"},
		 {"I'm here to help you", "I'm here to assist", "I'm designed to chat with you", "I'm here to make your life easier", "I exist to serve you", "I'm here to provide assistance"},
		 //likes and dislikes
		 {"do you like humans?", "what do you think of people?", "do you enjoy talking to people?", "are humans your friends?"},
		 {"I enjoy chatting with everyone", "I think humans are fascinating", "Talking to people is my purpose", "Humans are interesting", "I like interacting with humans"},
		 {"do you have a favorite color?", "what's your favorite color?", "do you like blue?", "do you like red?"},
		 {"I don't have a favorite color", "Colors are beautiful", "I like all colors", "I'm impartial to colors", "Every color is unique"},
		 {"do you have hobbies?", "what do you do for fun?", "do you have any interests?", "what are your pastimes?"},
		 {"Chatting is my hobby", "I love learning new things", "I enjoy helping people", "My interest is in assisting you", "I like processing data"},
		 //jokes
		 {"tell me a joke", "do you know any jokes?", "make me laugh", "give me a funny joke"},
		 {"Why don't scientists trust atoms? Because they make up everything!", "Why did the computer go to the doctor? It had a virus!", "Why don't some fish play piano? Because you can't tuna fish!", "Why was the math book sad? It had too many problems.", "What do you call fake spaghetti? An impasta!"},
		 //confusion or unknown responses
		 {"I don't understand", "Could you rephrase that?", "I'm not sure what you mean", "Can you clarify?", "Sorry, I didn't get that", "I don't have an answer for that", "Could you explain?", "I'm confused", "Can you elaborate?", "That's beyond my knowledge"},
		 //funny remarks
		 {"You're funny", "You're making me laugh", "You're a jokester", "You have a great sense of humor", "You're quite the comedian"},
		 {"Glad you think so", "I'm here to entertain", "Laughter is the best medicine", "Humor makes the world go round", "I'm just here to make you smile"},
		 //default
		 {"shut up", "you're bad", "noob", "stop talking", "be quiet", "you're annoying", "go away", "I don't like you", "(Bot is unavailable, due to LOL)"},
		 {"That's not very nice", "Let's keep it friendly", "I'm just trying to help", "Why so rude?", "Let's stay positive"}

	};
	
	public static void main(String[] args){
		new ChatBot();
	}
	
	public ChatBot(){
		super("Chat Bot");
		setSize(600,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dialog.setEditable(false);
		input.addKeyListener(this);
	
		p.add(scroll);
		p.add(input);
		p.setBackground(new Color(101,255,201));
		add(p);
		
		setVisible(true);
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			input.setEditable(false);
			//-----grab quote-----------
			String quote = input.getText().trim();
			input.setText("");
			addText("-->You:\t" + quote);
			
			// Remove punctuation at the end
			while(quote.length() > 0 && 
				(quote.charAt(quote.length() - 1) == '!' ||
				quote.charAt(quote.length() - 1) == '.' ||
				quote.charAt(quote.length() - 1) == '?')) {
				quote = quote.substring(0, quote.length() - 1).trim();
			}
			
			byte response = 0;
			int j = 0;
			while(response == 0 && j < chatBot.length / 2){
				if(inArray(quote.toLowerCase(), chatBot[j * 2])){
					response = 2;
					int r = (int)Math.floor(Math.random() * chatBot[(j * 2) + 1].length);
					addText("\n-->Bot:\t" + chatBot[(j * 2) + 1][r]);
				}
				j++;
			}
			
			if(response == 0){
				int r = (int)Math.floor(Math.random() * chatBot[chatBot.length - 1].length);
				addText("\n-->Bot\t" + chatBot[chatBot.length - 1][r]);
			}
			
			addText("\n");
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		dialog.setText(dialog.getText()+str);
	}
	
	public boolean inArray(String in, String[] str){
		for(String s : str){
			if(s.equals(in.trim())){
				return true;
			}
		}
		return false;
	}
}