package seedu.address.model.activity;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Activity's level of Importance in the travel plan.
 * Guarantees: immutable; is valid as declared in {@link #isValidImportance(String)}
 */
public class Importance {
    public static final String MESSAGE_CONSTRAINTS =
            "Phone numbers should only contain numbers, and it should range from 1 - 5";
    public static final String VALIDATION_REGEX = "\\d[1-5]";
    public final String value;

    /**
     * Constructs a {@code Importance}.
     *
     * @param importanceLevel A valid importance level.
     */
    public Importance(String importanceLevel) {
        requireNonNull(importanceLevel);
        checkArgument(isValidImportance(importanceLevel), MESSAGE_CONSTRAINTS);
        value = importanceLevel;
    }

    /**
     * Returns true if a given string is a valid importance level.
     */
    public static boolean isValidImportance(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Importance // instanceof handles nulls
                && value == (((Importance) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
