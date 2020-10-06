package seedu.address.model.commons;

import javafx.collections.ObservableList;
import seedu.address.model.activity.Activity;

public interface ReadOnlyActivityList {
    /**
     * Returns an unmodifiable view of the activities list.
     * This list will not contain any duplicate activities.
     */
    ObservableList<Activity> getActivityList();
}
