package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.ParserUtil.OBJECT_TYPE_POSITION;
import static seedu.address.logic.parser.ParserUtil.SORT_TYPE_POSITION;

import seedu.address.logic.command.Command;
import seedu.address.logic.command.sort.SortAccommodationCommand;
import seedu.address.logic.command.sort.SortActivityCommand;
import seedu.address.logic.command.sort.SortCommand;
import seedu.address.logic.command.sort.SortFriendCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.friend.Friend;

public class SortCommandParser implements Parser<Command> {
    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parse(String args) throws ParseException {
        try {
            String[] keywords = args.split(" ", 3);
            String travelPlanObjectType = keywords[OBJECT_TYPE_POSITION].substring(1);

            switch (travelPlanObjectType) {
            case Activity.TPO_WORD:
                if (keywords.length < 3) {
                    throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            SortActivityCommand.MESSAGE_USAGE));
                }
                return new SortActivityCommand(keywords[SORT_TYPE_POSITION]);

            case Accommodation.TPO_WORD:
                if (keywords.length < 3) {
                    throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            SortAccommodationCommand.MESSAGE_USAGE));
                }
                return new SortAccommodationCommand(keywords[SORT_TYPE_POSITION]);

            case Friend.TPO_WORD:
                if (keywords.length < 3) {
                    throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            SortFriendCommand.MESSAGE_USAGE));
                }
                return new SortFriendCommand(keywords[SORT_TYPE_POSITION]);

            default:
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }

    }
}
