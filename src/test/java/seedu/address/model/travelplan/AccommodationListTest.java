package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.accommodation.exceptions.DuplicateAccommodationException;
import seedu.address.model.travelplan.AccommodationList;
import seedu.address.model.travelplan.ReadOnlyAccommodationList;

public class AccommodationListTest {

    /**
     * NOT DONE: WAITING FOR AccommodationBuilder, TypicalAccommodations, CommandTestUtil TO BE UPDATED.
     * Once updated, check to see if "Identity" tests make sense.
     */

    private final AccommodationList accommodationList = new AccommodationList();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), accommodationList.getAccommodationList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> accommodationList.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAccommodationList_replacesData() {
        AccommodationList newData = getTypicalAccommodationList();
        accommodationList.resetData(newData);
        assertEquals(newData, accommodationList);
    }

    @Test
    public void resetData_withDuplicateAccommodations_throwsDuplicateAccommodationException() {
        // Two accommodations with the same identity fields
        Accommodation editedAlice = new AccommodationBuilder(ALICE).withCost(VALID_COST_BOB)
                .build();
        List<Accommodation> newAccommodations = Arrays.asList(ALICE, editedAlice);
        AccommodationListStub newData = new AccommodationListStub(newAccommodations);

        assertThrows(DuplicateAccommodationException.class, () -> accommodationList.resetData(newData));
    }

    @Test
    public void hasAccommodation_nullAccommodation_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> accommodationList.hasAccommodation(null));
    }

    @Test
    public void hasAccommodation_accommodationNotInAccommodationList_returnsFalse() {
        assertFalse(accommodationList.hasAccommodation(ALICE));
    }

    @Test
    public void hasAccommodation_accommodationInAccommodationList_returnsTrue() {
        accommodationList.addAccommodation(ALICE);
        assertTrue(accommodationList.hasAccommodation(ALICE));
    }

    @Test
    public void hasAccommodation_accommodationWithSameIdentityFieldsInAccommodationList_returnsTrue() {
        accommodationList.addAccommodation(ALICE);
        Accommodation editedAlice = new AccommodationBuilder(ALICE).withCost(VALID_COST_BOB)
                .build();
        assertTrue(accommodationList.hasAccommodation(editedAlice));
    }

    @Test
    public void getAccommodationList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> accommodationList.getAccommodationList().remove(0));
    }

    /**
     * A stub ReadOnlyAccommodationList whose accommodations list can violate interface constraints.
     */
    private static class AccommodationListStub implements ReadOnlyAccommodationList {
        private final ObservableList<Accommodation> accommodations = FXCollections.observableArrayList();

        AccommodationListStub(Collection<Accommodation> accommodations) {
            this.accommodations.setAll(accommodations);
        }

        @Override
        public ObservableList<Accommodation> getAccommodationList() {
            return accommodations;
        }
    }

}
