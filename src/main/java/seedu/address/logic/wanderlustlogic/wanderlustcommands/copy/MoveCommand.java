package seedu.address.logic.wanderlustlogic.wanderlustcommands.copy;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.Command;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandResult;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.exceptions.CommandException;
import seedu.address.model.activity.Activity;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.Model;


public class MoveCommand extends Command {
    public static final String COMMAND_WORD = "move";

    public static final String MESSAGE_USAGE =
            "move: Moves the activity identified by the index number used in the wish list to the travel plan "
                    + "identified by the index number used in the travel planner.\n"
                    + "After moving, the activity will be deleted from the wish list."
                    + "Parameters: INDEX (must be a positive integer)\n";

    public static final String MESSAGE_MOVE_ACTIVITY_SUCCESS = "Moved activity %1$s to travel plan %1$s";
    public static final String MESSAGE_NOT_WISHLIST = "Please goto wish list before moving activities";

    private final Index activityIndex;
    private final Index travelPlanIndex;

    /**
     * Constructor for MoveCommand.
     *
     * @param activityIndex index of activity to be moved.
     * @param travelPlanIndex index of travel plan to add activity to.
     */
    public MoveCommand(Index targetIndex, Index travelPlanIndex) {
        this.activityIndex = targetIndex;
        this.travelPlanIndex = travelPlanIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        boolean isTravelPlan = model.isDirectoryTypeTravelPlan();
        if (!isTravelPlan) {
            List<Activity> filteredActivityList = model.getFilteredActivityList();
            List<TravelPlan> travelPlanList = model.getFilteredTravelPlanList();

            if (activityIndex.getZeroBased() >= filteredActivityList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_ACTIVITY_DISPLAYED_INDEX);
            }

            Activity activityToMove = filteredActivityList.get(activityIndex.getZeroBased());
            TravelPlan travelPlan = travelPlanList.get(travelPlanIndex.getZeroBased());

            travelPlan.addTravelPlanObject(activityToMove);
            model.deleteActivity(activityToMove);

            return new CommandResult(String.format(MESSAGE_MOVE_ACTIVITY_SUCCESS, activityToMove, travelPlan));
        } else {
            throw new CommandException(MESSAGE_NOT_WISHLIST);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CopyCommand // instanceof handles nulls
                && activityIndex.equals(((MoveCommand) other).activityIndex)
                && travelPlanIndex.equals(((MoveCommand) other).travelPlanIndex)); // state check
    }
}
