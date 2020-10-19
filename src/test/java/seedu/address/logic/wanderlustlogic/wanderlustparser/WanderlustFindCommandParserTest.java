package seedu.address.logic.wanderlustlogic.wanderlustparser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertWanderLustFindParseSuccess;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.logic.wanderlustlogic.wanderlustcommands.FindCommand;
import seedu.address.model.commons.NameContainsKeywordsPredicate;

public class WanderlustFindCommandParserTest {

    private WanderlustFindCommandParser parser = new WanderlustFindCommandParser();

    @Test
    public void parse_validArgs_returnsFindCommand() {
        List<String> keywords = Arrays.asList("foo", "bar", "baz"); //find activity

        assertWanderLustFindParseSuccess(parser, "find -activity foo bar baz",
                new FindCommand(new NameContainsKeywordsPredicate(keywords), 0));
    }

}
