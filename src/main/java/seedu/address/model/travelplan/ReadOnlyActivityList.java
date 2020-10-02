package seedu.address.model.travelplan;

public interface ReadOnlyActivityList {

    /**
     * Returns an unmodifiable view of the activities list.
     * This list will not contain any duplicate activities.
     */
    javafx.collections.ObservableList<seedu.address.model.activity.Activity> getActivityList();
    
}
