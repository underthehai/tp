package seedu.address.logic.wanderlustlogic.wanderlustcommands.edit;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.travelplanner.Model;
import seedu.address.model.travelplanner.ModelManager;
import seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.builder.EditAccommodationDescriptorBuilder;
import seedu.address.model.travelplanner.UserPrefs;
import seedu.address.testutil.builders.AccommodationBuilder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandTestUtil.DESC_INN;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandTestUtil.*;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditAccommodationCommand.MESSAGE_DUPLICATE_ACCOMMODATION;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.edit.EditAccommodationCommand.MESSAGE_EDIT_ACCOMMODATION_SUCCESS;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.typicals.TypicalIndexes.INDEX_SECOND;
import static seedu.address.testutil.typicals.TypicalTravelPlans.getTypicalTravelPlanner;

public class EditAccommodationCommandTest {

    private Model model = new ModelManager(getTypicalTravelPlanner(), new UserPrefs());

    @Test
    public void execute_allFieldsSpecifiedUnfilteredList_success() {
        Accommodation editedAccommodation = new AccommodationBuilder().build();
        EditDescriptor descriptor = new EditAccommodationDescriptorBuilder(editedAccommodation).build();
        EditAccommodationCommand EditAccommodationCommand = new EditAccommodationCommand(INDEX_FIRST, descriptor);

        String expectedMessage = String.format(MESSAGE_EDIT_ACCOMMODATION_SUCCESS, editedAccommodation);

        ModelManager expectedModel = new ModelManager(model.getTravelPlanner(), new UserPrefs());
        expectedModel.setTravelPlanObject(model.getFilteredAccommodationList().get(0), editedAccommodation);


        assertCommandSuccess(EditAccommodationCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_noFieldSpecifiedUnfilteredList_success() {
        EditAccommodationCommand EditAccommodationCommand = new EditAccommodationCommand(INDEX_FIRST, new EditDescriptor());
        Accommodation editedAccommodation = model.getFilteredAccommodationList().get(INDEX_FIRST.getZeroBased());

        String expectedMessage = String.format(MESSAGE_EDIT_ACCOMMODATION_SUCCESS, editedAccommodation);

        ModelManager expectedModel = new ModelManager(model.getTravelPlanner(), new UserPrefs());

        assertCommandSuccess(EditAccommodationCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_filteredList_success() {

        Accommodation AccommodationInFilteredList = model.getFilteredAccommodationList().get(INDEX_FIRST.getZeroBased());
        Accommodation editedAccommodation = new AccommodationBuilder(AccommodationInFilteredList).withName(VALID_NAME_INN).build();
        EditAccommodationCommand EditAccommodationCommand = new EditAccommodationCommand(INDEX_FIRST,
                new EditAccommodationDescriptorBuilder().withName(VALID_NAME_INN).build());

        String expectedMessage = String.format(MESSAGE_EDIT_ACCOMMODATION_SUCCESS, editedAccommodation);

        ModelManager expectedModel = new ModelManager(model.getTravelPlanner(), new UserPrefs());
        expectedModel.setTravelPlanObject(model.getFilteredAccommodationList().get(0), editedAccommodation);

        assertCommandSuccess(EditAccommodationCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_duplicateAccommodationUnfilteredList_failure() {
        Accommodation firstAccommodation = model.getFilteredAccommodationList().get(INDEX_FIRST.getZeroBased());
        EditDescriptor descriptor = new EditAccommodationDescriptorBuilder(firstAccommodation).build();
        EditAccommodationCommand EditAccommodationCommand = new EditAccommodationCommand(INDEX_SECOND, descriptor);

        assertCommandFailure(EditAccommodationCommand, model, MESSAGE_DUPLICATE_ACCOMMODATION);
    }

    @Test
    public void execute_duplicateAccommodationFilteredList_failure() {

        // edit Accommodation in filtered list into a duplicate in address book
        Accommodation AccommodationInList = model.getFilteredAccommodationList().get(INDEX_SECOND.getZeroBased());
        EditAccommodationCommand EditAccommodationCommand = new EditAccommodationCommand(INDEX_FIRST,
                new EditAccommodationDescriptorBuilder(AccommodationInList).build());

        assertCommandFailure(EditAccommodationCommand, model, MESSAGE_DUPLICATE_ACCOMMODATION);
    }

    @Test
    public void execute_invalidAccommodationIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredAccommodationList().size() + 1);
        EditDescriptor descriptor = new EditAccommodationDescriptorBuilder().withName(VALID_NAME_INN).build();
        EditAccommodationCommand EditAccommodationCommand = new EditAccommodationCommand(outOfBoundIndex, descriptor);

        assertCommandFailure(EditAccommodationCommand, model, Messages.MESSAGE_INVALID_ACCOMMODATION_DISPLAYED_INDEX);
    }


    @Test
    public void equals() {
        final EditAccommodationCommand standardCommand = new EditAccommodationCommand(INDEX_FIRST, DESC_INN);

        // same values -> returns true
        EditDescriptor copyDescriptor = new EditDescriptor(DESC_INN);
        EditAccommodationCommand commandWithSameValues = new EditAccommodationCommand(INDEX_FIRST, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new EditAccommodationCommand(INDEX_SECOND, DESC_INN)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditAccommodationCommand(INDEX_FIRST, DESC_HOME)));
    }
}
