package seedu.address.model.friend;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Friend's mobile number in the travel plan.
 * Guarantees: immutable; is valid as declared in {@link #isValidMobile(String)}
 */
public class Mobile {
    public static final String MESSAGE_CONSTRAINTS =
            "Mobile numbers should only contain numbers, and it should be at least 8 digits long";
    public static final String VALIDATION_REGEX = "\\d{8}";
    public final String value;

    /**
     * Constructs a {@code Mobile}.
     *
     * @param mobile A valid mobile number.
     */
    public Mobile(String mobile) {
        requireNonNull(mobile);
        checkArgument(isValidMobile(mobile), MESSAGE_CONSTRAINTS);
        value = mobile;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidMobile(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Mobile // instanceof handles nulls
                && value.equals(((Mobile) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
