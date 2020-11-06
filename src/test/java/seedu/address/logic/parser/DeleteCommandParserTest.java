package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertWanderLustDeleteParseSuccess;
import static seedu.address.logic.parser.CommandParserTestUtil.assertWanderLustParseFailure;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.command.delete.DeleteActivityCommand;
import seedu.address.logic.command.delete.DeleteCommand;

public class DeleteCommandParserTest {

    private DeleteCommandParser parser = new DeleteCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertWanderLustDeleteParseSuccess(parser, " -activity 1", new DeleteActivityCommand(INDEX_FIRST_PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertWanderLustParseFailure(parser, " -activiti 1",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
    }
}
