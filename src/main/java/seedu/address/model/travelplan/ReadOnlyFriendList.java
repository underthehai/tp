package seedu.address.model.travelplan;

import javafx.collections.ObservableList;
import seedu.address.model.friend.Friend;

public interface ReadOnlyFriendList {
    /**
     * Returns an unmodifiable view of the friend list.
     * This list will not contain any duplicate friends.
     */
    ObservableList<Friend> getFriendList();
}
