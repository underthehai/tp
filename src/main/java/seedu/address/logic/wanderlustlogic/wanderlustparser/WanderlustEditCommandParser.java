package seedu.address.logic.wanderlustlogic.wanderlustparser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_COST;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_DATETIME;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_END;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_IMPORTANCE;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_MOBILE;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_PASSPORT;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_START;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditAccommodationCommand;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditActivityCommand;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditCommand;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditDescriptor;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditFriendCommand;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditTravelPlanCommand;
import seedu.address.logic.wanderlustlogic.wanderlustparser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class WanderlustEditCommandParser implements WanderlustParserInterface<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);


        try {
            String[] keywords = args.split(" ");
            String editType = keywords[1].substring(1);
            Index index = ParserUtil.parseIndex(keywords[2]);

            switch (editType) {

            case EditActivityCommand.COMMAND_WORD:
                return parseActivity(index, args);

            case EditAccommodationCommand.COMMAND_WORD:
                return parseAccommodation(index, args);

            case EditFriendCommand.COMMAND_WORD:
                return parseFriend(index, args);

            case EditTravelPlanCommand.COMMAND_WORD:
                return parseTravelPlan(index, args);

            default:
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));

            }
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE), pe);
        }


    }

    EditActivityCommand parseActivity(Index index, String args) throws ParseException {
        try {
            ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_IMPORTANCE, PREFIX_COST,
                    PREFIX_LOCATION, PREFIX_DATETIME);
            EditDescriptor editDescriptor = EditDescriptor.buildFromSource(argMultimap);

            return new EditActivityCommand(index, editDescriptor);
        } catch (ParseException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditActivityCommand.MESSAGE_USAGE));
        }
    }

    EditAccommodationCommand parseAccommodation(Index index, String args) throws ParseException {
        try {
            ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_COST, PREFIX_LOCATION,
                    PREFIX_START, PREFIX_END);
            EditDescriptor editDescriptor = EditDescriptor.buildFromSource(argMultimap);

            return new EditAccommodationCommand(index, editDescriptor);
        } catch (ParseException e) {
            throw new ParseException((String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    EditAccommodationCommand.MESSAGE_USAGE)));
        }
    }

    EditFriendCommand parseFriend(Index index, String args) throws ParseException {
        try {
            ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PASSPORT,
                    PREFIX_MOBILE);
            EditDescriptor editDescriptor = EditDescriptor.buildFromSource(argumentMultimap);

            return new EditFriendCommand(index, editDescriptor);
        } catch (ParseException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditFriendCommand.MESSAGE_USAGE));
        }
    }

    EditTravelPlanCommand parseTravelPlan(Index index, String args) throws ParseException {
        try {
            ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_START, PREFIX_END);
            EditDescriptor editDescriptor = EditDescriptor.buildFromSource(argMultimap);

            return new EditTravelPlanCommand(index, editDescriptor);
        } catch (ParseException e) {
            throw new ParseException((String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditTravelPlanCommand.MESSAGE_USAGE)));
        }
    }


}
