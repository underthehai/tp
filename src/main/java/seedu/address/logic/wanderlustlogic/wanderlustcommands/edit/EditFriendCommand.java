package seedu.address.logic.wanderlustlogic.wanderlustcommands.edit;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_MOBILE;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_PASSPORT;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandResult;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.exceptions.CommandException;
import seedu.address.model.commons.Name;
import seedu.address.model.friend.Friend;
import seedu.address.model.friend.Mobile;
import seedu.address.model.friend.Passport;
import seedu.address.model.travelplanner.Model;

/**
 * Edits existing Friend in the address book. This command can only be used within a travel plan.
 */
public class EditFriendCommand extends EditCommand {
    public static final String COMMAND_WORD = "friend";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the friend identified by the index number used in the displayed friend list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_PASSPORT + "PASSPORT] "
            + "[" + PREFIX_MOBILE + "MOBILE_PHONE] "
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_NAME + "John "
            + PREFIX_PASSPORT + "E1234567H "
            + PREFIX_MOBILE + "81234567 ";

    public static final String MESSAGE_EDIT_FRIEND_SUCCESS = "Edited Friend: %1$s";
    public static final String MESSAGE_DUPLICATE_FRIEND = "This friend already exists in friend list.";

    private final Index targetIndex;
    private final EditDescriptor editFriendDescriptor;

    /**
     * Constructor for edit friend command
     */
    public EditFriendCommand(Index targetIndex, EditDescriptor editFriendDescriptor) {
        super(targetIndex);
        this.targetIndex = targetIndex;
        this.editFriendDescriptor = editFriendDescriptor;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Friend> lastShownList = model.getFilteredFriendList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_FRIEND_DISPLAYED_INDEX);
        }

        Friend friendToEdit = lastShownList.get(targetIndex.getZeroBased());
        Friend editedFriend = createEditedFriend(friendToEdit, editFriendDescriptor);

        if (!friendToEdit.isSameFriend(editedFriend) && lastShownList.contains(editedFriend)) {
            throw new CommandException(MESSAGE_DUPLICATE_FRIEND);
        }

        model.setTravelPlanObject(friendToEdit, editedFriend);
        return new CommandResult(String.format(MESSAGE_EDIT_FRIEND_SUCCESS, editedFriend));
    }

    /**
     * Creates and returns a {@code Friend} with the details of {@code friendToEdit}
     * edited with {@code editFriendDescriptor}.
     * Edits the name, passport, mobile phone
     */
    private static Friend createEditedFriend(Friend friendToEdit, EditDescriptor editFriendDescriptor) {
        assert friendToEdit != null;

        Name updatedName = editFriendDescriptor.getName().orElse(friendToEdit.getName());

        Passport updatedPassport = editFriendDescriptor.getPassport().orElse(friendToEdit.getPassport());
        Mobile updatedMobile = editFriendDescriptor.getMobile().orElse(friendToEdit.getMobile());

        return new Friend(updatedName, updatedPassport, updatedMobile);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EditCommand // instanceof handles nulls
                && targetIndex.equals(((EditFriendCommand) other).targetIndex)) // state check
                && editFriendDescriptor.equals(((EditFriendCommand) other).editFriendDescriptor);
    }



}
