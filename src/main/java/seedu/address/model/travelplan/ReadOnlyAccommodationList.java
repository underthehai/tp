package seedu.address.model.travelplan;

import javafx.collections.ObservableList;
import seedu.address.model.accommodation.Accommodation;

public interface ReadOnlyAccommodationList {

    /**
     * Returns an unmodifiable view of the accommodation list.
     * This list will not contain any duplicate accommodations.
     */
    ObservableList<Accommodation> getAccommodationList();

}
