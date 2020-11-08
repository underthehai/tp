package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_ACCOMMODATION_DISPLAYED_INDEX =
            "The accommodation index provided is invalid";
    public static final String MESSAGE_MISSING_INDEX = "The index is missing!";
    public static final String MESSAGE_REDUNDANT_INDEX = "No need specify index when going to wishlist!";
    public static final String MESSAGE_INVALID_ACTIVITY_DISPLAYED_INDEX = "The activity index provided is invalid";
    public static final String MESSAGE_INVALID_FRIEND_DISPLAYED_INDEX = "The friend index provided is invalid";
    public static final String MESSAGE_INVALID_TRAVEL_PLAN_OBJECT_AT_WISHLIST = "The wishlist only stores activities,"
            + " not accommodations or friends! Use the goto command to navigate to a travel plan to "
            + "perform commands for accommodation/friend.";
    public static final String MESSAGE_INVALID_TRAVELPLAN_DISPLAYED_INDEX = "The travel plan index provided is invalid";
    public static final String MESSAGE_INVALID_INDEX = "The index provided is invalid!";
    public static final String MESSAGE_ACTIVITIES_LISTED_OVERVIEW = "%1$d activities listed!";
    public static final String MESSAGE_ACCOMMODATIONS_LISTED_OVERVIEW = "%1$d accommodations listed!";
    public static final String MESSAGE_FRIENDS_LISTED_OVERVIEW = "%1$d friends listed!";
    public static final String WRONG_DIRECTORY = "Please go to your desired travelplan to edit friend, activity "
            + "or accommodation, using the goto command.";
    public static final String MESSAGE_TRAVELPLANS_LISTED_OVERVIEW = "%1$d travel plans listed!";
    public static final String MESSAGE_INVALID_STARTANDENDDATE = "Start Date should be before or "
            + "on the same date as End Date.";
    public static final String MESSAGE_INVALID_START_DATE = "Start Date can only be today's date or any date "
            + "after today's date.";
    public static final String MESSAGE_DELETE_SUCCESS = "Deleted %s:\n%1$s";
}
