package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.command.edit.EditCommand.INVALID_FIELDS;
import static seedu.address.logic.command.edit.EditCommand.MESSAGE_USAGE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertWanderLustParseEditCommandFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertWanderLustParseEditCommandSuccess;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.address.logic.command.edit.EditAccommodationCommand;
import seedu.address.logic.command.edit.EditActivityCommand;
import seedu.address.logic.command.edit.EditDescriptor;
import seedu.address.logic.command.edit.EditFriendCommand;
import seedu.address.logic.command.edit.EditTravelPlanCommand;
import seedu.address.model.commons.Cost;
import seedu.address.model.commons.Name;

public class EditCommandParserTest {

    private EditCommandParser parser = new EditCommandParser();

    //simple edit friend
    @Test
    public void parse_editFriend_success() {

        EditDescriptor editDescriptor = new EditDescriptor();
        editDescriptor.setName(new Name("Bobby"));
        assertWanderLustParseEditCommandSuccess(parser, " -friend 1 n/Bobby",
                new EditFriendCommand(INDEX_FIRST, editDescriptor));
    }

    @Test
    public void parse_editActivity_success() {
        EditDescriptor editDescriptor = new EditDescriptor();
        editDescriptor.setName(new Name("Ice Skating"));
        assertWanderLustParseEditCommandSuccess(parser, " -activity 1 n/Ice Skating",
                new EditActivityCommand(INDEX_FIRST, editDescriptor));
    }

    @Test
    public void parse_editAccommodation_success() {
        EditDescriptor editDescriptor = new EditDescriptor();
        editDescriptor.setName(new Name("Ice Lodge"));
        assertWanderLustParseEditCommandSuccess(parser, " -accommodation 1 n/Ice Lodge",
                new EditAccommodationCommand(INDEX_FIRST, editDescriptor));
    }

    @Test
    public void parse_editTravelPlan_success() {
        EditDescriptor editDescriptor = new EditDescriptor();
        editDescriptor.setName(new Name("Iceland"));
        assertWanderLustParseEditCommandSuccess(parser, " -travelplan 1 n/Iceland",
                new EditTravelPlanCommand(INDEX_FIRST, editDescriptor));
    }

    @Test
    public void parse_editMultipleFields_success() {
        EditDescriptor editDescriptor = new EditDescriptor();
        editDescriptor.setName(new Name("Ice Skating"));
        editDescriptor.setCost(new Cost("20"));
        assertWanderLustParseEditCommandSuccess(parser, " -activity 1 n/Ice Skating c/20",
                new EditActivityCommand(INDEX_FIRST, editDescriptor));
    }


    /** Missing Index*/
    @Test
    public void parse_MissingIndex_failure() {
        assertWanderLustParseEditCommandFailure(parser, "edit -activity i/2",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_INVALID_INDEX));
    }

    /** Edit type unspecified*/
    @Test
    public void parse_MissingEditType_failure() {
        assertWanderLustParseEditCommandFailure(parser, "edit 1 i/2",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_USAGE));
    }

    @Test
    public void parse_incorrectFieldSpecified_failure() {
        assertWanderLustParseEditCommandFailure(parser, "edit -friend 1 i/2",
                INVALID_FIELDS);
    }

}
