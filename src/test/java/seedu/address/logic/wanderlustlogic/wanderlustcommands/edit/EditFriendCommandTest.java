package seedu.address.logic.wanderlustlogic.wanderlustcommands.edit;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.model.friend.Friend;
import seedu.address.model.travelplanner.Model;
import seedu.address.model.travelplanner.ModelManager;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.builder.EditFriendDescriptorBuilder;
import seedu.address.model.travelplanner.UserPrefs;
import seedu.address.testutil.builders.FriendBuilder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandTestUtil.DESC_AMY;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandTestUtil.*;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditFriendCommand.MESSAGE_DUPLICATE_FRIEND;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditFriendCommand.MESSAGE_EDIT_FRIEND_SUCCESS;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_SECOND;
import static seedu.address.testutil.typicals.TypicalTravelPlans.getTypicalTravelPlanner;

public class EditFriendCommandTest {

    private Model model = new ModelManager(getTypicalTravelPlanner(), new UserPrefs());

    @Test
    public void execute_allFieldsSpecifiedUnfilteredList_success() {
        Friend editedFriend = new FriendBuilder().build();
        EditDescriptor descriptor = new EditFriendDescriptorBuilder(editedFriend).build();
        EditFriendCommand EditFriendCommand = new EditFriendCommand(INDEX_FIRST, descriptor);

        String expectedMessage = String.format(MESSAGE_EDIT_FRIEND_SUCCESS, editedFriend);

        ModelManager expectedModel = new ModelManager(model.getTravelPlanner(), new UserPrefs());
        expectedModel.setTravelPlanObject(model.getFilteredFriendList().get(0), editedFriend);


        assertCommandSuccess(EditFriendCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_noFieldSpecifiedUnfilteredList_success() {
        EditFriendCommand EditFriendCommand = new EditFriendCommand(INDEX_FIRST, new EditDescriptor());
        Friend editedFriend = model.getFilteredFriendList().get(INDEX_FIRST.getZeroBased());

        String expectedMessage = String.format(MESSAGE_EDIT_FRIEND_SUCCESS, editedFriend);

        ModelManager expectedModel = new ModelManager(model.getTravelPlanner(), new UserPrefs());

        assertCommandSuccess(EditFriendCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_filteredList_success() {

        Friend FriendInFilteredList = model.getFilteredFriendList().get(INDEX_FIRST.getZeroBased());
        Friend editedFriend = new FriendBuilder(FriendInFilteredList).withName(VALID_NAME_BOB).build();
        EditFriendCommand EditFriendCommand = new EditFriendCommand(INDEX_FIRST,
                new EditFriendDescriptorBuilder().withName(VALID_NAME_BOB).build());

        String expectedMessage = String.format(MESSAGE_EDIT_FRIEND_SUCCESS, editedFriend);

        ModelManager expectedModel = new ModelManager(model.getTravelPlanner(), new UserPrefs());
        expectedModel.setTravelPlanObject(model.getFilteredFriendList().get(0), editedFriend);

        assertCommandSuccess(EditFriendCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_duplicateFriendUnfilteredList_failure() {
        Friend firstFriend = model.getFilteredFriendList().get(INDEX_FIRST.getZeroBased());
        EditDescriptor descriptor = new EditFriendDescriptorBuilder(firstFriend).build();
        EditFriendCommand EditFriendCommand = new EditFriendCommand(INDEX_SECOND, descriptor);

        assertCommandFailure(EditFriendCommand, model, MESSAGE_DUPLICATE_FRIEND);
    }

    @Test
    public void execute_duplicateFriendFilteredList_failure() {

        // edit Friend in filtered list into a duplicate in address book
        Friend FriendInList = model.getFilteredFriendList().get(INDEX_SECOND.getZeroBased());
        EditFriendCommand EditFriendCommand = new EditFriendCommand(INDEX_FIRST,
                new EditFriendDescriptorBuilder(FriendInList).build());

        assertCommandFailure(EditFriendCommand, model, MESSAGE_DUPLICATE_FRIEND);
    }

    @Test
    public void execute_invalidFriendIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredFriendList().size() + 1);
        EditDescriptor descriptor = new EditFriendDescriptorBuilder().withName(VALID_NAME_BOB).build();
        EditFriendCommand EditFriendCommand = new EditFriendCommand(outOfBoundIndex, descriptor);

        assertCommandFailure(EditFriendCommand, model, Messages.MESSAGE_INVALID_FRIEND_DISPLAYED_INDEX);
    }


    @Test
    public void equals() {
        final EditFriendCommand standardCommand = new EditFriendCommand(INDEX_FIRST, DESC_AMY);

        // same values -> returns true
        EditDescriptor copyDescriptor = new EditDescriptor(DESC_AMY);
        EditFriendCommand commandWithSameValues = new EditFriendCommand(INDEX_FIRST, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new EditFriendCommand(INDEX_SECOND, DESC_AMY)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditFriendCommand(INDEX_FIRST, DESC_BOB)));
    }
}
