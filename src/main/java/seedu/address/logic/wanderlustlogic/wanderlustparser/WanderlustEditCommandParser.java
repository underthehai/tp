package seedu.address.logic.wanderlustlogic.wanderlustparser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_COST;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_DATETIME;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_END;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_IMPORTANCE;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_PASSPORT;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_START;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditAccommodationCommand;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditActivityCommand;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditCommand;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditDescriptor;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditFriendCommand;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditTravelPlanCommand;
import seedu.address.logic.wanderlustlogic.wanderlustparser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class WanderlustEditCommandParser implements WanderlustParserInterface<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_IMPORTANCE, PREFIX_COST,
                        PREFIX_PHONE, PREFIX_LOCATION, PREFIX_PASSPORT, PREFIX_START, PREFIX_END, PREFIX_DATETIME);

        try {

            String[] keywords = args.split(" ");
            String editType = keywords[1].substring(1);
            Index index = ParserUtil.parseIndex(keywords[2]);

            EditDescriptor editDescriptor = EditDescriptor.buildFromSource(argMultimap);


            switch (editType) {

            case EditActivityCommand.COMMAND_WORD:
                return new EditActivityCommand(index, editDescriptor);

            case EditAccommodationCommand.COMMAND_WORD:
                return new EditAccommodationCommand(index, editDescriptor);

            case EditFriendCommand.COMMAND_WORD:
                return new EditFriendCommand(index, editDescriptor);

            case EditTravelPlanCommand.COMMAND_WORD:
                return new EditTravelPlanCommand(index, editDescriptor);

            default:
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));

            }
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE), pe);
        }


    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>} if {@code tags} is non-empty.
     * If {@code tags} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<Tag>} containing zero tags.
     */
    private Optional<Set<Tag>> parseTagsForEdit(Collection<String> tags) throws ParseException {
        assert tags != null;

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> tagSet = tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
        return Optional.of(ParserUtil.parseTags(tagSet));
    }

}
