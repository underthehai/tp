package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_MISSING_INDEX;
import static seedu.address.commons.core.Messages.MESSAGE_REDUNDANT_INDEX;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.command.GoToCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new GoToCommand object.
 */
public class GoToCommandParser implements Parser<GoToCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the GoToCommand
     * and returns a GoToCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public GoToCommand parse(String args) throws ParseException {

        try {
            String[] keywords = args.split(" ");
            String directoryType = keywords[ParserUtil.OBJECT_TYPE_POSITION].substring(1);

            switch (directoryType) {
            case GoToCommand.TRAVEL_PLAN:
                if (keywords.length < 3) {
                    throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_MISSING_INDEX));
                }
                Index index = ParserUtil.parseIndex(keywords[ParserUtil.INDEX_POSITION]);
                return new GoToCommand(index, true);

            case GoToCommand.WISHLIST:
                if (keywords.length > 2) {
                    throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_REDUNDANT_INDEX));
                }
                return new GoToCommand(false);

            default:
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, GoToCommand.MESSAGE_USAGE));
            }
        } catch (ArrayIndexOutOfBoundsException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, GoToCommand.MESSAGE_USAGE), pe);
        }
    }
}
