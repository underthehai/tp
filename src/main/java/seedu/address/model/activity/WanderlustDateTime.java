package seedu.address.model.activity;

import seedu.address.model.commons.WanderlustDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class WanderlustDateTime {
    public static final String MESSAGE_CONSTRAINTS = "Date Time should be of the format YYYY-MM-DD HH:mm.";

    /*
     * Dates must be in the format YYYY-MM-DD HH:mm.
     */
    public static final DateFormat VALID_DATE_STRING = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final DateFormat STYLIZED_DATE_FORMAT = new SimpleDateFormat("dd MMM yyyy HH:mm");

    private String dateTime;
    private Date value;

    /**
     * Constructs a {@code WanderlustDate}.
     *
     * @param dateTime A valid date and time.
     */
    public WanderlustDateTime(String dateTime) {
        requireNonNull(dateTime);
        checkArgument(isValidWanderlustDate(dateTime), MESSAGE_CONSTRAINTS);
        try {
            value = STYLIZED_DATE_FORMAT.parse(dateTime);
        } catch (ParseException ex) {
            // This is unexpected as the date should have been validated above.
            System.err.println("Unexpected error: Error parsing date string.");
        }
    }

    /**
     * Returns if a given string is a valid travel date.
     */
    public static boolean isValidWanderlustDate(String test) {
        try{
            VALID_DATE_STRING.parse(test);
            return true;
        }catch(ParseException e){
            return false;
        }
    }

    public Date getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof WanderlustDateTime // instanceof handles nulls
                && value.equals(((WanderlustDateTime) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


}
