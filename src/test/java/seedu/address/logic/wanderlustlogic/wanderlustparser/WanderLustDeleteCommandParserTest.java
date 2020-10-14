package seedu.address.logic.wanderlustlogic.wanderlustparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertWanderLustParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertWanderLustParseSuccess;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.wanderlustlogic.wanderlustcommands.delete.DeleteActivityCommand;


/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class WanderLustDeleteCommandParserTest {

    private WanderlustDeleteCommandParser parser = new WanderlustDeleteCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertWanderLustParseSuccess(parser, " -activity 1 ", new DeleteActivityCommand(INDEX_FIRST_PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertWanderLustParseFailure(parser, " -activity a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteActivityCommand.MESSAGE_USAGE));
    }
}