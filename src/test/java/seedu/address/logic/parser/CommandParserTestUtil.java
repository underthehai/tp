package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import seedu.address.logic.command.Command;
import seedu.address.logic.command.FindCommand;
import seedu.address.logic.command.GoToCommand;
import seedu.address.logic.command.ShowCommand;
import seedu.address.logic.command.delete.DeleteCommand;
import seedu.address.logic.command.edit.EditCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Contains helper methods for testing command parsers.
 */
public class CommandParserTestUtil {

    /**
     * Asserts that the DeleteCommand parsing of {@code userInput} by {@code parser} is successful
     * and the command created equals to {@code expectedCommand}.
     */
    public static void assertDeleteParseSuccess(DeleteCommandParser parser, String userInput,
                                                DeleteCommand expectedCommand) {
        try {
            Command command = parser.parse(userInput);
            assertEquals(expectedCommand, command);
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Invalid userInput.", pe);
        }
    }

    /**
     * Asserts that the parsing of {@code userInput} by {@code parser} is unsuccessful and the error message
     * equals to {@code expectedMessage}.
     */
    public static void assertDeleteParseFailure(DeleteCommandParser parser, String userInput,
                                                String expectedMessage) {
        try {
            parser.parse(userInput);
            throw new AssertionError("The expected ParseException was not thrown.");
        } catch (ParseException pe) {
            assertEquals(expectedMessage, pe.getMessage());
        }
    }

    /**
     * Asserts that the parsing of {@code userInput} by {@code parser} is unsuccessful and the error message
     * equals to {@code expectedMessage}.
     */
    public static void assertWanderLustDeleteParseFailure(DeleteCommandParser parser, String userInput,
                                                          String expectedMessage) {
        try {
            parser.parse(userInput);
            throw new AssertionError("The expected ParseException was not thrown.");
        } catch (seedu.address.logic.parser.exceptions.ParseException pe) {
            assertEquals(expectedMessage, pe.getMessage());
        }
    }

    /**
     * Asserts that the FindCommand parsing of {@code userInput} by {@code parser} is successful and the command created
     * equals to {@code expectedCommand}.
     */
    public static void assertFindParseSuccess(FindCommandParser parser, String userInput,
                                              FindCommand expectedCommand) {
        try {
            FindCommand command = parser.parse(userInput);
            assertEquals(expectedCommand, command);
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Invalid userInput.", pe);
        }
    }

    /**
     * Asserts that the ShowCommand parsing of {@code userInput} by {@code parser} is successful and the command created
     * equals to {@code expectedCommand}.
     */
    public static void assertShowParseSuccess(ShowCommandParser parser, String userInput,
                                              ShowCommand expectedCommand) {
        try {
            ShowCommand command = parser.parse(userInput);
            assertEquals(expectedCommand, command);
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Invalid userInput.", pe);
        }
    }

    /**
     * Asserts that the parsing an EditCommand of {@code userInput} by {@code parser} is
     * successful and the command created equals to {@code expectedCommand}.
     */
    public static void assertEditParseSuccess(EditCommandParser parser, String userInput,
                                              EditCommand expectedCommand) {
        try {
            EditCommand command = parser.parse(userInput);
            assertEquals(expectedCommand, command);
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Invalid userInput.", pe);
        }
    }

    /**
     * Asserts that the parsing of {@code userInput} by {@code parser} is unsuccessful and the error message
     * equals to {@code expectedMessage}.
     */
    public static void assertShowParseFailure(ShowCommandParser parser, String userInput,
                                                          String expectedMessage) {
        try {
            parser.parse(userInput);
            throw new AssertionError("The expected ParseException was not thrown.");
        } catch (ParseException pe) {
            assertEquals(expectedMessage, pe.getMessage());
        }
    }

    /**
     * Asserts that the parsing of an EditCommand {@code userInput} by {@code parser} is unsuccessful
     * and the error message equals to {@code expectedMessage}.
     */
    public static void assertEditParseFailure(EditCommandParser parser, String userInput,
                                              String expectedMessage) {
        try {
            parser.parse(userInput);
            throw new AssertionError("The expected ParseException was not thrown.");
        } catch (ParseException pe) {
            assertEquals(expectedMessage, pe.getMessage());
        }
    }

    /**
     * Asserts that the parsing of an GoToCommand {@code userInput} by {@code parser} is successful and the command
     * created equals to {@code expectedCommand}.
     */
    public static void assertParseGoToSuccess(GoToCommandParser parser, String userInput, GoToCommand expectedCommand) {
        try {
            GoToCommand command = parser.parse(userInput);
            assertEquals(expectedCommand, command);
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Invalid userInput.", pe);
        }
    }

    /**
     * Asserts that the parsing of {@code userInput} by {@code parser} is unsuccessful and the error message equals to
     * {@code expectedMessage}.
     */
    public static void assertParseGoToFailure(GoToCommandParser parser, String userInput, String expectedMessage) {
        try {
            parser.parse(userInput);
            throw new AssertionError("The expected ParseException was not thrown.");
        } catch (ParseException pe) {
            assertEquals(expectedMessage, pe.getMessage());
        }
    }

}
