package seedu.address.logic.wanderlustlogic.wanderlustparser;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.Command;

/**
 * Represents a Parser that is able to parse user input into a {@code Command} of type {@code T}.
 */
public interface WanderlustParserInterface<T extends Command> {

    /**
     * Parses {@code userInput} into a command and returns it.
     * @throws ParseException if {@code userInput} does not conform the expected format
     */
    T parse(String userInput) throws ParseException;
}
