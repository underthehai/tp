package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.ParserUtil.OBJECT_TYPE_POSITION;
import static seedu.address.logic.parser.ParserUtil.removeDash;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.command.delete.DeleteAccommodationCommand;
import seedu.address.logic.command.delete.DeleteActivityCommand;
import seedu.address.logic.command.delete.DeleteCommand;
import seedu.address.logic.command.delete.DeleteFriendCommand;
import seedu.address.logic.command.delete.DeleteTravelPlanCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        try {
            String[] keywords = args.split(" ");
            String deleteType = removeDash(keywords[OBJECT_TYPE_POSITION], DeleteCommand.MESSAGE_USAGE);
            Index index = ParserUtil.parseIndex(keywords[2]);

            switch (deleteType) {

            case DeleteActivityCommand.COMMAND_WORD:
                return new DeleteActivityCommand(index);

            case DeleteAccommodationCommand.COMMAND_WORD:
                return new DeleteAccommodationCommand(index);

            case DeleteFriendCommand.COMMAND_WORD:
                return new DeleteFriendCommand(index);

            case DeleteTravelPlanCommand.COMMAND_WORD:
                return new DeleteTravelPlanCommand(index);

            default:
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));

            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
        }
    }

}
