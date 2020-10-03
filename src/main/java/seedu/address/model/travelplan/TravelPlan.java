package seedu.address.model.travelplan;

import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javafx.collections.ObservableList;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.commons.Name;
import seedu.address.model.commons.ReadOnlyActivityList;
import seedu.address.model.commons.TravelDate;
import seedu.address.model.friend.Friend;
import seedu.address.model.tag.Tag;

/**
 * Wraps all data at the travel-plan level
 * Duplicates are not allowed (by .isSameTravelPlan comparison)
 */
public class TravelPlan {

    public static final String MESSAGE_CONSTRAINTS = "Start Date should be before or on the same date as End Date.";

    // Identity fields
    private final Name name;
    private final TravelDate startDate;
    private final TravelDate endDate;

    // Data fields
    private final ActivityList activities = new ActivityList();
    private final AccommodationList accommodations = new AccommodationList();
    private final FriendList friends = new FriendList();
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Creates an empty TravelPlan with only the name, startDate, endDate and tags.
     */
    public TravelPlan(Name name, TravelDate startDate, TravelDate endDate, Set<Tag> tags) {
        checkArgument(isValidStartAndEndDate(startDate, endDate), MESSAGE_CONSTRAINTS);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tags.addAll(tags);
    }

    /**
     * Creates an TravelPlan using the Accommodations, Activities and Friends in the {@code accommodationsToBeCopied},
     * {@code activitiesToBeCopied} and {@code friendsTobeCopied}
     */
    public TravelPlan(Name name, TravelDate startDate, TravelDate endDate, Set<Tag> tags,
                      ReadOnlyAccommodationList accommodationsToBeCopied,
                      ReadOnlyActivityList activitiesToBeCopied,
                      ReadOnlyFriendList friendsTobeCopied) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tags.addAll(tags);
        accommodations.resetData(accommodationsToBeCopied);
        activities.resetData(activitiesToBeCopied);
        friends.resetData(friendsTobeCopied);
    }

    /**
     * Returns true if the start date is before or on the same day as end date.
     */
    public static boolean isValidStartAndEndDate(TravelDate startDate, TravelDate endDate) {
        return startDate.getValue().compareTo(endDate.getValue()) <= 0;
    }

    //// travel plan object-level operations

    /**
     * Returns true if a travel plan object with the same identity as {@code travelPlanObject} exists in the travel plan
     * object's list.
     */
    public boolean hasTravelPlanObject(TravelPlanObject travelPlanObject) {
        if (travelPlanObject instanceof Accommodation) {
            return accommodations.hasAccommodation((Accommodation) travelPlanObject);
        } else if (travelPlanObject instanceof Activity) {
            return activities.hasActivity((Activity) travelPlanObject);
        } else { // if travelPlanObject instanceof Friend
            return friends.hasFriend((Friend) travelPlanObject);
        }
    }

    /**
     * Adds a travel plan object to its corresponding list.
     * The travel plan object must not already exist in its corresponding list.
     */
    public void addTravelPlanObject(TravelPlanObject travelPlanObject) {
        if (travelPlanObject instanceof Accommodation) {
            accommodations.addAccommodation((Accommodation) travelPlanObject);
        } else if (travelPlanObject instanceof Activity) {
            activities.addActivity((Activity) travelPlanObject);
        } else { // if travelPlanObject instanceof Friend
            friends.addFriend((Friend) travelPlanObject);
        }
    }

    /**
     * Replaces the given travel plan object {@code target} in the list with {@code editedTravelPlanObject}.
     * {@code target} must exist in the corresponding travel plan object list.
     * The travel plan object identity of {@code editedTravelPlanObject} must not be the same as another existing
     * travel plan object in the corresponding travel plan object list.
     */
    public void setTravelPlanObject(TravelPlanObject target, TravelPlanObject editedTravelPlanObject) {
        if (editedTravelPlanObject instanceof Accommodation) {
            accommodations.setAccommodation((Accommodation) target, (Accommodation) editedTravelPlanObject);
        } else if (editedTravelPlanObject instanceof Activity) {
            activities.setActivity((Activity) target, (Activity) editedTravelPlanObject);
        } else { // if editedTravelPlanObject instanceof Friend
            friends.setFriend((Friend) target, (Friend) editedTravelPlanObject);
        }
    }

    /**
     * Removes {@code key} from the corresponding travel plan object list.
     * {@code key} must exist in the corresponding travel plan object list.
     */
    public void removeTravelPlanObject(TravelPlanObject key) {
        if (key instanceof Accommodation) {
            accommodations.removeAccommodation((Accommodation) key);
        } else if (key instanceof Activity) {
            activities.removeActivity((Activity) key);
        } else { // if key instanceof Friend
            friends.removeFriend((Friend) key);
        }
    }

    //// util methods

    //// travel plan identity methods

    public Name getName() {
        return name;
    }

    public TravelDate getStartDate() {
        return startDate;
    }

    public TravelDate getEndDate() {
        return endDate;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both travel plans of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two travel plans.
     */
    public boolean isSameTravelPlan(TravelPlan otherTravelPlan) {
        if (otherTravelPlan == this) {
            return true;
        }

        return otherTravelPlan != null
                && otherTravelPlan.getName().equals(getName())
                && (otherTravelPlan.getStartDate().equals(getStartDate())
                || otherTravelPlan.getEndDate().equals(getEndDate()));
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Start Date: ")
                .append(getStartDate())
                .append(" End Date: ")
                .append(getEndDate())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        builder.append(accommodations)
                .append(activities)
                .append(friends);
        return builder.toString();
    }

    //// travel plan data methods

    public ObservableList<Accommodation> getAccommodationList() {
        return accommodations.getAccommodationList();
    }

    public ObservableList<Activity> getActivityList() {
        return activities.getActivityList();
    }

    public ObservableList<Friend> getFriendList() {
        return friends.getFriendList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TravelPlan // instanceof handles nulls
                && name.equals(((TravelPlan) other).name)
                && startDate.equals(((TravelPlan) other).startDate)
                && endDate.equals(((TravelPlan) other).endDate)
                && getTags().equals(((TravelPlan) other).getTags())
                && accommodations.equals(((TravelPlan) other).accommodations)
                && activities.equals(((TravelPlan) other).activities)
                && friends.equals(((TravelPlan) other).friends));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDate, endDate, tags, accommodations, activities, friends);
    }
}
