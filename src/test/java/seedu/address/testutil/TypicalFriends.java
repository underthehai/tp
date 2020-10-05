package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.friend.Friend;

/**
 * A utility class containing a list of {@code Friend} objects to be used in tests.
 */
public class TypicalFriends {

    public static final Friend ALICE = new FriendBuilder().withName("Alice Pauline")
            .withPassport("A1234567")
            .withPhone("94351253").build();
    public static final Friend BENSON = new FriendBuilder().withName("Benson Meier")
            .withPassport("B1234567")
            .withPhone("98765432").build();
    public static final Friend CARL = new FriendBuilder().withName("Carl Kurz")
            .withPhone("95352563").build();
    public static final Friend DANIEL = new FriendBuilder().withName("Daniel Meier")
            .withPassport("C1234567")
            .withPhone("87652533").build();

    private TypicalFriends() {} // prevents instantiation

    public static List<Friend> getTypicalFriends() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL));
    }
}
