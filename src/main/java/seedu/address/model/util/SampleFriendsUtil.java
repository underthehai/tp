package seedu.address.model.util;

import seedu.address.model.friend.Friend;
import seedu.address.model.friend.Name;
import seedu.address.model.friend.Passport;
import seedu.address.model.friend.Phone;


public class SampleFriendsUtil {

    public static Friend[] getSampleFriends() {
        return new Friend[]{
            new Friend(new Name("Alex Yeoh"), new Passport("M1234567"), new Phone("87438807")),
            new Friend(new Name("Bernice Yu"), new Passport("E1234567"), new Phone("99272758")),
            new Friend(new Name("Charlotte Oliveiro"), new Passport("C1234567"), new Phone("93210283")),
            new Friend(new Name("David Li"), new Passport("D1234567"), new Phone("991031282"))
        };
    }
}
