package seedu.address.logic.wanderlustlogic.wanderlustparser;

import seedu.address.logic.commands.Command;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.delete.DeleteActivityCommand;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditCommand;
import seedu.address.logic.wanderlustlogic.wanderlustparser.WanderlustDeleteCommandParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Contains helper methods for testing command parsers.
 */
public class WanderlustCommandParserTestUtil {

    /**
     * Asserts that the parsing of {@code userInput} by {@code parser} is successful and the command created
     * equals to {@code expectedCommand}.
     */
    public static void assertWanderLustParseSuccess(WanderlustDeleteCommandParser parser, String userInput,
                                                    DeleteActivityCommand expectedCommand) {
        try {
            seedu.address.logic.wanderlustlogic.wanderlustcommands.Command command = parser.parse(userInput);
            assertEquals(expectedCommand, command);
        } catch (seedu.address.logic.wanderlustlogic.wanderlustparser.exceptions.ParseException pe) {
            throw new IllegalArgumentException("Invalid userInput.", pe);
        }
    }

    /**
     * Asserts that the parsing of {@code userInput} by {@code parser} is unsuccessful and the error message
     * equals to {@code expectedMessage}.
     @@ -35,4 +51,18 @@ public static void assertParseFailure(Parser parser, String userInput, String ex
     assertEquals(expectedMessage, pe.getMessage());
     }
     }

     /**
      * Asserts that the parsing of {@code userInput} by {@code parser} is unsuccessful and the error message
      * equals to {@code expectedMessage}.
     */
    public static void assertWanderLustParseFailure(WanderlustDeleteCommandParser parser, String userInput,
                                                    String expectedMessage) {
        try {
            parser.parse(userInput);
            throw new AssertionError("The expected ParseException was not thrown.");
        } catch (seedu.address.logic.wanderlustlogic.wanderlustparser.exceptions.ParseException pe) {
            assertEquals(expectedMessage, pe.getMessage());
        }
    }

    /**
     * Asserts that the parsing an EditCommand of {@code userInput} by {@code parser} is successful and the command created
     * equals to {@code expectedCommand}.
     */
    public static void assertWanderLustParseEditCommandSuccess(WanderlustEditCommandParser parser, String userInput,
                                                    EditCommand expectedCommand) {
        try {
            EditCommand command = parser.parse(userInput);
            assertEquals(expectedCommand, command);
        } catch (seedu.address.logic.wanderlustlogic.wanderlustparser.exceptions.ParseException pe) {
            throw new IllegalArgumentException("Invalid userInput.", pe);
        }
    }

    /**
     * Asserts that the parsing of {@code userInput} by {@code parser} is unsuccessful and the error message
     * equals to {@code expectedMessage}.
     @@ -35,4 +51,18 @@ public static void assertParseFailure(Parser parser, String userInput, String ex
     assertEquals(expectedMessage, pe.getMessage());
     }
     }

     /**
      * Asserts that the parsing of an EditCommand {@code userInput} by {@code parser} is unsuccessful and the error message
      * equals to {@code expectedMessage}.
     */
    public static void assertWanderLustParseEditCommandFailure(WanderlustEditCommandParser parser, String userInput,
                                                    String expectedMessage) {
        try {
            parser.parse(userInput);
            throw new AssertionError("The expected ParseException was not thrown.");
        } catch (seedu.address.logic.wanderlustlogic.wanderlustparser.exceptions.ParseException pe) {
            assertEquals(expectedMessage, pe.getMessage());
        }
    }


}