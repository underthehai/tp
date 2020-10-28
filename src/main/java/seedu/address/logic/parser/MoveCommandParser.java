package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.command.copy.MoveCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new MoveCommand object
 */
public class MoveCommandParser implements Parser<MoveCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the MoveCommand
     * and returns a MoveCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public MoveCommand parse(String args) throws ParseException {
        try {
            String[] keywords = args.split(" ");
            Index activityIndex = ParserUtil.parseIndex(keywords[1]);
            Index travelPlanIndex = ParserUtil.parseIndex(keywords[2]);

            return new MoveCommand(activityIndex, travelPlanIndex);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, MoveCommand.MESSAGE_USAGE), pe);
        }
    }

}
