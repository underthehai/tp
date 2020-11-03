package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertWanderlustFindParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertWanderlustFindParseSuccess;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import seedu.address.logic.command.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.commons.NameContainsKeywordsPredicate;

public class WanderlustFindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_validArgs_returnsFindCommand() {
        List<String> keywords = Arrays.asList("foo", "bar", "baz"); //find activity

        assertWanderlustFindParseSuccess(parser, "find -activity foo bar baz",
                new FindCommand(new NameContainsKeywordsPredicate(keywords), ParserUtil.ACTIVITY_INDEX));
    }

    @Test
    public void parse_findFriend_success() {

        List<String> keywords = Arrays.asList("tom");

        assertWanderlustFindParseSuccess(parser, "find -friend tom",
                new FindCommand(new NameContainsKeywordsPredicate(keywords), ParserUtil.FRIEND_INDEX));

    }

    @Test
    public void parse_findAccommodation_success() {

        List<String> keywords = Arrays.asList("inn");

        assertWanderlustFindParseSuccess(parser, "find -accommodation inn",
                new FindCommand(new NameContainsKeywordsPredicate(keywords), ParserUtil.ACCOMMODATION_INDEX));

    }

    @Test
    public void parse_findActivity_success() {

        List<String> keywords = Arrays.asList("skating");

        assertWanderlustFindParseSuccess(parser, "find -activity skating",
                new FindCommand(new NameContainsKeywordsPredicate(keywords), ParserUtil.ACTIVITY_INDEX));

    }

    @Test
    public void parse_findMultipleKeyword_success() {

        List<String> keywords = Arrays.asList("skating", "eating");

        assertWanderlustFindParseSuccess(parser, "find -activity skating eating",
                new FindCommand(new NameContainsKeywordsPredicate(keywords), ParserUtil.ACTIVITY_INDEX));

    }

    @Test
    public void parse_findActivityMissingKeyword_failure() {
        List<String> keywords = Arrays.asList("foo", "bar", "baz");
        FindCommand validCommand = new FindCommand(new NameContainsKeywordsPredicate(keywords),
                ParserUtil.ACTIVITY_INDEX);
        try {
            Assertions.assertFalse(validCommand.equals(new FindCommandParser().parse("find -activity")));
        } catch (ParseException e) {
            System.out.println("Invalid input");
        }

    }

    /**
     * TODO: update error message
     */
    @Test
    public void parse_findMissingType_failure() {
        String missingTypeInput = "find ice";
        String expectedErrorMessage = "Invalid command format! \n" +
                "find: Finds all travel plan object whose names contain any of the specified keywords (case-insensitive) and displays them as a list with index numbers.\n" +
                "Parameters: KEYWORD [MORE_KEYWORDS]...\n" +
                "Example: \n" +
                "Finds activities in the current travel plan or wishlist using the format:\n" +
                "find -activity KEYWORD [MORE_KEYWORDS]...\n" +
                "\n" +
                "Finds accommodations in the current travel plan using the format:\n" +
                "find -accommodation KEYWORD [MORE_KEYWORDS]...\n" +
                "\n" +
                "Finds friends in the current travel plan using the format:\n" +
                "find -friend KEYWORD [MORE_KEYWORDS]...\n";

        assertWanderlustFindParseFailure(parser, missingTypeInput, expectedErrorMessage);
    }

    /**
     * TODO: update error message
     */
    @Test
    public void parse_findInvalidInputFormat_failure() {
        String invalidInput = "find activity foo bar baz"; //missing dash

        String expectedErrorMessage = "Invalid command format! \n" +
                "find: Finds all travel plan object whose names contain any of the specified keywords (case-insensitive) and displays them as a list with index numbers.\n" +
                "Parameters: KEYWORD [MORE_KEYWORDS]...\n" +
                "Example: \n" +
                "Finds activities in the current travel plan or wishlist using the format:\n" +
                "find -activity KEYWORD [MORE_KEYWORDS]...\n" +
                "\n" +
                "Finds accommodations in the current travel plan using the format:\n" +
                "find -accommodation KEYWORD [MORE_KEYWORDS]...\n" +
                "\n" +
                "Finds friends in the current travel plan using the format:\n" +
                "find -friend KEYWORD [MORE_KEYWORDS]...\n";

        assertWanderlustFindParseFailure(parser, invalidInput, expectedErrorMessage);

    }


}
