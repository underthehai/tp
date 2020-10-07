package seedu.address.model.travelplan;

public interface ReadOnlyFriendList {
    /**
     * Returns an unmodifiable view of the friend list.
     * This list will not contain any duplicate friends.
     */
    javafx.collections.ObservableList<seedu.address.model.friend.Friend> getFriendList();
}
