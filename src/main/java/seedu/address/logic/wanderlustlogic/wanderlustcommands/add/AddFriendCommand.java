package seedu.address.logic.wanderlustlogic.wanderlustcommands.add;


import static java.util.Objects.requireNonNull;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_MOBILE;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_PASSPORT;

import seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandResult;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.exceptions.CommandException;
import seedu.address.model.friend.Friend;
import seedu.address.model.travelplanner.Model;

public class AddFriendCommand extends AddCommand {
    public static final String COMMAND_WORD = "friend";

    public static final String MESSAGE_USAGE = AddCommand.COMMAND_WORD + " " + COMMAND_WORD
            + ": Adds a friend to the current travel plan or wishlist\n"
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_MOBILE + "MOBILE_NUMBER "
            + PREFIX_PASSPORT + "PASSPORT_NUMBER "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_MOBILE + "91234567 "
            + PREFIX_PASSPORT + "p12345678 ";

    public static final String MESSAGE_SUCCESS = "New friend added: %1$s";
    public static final String MESSAGE_DUPLICATE_ACTIVITY = "This friend already exists in the travel plan";

    private final Friend toAdd;

    /**
     * Creates an AddActivityCommand to add the specified {@code Activity}
     */
    public AddFriendCommand(Friend friend) {
        requireNonNull(friend);
        toAdd = friend;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasTravelPlanObject(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_ACTIVITY);
        }

        model.addTravelPlanObject(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddFriendCommand // instanceof handles nulls
                && toAdd.equals(((AddFriendCommand) other).toAdd));
    }
}
