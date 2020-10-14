package seedu.address.logic.wanderlustlogic.wanderlustparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.WanderlustCommandParserTestUtil.assertWanderLustParseEditCommandFailure;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.WanderlustCommandParserTestUtil.assertWanderLustParseEditCommandSuccess;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditActivityCommand;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditDescriptor;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditFriendCommand;
import seedu.address.model.commons.Name;

public class WanderlustEditCommandParserTest {

    private WanderlustEditCommandParser parser = new WanderlustEditCommandParser();

    //Parse EditFriend
    @Test
    public void parse_validArgs_returnsEditCommand() {

        EditDescriptor editDescriptor = new EditDescriptor();
        editDescriptor.setName(new Name("Bobby"));
        assertWanderLustParseEditCommandSuccess(parser, " -friend 1 n/Bobby",
                new EditFriendCommand(INDEX_FIRST, editDescriptor));
    }

    //Parse EditActivity
    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertWanderLustParseEditCommandFailure(parser, " -activity a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditActivityCommand.MESSAGE_USAGE));
    }
}
