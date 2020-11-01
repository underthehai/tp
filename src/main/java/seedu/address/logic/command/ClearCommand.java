package seedu.address.logic.command;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;
import seedu.address.model.TravelPlanner;
import seedu.address.model.commons.Name;
import seedu.address.model.commons.WanderlustDate;
import seedu.address.model.travelplan.TravelPlan;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setTravelPlanner(new TravelPlanner(null));
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
