package seedu.address.logic.commands.edit;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSPORT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MOBILE;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.commons.Name;
import seedu.address.model.friend.Passport;
import seedu.address.model.friend.Phone;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.Model;
import seedu.address.model.friend.Friend;

/**
 * Edits existing Friend in the address book. This command can only be used within a travel plan.
 * n m p
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
            + PREFIX_NAME + "John"
            + PREFIX_PASSPORT + "E1234567H"
            + PREFIX_MOBILE + "81234567";

    public static final String MESSAGE_EDIT_FRIEND_SUCCESS = "Edited Friend: %1$s";
    public static final String MESSAGE_DUPLICATE_FRIEND = "This friend already exists in friend list.";

    private final Index targetIndex;
    private final EditFriendDescriptor editFriendDescriptor;

    public EditFriendCommand(Index targetIndex, EditFriendDescriptor editFriendDescriptor) {
        super(targetIndex);
        this.targetIndex = targetIndex;
        this.editFriendDescriptor = editFriendDescriptor;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Friend> lastShownList = model.getFilteredFriendList();

        //Directory class in model (TBD)
        Directory currentDir = model.getDirectory();
        TravelPlan travelPlan = null;

        if (currentDir.isTravelPlan()) {
            travelPlan = (TravelPlan) currentDir;
        }

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ACTIVITY_DISPLAYED_INDEX);
        }

        Friend friendToEdit = lastShownList.get(targetIndex.getZeroBased());
        Friend editedFriend = createEditedFriend(friendToEdit, editFriendDescriptor);

        if (!friendToEdit.isSameFriend(editedFriend) && lastShownList.contains(editedFriend)) {
            throw new CommandException(MESSAGE_DUPLICATE_FRIEND);
        }

        model.setFriend(friendToEdit, editedFriend, travelPlan);
        return new CommandResult(String.format(MESSAGE_EDIT_FRIEND_SUCCESS, editedFriend));
    }

    /**
     * Creates and returns a {@code Friend} with the details of {@code friendToEdit}
     * edited with {@code editFriendDescriptor}.
     * Edits the name, passport, mobile phone
     */
    private static Friend createEditedFriend(Friend friendToEdit, EditFriendDescriptor editFriendDescriptor) {
        assert friendToEdit != null;

        Name updatedName = editFriendDescriptor.getName().orElse(friendToEdit.getName());

        Passport updatedPassport = editFriendDescriptor.getPassport().orElse(friendToEdit.getPassport());
        Phone updatedMobile = editFriendDescriptor.getPhone().orElse(friendToEdit.getPhone());

        return new Friend(updatedName, updatedPassport, updatedMobile);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EditCommand // instanceof handles nulls
                && targetIndex.equals(((EditFriendCommand) other).targetIndex)); // state check
    }

    /**
     * Stores the details to edit the friend with. Each non-empty field value will replace the
     * corresponding field value of the friend.
     */
    public static class EditFriendDescriptor {

        private Name name;
        private Passport passport;
        private Phone phone;


        public EditFriendDescriptor() {
        }

        /**
         * Copy constructor.
         */
        public EditFriendDescriptor(EditFriendDescriptor toCopy) {
            setName(toCopy.name);
            setPassport(toCopy.passport);
            setPhone(toCopy.phone);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, passport, phone);
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        public void setPassport(Passport passport) {
            this.passport = passport;
        }

        public Optional<Passport> getPassport() {
            return Optional.ofNullable(passport);
        }

        public void setPhone(Phone phone) {
            this.phone = phone;
        }

        public Optional<Phone> getPhone() {
            return Optional.ofNullable(phone);
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditFriendDescriptor)) {
                return false;
            }

            // state check
            EditFriendDescriptor e = (EditFriendDescriptor) other;

            return getName().equals(e.getName())
                    && getPassport().equals(e.getPassport())
                    && getPhone().equals(e.getPhone());
        }
    }


}
