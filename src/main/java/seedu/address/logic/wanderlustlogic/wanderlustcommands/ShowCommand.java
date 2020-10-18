package seedu.address.logic.wanderlustlogic.wanderlustcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.Messages;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.exceptions.CommandException;
import seedu.address.model.travelplanner.Model;

public class ShowCommand extends Command {
    public static final String COMMAND_WORD = "show";
    public static final String ACTIVITY = "activity";
    public static final String ACCOMMODATION = "accommodation";
    public static final String FRIEND = "friend";

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
        if (travelPlanObjectString.equals(ACTIVITY)) {
            travelPLanObjectType = 0;
        } else if (travelPlanObjectString.equals(ACCOMMODATION)) {
            travelPLanObjectType = 1;
        } else if (travelPlanObjectString.equals(FRIEND)) {
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
                || (other instanceof GoToCommand // instanceof handles nulls
                && travelPlanObjectString.equals(((ShowCommand) other).travelPlanObjectString)) // state check
                && travelPLanObjectType == (((ShowCommand) other).travelPLanObjectType);
    }
}
