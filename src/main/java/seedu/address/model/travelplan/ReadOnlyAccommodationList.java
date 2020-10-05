package seedu.address.model.travelplan;

public interface ReadOnlyAccommodationList {

    /**
     * Returns an unmodifiable view of the accommodation list.
     * This list will not contain any duplicate accommodations.
     */
    javafx.collections.ObservableList<seedu.address.model.accommodation.Accommodation> getAccommodationList();

}
