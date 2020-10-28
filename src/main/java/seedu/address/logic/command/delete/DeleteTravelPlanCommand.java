package seedu.address.logic.command.delete;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TPO;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.command.CommandResult;
import seedu.address.logic.command.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.travelplan.TravelPlan;

/**
 * Deletes a travel plan in the travel planner identified using the index from the travel planner list.
 */
public class DeleteTravelPlanCommand extends DeleteCommand {
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the travel plan identified by the index number used in the displayed travel plan list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_TPO + TravelPlan.TRAVEL_PLAN_WORD + " 1";

    public static final String MESSAGE_DELETE_TRAVELPLAN_SUCCESS = "Deleted Travel Plan:\n%1$s";

    private final Index targetIndex;

    /**
     * Constructor for delete travel plan command.
     * @param targetIndex index to be deleted.
     */
    public DeleteTravelPlanCommand(Index targetIndex) {
        super(targetIndex);
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<TravelPlan> filteredTravelPlanList = model.getFilteredTravelPlanList();

        if (targetIndex.getZeroBased() >= filteredTravelPlanList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TRAVELPLAN_DISPLAYED_INDEX);
        }

        TravelPlan travelPlanToDelete = filteredTravelPlanList.get(targetIndex.getZeroBased());
        model.deleteTravelPlan(travelPlanToDelete);
        assert !model.getTravelPlanList().contains(travelPlanToDelete)
                : "Travel plan was not deleted!";
        return new CommandResult(String.format(MESSAGE_DELETE_TRAVELPLAN_SUCCESS, travelPlanToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteTravelPlanCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteTravelPlanCommand) other).targetIndex)); // state check
    }
}
