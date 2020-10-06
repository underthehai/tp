package seedu.address.logic.commands.delete;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.activity.Activity;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.Model;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class DeleteActivityCommand extends DeleteCommand {
    public static final String COMMAND_WORD = "activity";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the activity identified by the index number used in the displayed travel plan list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_ACTIVITY_SUCCESS = "Deleted Activity: %1$s";

    private final Index targetIndex;

    public DeleteActivityCommand(Index targetIndex) {
        super(targetIndex);
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Activity> lastShownList = model.getFilteredActivityList();

        Directory currentDir = model.getDirectory();
        TravelPlan travelPlan = null;

        if (currentDir.isTravelPlan()) {
            travelPlan = (TravelPlan) currentDir;
        }

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ACTIVITY_DISPLAYED_INDEX);
        }

        Activity activityToDelete = lastShownList.get(targetIndex.getZeroBased());

        travelPlan.removeTravelPlanObject(activityToDelete);

        model.deleteActivityFromTravelPlan(activityToDelete, travelPlan);
        return new CommandResult(String.format(MESSAGE_DELETE_ACTIVITY_SUCCESS, activityToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteActivityCommand) other).targetIndex)); // state check
    }
}
