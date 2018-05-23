package lt.AkademijaIT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lt.vtvpmc.java.board.Message;
import lt.vtvpmc.java.board.MessageBoard;

public class MessageBoardImpl implements MessageBoard {

	List<Message> messages = new ArrayList<>();

	MessageBoard messageBoard;

	private final String[] alcoholNames = { "Jack Daniel's", "Jameson", "Red Label" };
	
	private final String[] swearWords = { "Weed", "Jameson", "Red Label" };
	public MessageBoardImpl(MessageBoard messageBoard) {
		super();
		this.messageBoard = messageBoard;
	}

	@Override
	public int countMessages() {
		return messages.size();
	}

	@Override
	public Collection<Message> findAllMessages() {
		return messages;
	}

	@Override
	public Collection<Message> findMessagesBy(String author) {
		return messages.stream().filter(m -> m.getAuthor().equals(author)).collect(Collectors.toList());
	}

	@Override
	public void postMessage(Message message) {

		String newBody = "";

		String messageContent = message.getBody();
		boolean containsAlcohol = false;

		for (String alc : alcoholNames) {
			if (messageContent.contains(alc)) {
				containsAlcohol = true;
				break;
			}
		}
		if (containsAlcohol == false && !message.getAuthor().equals("John Smith")) {
			newBody = messageContent.replace("weed", "***");
			newBody = newBody.replace("alcohol", "***");
			newBody = newBody.replace("booze", "***");
			messages.add(new Message(message.getAuthor(), newBody));

		}else if (message.getAuthor().equals("John Smith") && findMessagesBy(message.getAuthor()).size() < 1) {
            messages.add(new Message("John Smith", "Nothing to see here."));

	}
	}
}
