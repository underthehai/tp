package seedu.address.logic.wanderlustlogic.wanderlustcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.Messages;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.exceptions.CommandException;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.friend.Friend;
import seedu.address.model.travelplanner.Model;

/**
 * Navigates and display the specified travel plan object based on user input.
 */
public class ShowCommand extends Command {
    public static final String COMMAND_WORD = "show";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Show the respective travel plan object tab identified by the keyword.\n"
            + "Parameters: travelPlanObjectType\n"
            + "Example: " + COMMAND_WORD + " -activity";

    public static final String MESSAGE_SHOW_SUCCESS = "show: %1$s";

    private final String travelPlanObjectString;

    private int travelPLanObjectType;

    /**
     * Constructor for ShowCommand.
     * @param travelPlanObjectType string of the travel plan object type.
     */
    public ShowCommand(String travelPlanObjectType) {
        travelPlanObjectString = travelPlanObjectType;
        if (travelPlanObjectString.equals(Activity.TPO_WORD)) {
            travelPLanObjectType = 0;
        } else if (travelPlanObjectString.equals(Accommodation.TPO_WORD)) {
            travelPLanObjectType = 1;
        } else if (travelPlanObjectString.equals(Friend.TPO_WORD)) {
            travelPLanObjectType = 2;
        } else {
            travelPLanObjectType = -1;
        }
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        boolean isDirectoryTravelPlan = model.isDirectoryTypeTravelPlan();

        if (!isDirectoryTravelPlan && travelPLanObjectType != 0) {
            throw new CommandException(Messages.MESSAGE_INVALID_SHOW_AT_WISHLIST);
        }

        if (travelPLanObjectType < 0) {
            throw new CommandException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ShowCommand.MESSAGE_USAGE));
        }

        return new CommandResult(String.format(MESSAGE_SHOW_SUCCESS, travelPlanObjectString), travelPLanObjectType);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ShowCommand // instanceof handles nulls
                && travelPlanObjectString.equals(((ShowCommand) other).travelPlanObjectString)) // state check
                && travelPLanObjectType == (((ShowCommand) other).travelPLanObjectType);
    }
}
