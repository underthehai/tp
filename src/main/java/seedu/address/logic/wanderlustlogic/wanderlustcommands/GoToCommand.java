package seedu.address.logic.wanderlustlogic.wanderlustcommands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.exceptions.CommandException;
import seedu.address.model.activity.Activity;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.Model;


public class GoToCommand extends Command {
    public static final String COMMAND_WORD = "goto";
    public static final String TRAVEL_PLAN = "travelplan";
    public static final String WISHLIST = "wishlist";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Go to the directory identified by the index number used in the displayed travel plan list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: -" + COMMAND_WORD + " 1";

    public static final String MESSAGE_GOTO_SUCCESS = "goto directory: %1$s";

    private final Index targetIndex;
    private final boolean isTravelPlan;

    /**
     * Constructor for GoToCommand.
     * @param targetIndex index of travelplan to goto.
     */
    public GoToCommand(Index targetIndex, boolean isTravelPlan) {
        this.targetIndex = targetIndex;
        this.isTravelPlan = isTravelPlan;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (isTravelPlan) {
            List<TravelPlan> lastShownList = model.getFilteredTravelPlanList();

            if (targetIndex.getZeroBased() >= lastShownList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_TRAVELPLAN_DISPLAYED_INDEX);
            }

            TravelPlan travelPlanToGo = lastShownList.get(targetIndex.getZeroBased());
            model.setDirectory(targetIndex.getZeroBased(), true);
            return new CommandResult(String.format(MESSAGE_GOTO_SUCCESS, TRAVEL_PLAN + " " + travelPlanToGo.getName()));
        } else {
            List<Activity> wishlistToGo = model.getFilteredWishlist();
            model.setDirectory(targetIndex.getZeroBased(), false);
            return new CommandResult(String.format(MESSAGE_GOTO_SUCCESS, WISHLIST));
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof GoToCommand // instanceof handles nulls
                && targetIndex.equals(((GoToCommand) other).targetIndex)); // state check
    }
}
