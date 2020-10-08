package seedu.address.model.friend;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's passport in the travel plan.
 * Guarantees: immutable; is valid as declared in {@link #isValidPassport(String)}
 */
public class Passport {

    public static final String MESSAGE_CONSTRAINTS =
            "Passport numbers should only contain 1 character and 7 numbers";
    public static final String VALIDATION_REGEX = "\\w\\d{7}";
    public final String value;

    /**
     * Constructs a {@code Passport}.
     *
     * @param passport A valid passport.
     */
    public Passport(String passport) {
        requireNonNull(passport);
        checkArgument(isValidPassport(passport), MESSAGE_CONSTRAINTS);
        value = passport;
    }

    /**
     * Returns true if a given string is a valid passport.
     */
    public static boolean isValidPassport(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Passport // instanceof handles nulls
                && value.equals(((Passport) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
