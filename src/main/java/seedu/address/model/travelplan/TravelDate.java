package seedu.address.model.travelplan;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a TravelPlan's start/end date in the travel planner.
 * Guarantees: immutable; is valid as declared in {@link #isValidTravelDate(String)}
 */
public class TravelDate {
    public static final String MESSAGE_CONSTRAINTS = "Dates should be of the format YYYY-MM-DD.";

    /*
     * Dates must be in the format YYYY-MM-DD.
     */
    public static final String VALIDATION_REGEX = "\\d{4}-[01]\\d-[0-3]\\d";
    public static final DateFormat VALID_DATE_STRING = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateFormat STYLIZED_DATE_FORMAT = new SimpleDateFormat("dd MMM yyyy");

    public Date value;

    /**
     * Constructs a {@code TravelDate}.
     *
     * @param date A valid travel date.
     */
    public TravelDate(String date) {
        requireNonNull(date);
        checkArgument(isValidTravelDate(date), MESSAGE_CONSTRAINTS);
        try {
            value = STYLIZED_DATE_FORMAT.parse(date);
        } catch (ParseException ex) {
            // This is unexpected as the date should have been validated above.
            System.err.println("Unexpected error: Error parsing date string.");
        }
    }

    /**
     * Returns if a given string is a valid travel date.
     */
    public static boolean isValidTravelDate(String test) {
        if (!test.matches(VALIDATION_REGEX)) {
            return false;
        }
        try {
            VALID_DATE_STRING.parse(test);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TravelDate // instanceof handles nulls
                && value.equals(((TravelDate) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
