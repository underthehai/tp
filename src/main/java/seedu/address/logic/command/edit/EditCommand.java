package seedu.address.logic.command.edit;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.command.Command;
import seedu.address.logic.command.CommandResult;
import seedu.address.logic.command.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Edits a person identified using it's displayed index from the address book.
 */
public abstract class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String SPECIFY_INDEX = "Please Specify the index";
    public static final String MESSAGE_WRONG_DIRECTORY = "Please go to a travelplan directory to use this command";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " with optional fields\n"
            + EditTravelPlanCommand.MESSAGE_FORMAT + "\n"
            + EditActivityCommand.MESSAGE_FORMAT + "\n"
            + EditAccommodationCommand.MESSAGE_FORMAT + "\n"
            + EditFriendCommand.MESSAGE_FORMAT;


    protected final Index targetIndex;

    public EditCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public abstract CommandResult execute(Model model) throws CommandException;

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EditCommand // instanceof handles nulls
                && targetIndex.equals(((EditCommand) other).targetIndex)); // state check
    }
}
