package seedu.address.logic.wanderlustlogic.wanderlustcommands;

import seedu.address.logic.wanderlustlogic.wanderlustcommands.exceptions.CommandException;
import seedu.address.model.travelplanner.Model;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {

    public static final String MESSAGE_MISSING_TYPE = "Please specify the WanderLust object \n"
            + "COMMAND_WORD -accommodation\n"
            + "COMMAND_WORD -activity\n"
            + "COMMAND_WORD -friend\n"
            + "COMMAND_WORD -travelplan\n";

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    public abstract CommandResult execute(Model model) throws CommandException;

}
