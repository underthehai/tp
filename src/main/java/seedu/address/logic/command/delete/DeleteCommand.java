package seedu.address.logic.command.delete;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TPO;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.command.Command;
import seedu.address.logic.command.CommandResult;
import seedu.address.logic.command.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.activity.Activity;
import seedu.address.model.travelplan.TravelPlan;

/**
 * Deletes a travel plan object identified using it's displayed index from the travel plans.
 */
public abstract class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final int COMMAND_TOKENS = 3;

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the object identified by the index number used in the displayed object list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_TPO + Activity.TPO_WORD + " 1\n"
            + "         " + COMMAND_WORD + " " + PREFIX_TPO + TravelPlan.TRAVEL_PLAN_WORD + " 1";

    protected final Index targetIndex;

    public DeleteCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public abstract CommandResult execute(Model model) throws CommandException;

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteCommand) other).targetIndex)); // state check
    }
}
