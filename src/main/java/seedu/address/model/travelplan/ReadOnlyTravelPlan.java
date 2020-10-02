package seedu.address.model.travelplan;

public interface ReadOnlyTravelPlan {
    /**
     * Returns an unmodifiable view of the friend list.
     * This list will not contain any duplicate friends.
     */
    javafx.collections.ObservableList<seedu.address.model.friend.Friend> getFriendList();

    /**
     * Returns an unmodifiable view of the activities list.
     * This list will not contain any duplicate activities.
     */
    javafx.collections.ObservableList<seedu.address.model.activity.Activity> getActivityList();

    /**
     * Returns an unmodifiable view of the accommodation list.
     * This list will not contain any duplicate accommodations.
     */
    javafx.collections.ObservableList<seedu.address.model.accommodation.Accommodation> getAccommodationList();
}
