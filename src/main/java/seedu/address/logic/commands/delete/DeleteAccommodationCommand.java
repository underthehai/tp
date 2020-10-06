package seedu.address.logic.commands.delete;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.Model;
import seedu.address.model.accommodation.Accommodation;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class DeleteAccommodationCommand extends DeleteCommand {
    public static final String COMMAND_WORD = "accommodation";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the accommodation identified by the index number used in the displayed accommodation list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_ACCOMMODATION_SUCCESS = "Deleted Accommodation: %1$s";

    private final Index targetIndex;

    public DeleteAccommodationCommand(Index targetIndex) {
        super(targetIndex);
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Accommodation> lastShownList = model.getFilteredAccommodationList();

        Directory currentDir = model.getDirectory();
        TravelPlan travelPlan = null;

        if (currentDir.isTravelPlan()) {
            travelPlan = (TravelPlan) currentDir;
        }

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ACCOMMODATION_DISPLAYED_INDEX);
        }

        Accommodation accommodationToDelete = lastShownList.get(targetIndex.getZeroBased());

        travelPlan.removeTravelPlanObject(accommodationToDelete);

        model.deleteAccommodation(accommodationToDelete, travelPlan);
        return new CommandResult(String.format(MESSAGE_DELETE_ACCOMMODATION_SUCCESS, accommodationToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteCommand) other).targetIndex)); // state check
    }
}
