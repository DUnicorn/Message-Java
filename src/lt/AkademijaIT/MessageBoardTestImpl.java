package lt.AkademijaIT;

import lt.vtvpmc.java.board.AbstractMessageBoardTest;
import lt.vtvpmc.java.board.MessageBoard;

public class MessageBoardTestImpl extends AbstractMessageBoardTest {

	@Override
	protected MessageBoard getMessageBoard(MessageBoard messageBoard) {
		return new MessageBoardImpl(messageBoard);
	}
}
