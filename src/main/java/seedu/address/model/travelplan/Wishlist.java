package seedu.address.model.travelplan;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.person.Activity;

/**
 * Wraps all data at the travel plan level
 * Duplicates are not allowed (by .isSameTravelPlan comparison)
 */
public class Wishlist implements ReadOnlyActivityList {

    private final UniqueActivityList activities;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        activities = new UniqueActivityList();
    }

    public Wishlist() {}

    /**
     * Creates an AddressBook using the Activitys in the {@code toBeCopied}
     */
    public Wishlist(ReadOnlyActivityList toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code activities}.
     * {@code activities} must not contain duplicate activities.
     */
    public void setActivities(List<Activity> activities) {
        this.activities.setActivities(activities);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyActivityList newData) {
        requireNonNull(newData);

        setActivities(newData.getActivityList());
    }

    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasActivity(Activity activity) {
        requireNonNull(activity);
        return activities.contains(activity);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addActivity(Activity p) {
        activites.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedActivity}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedActivity} must not be the same as another existing person in the address book.
     */
    public void setActivity(Activity target, Activity editedActivity) {
        requireNonNull(editedActivity);

        activities.setActivity(target, editedActivity);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeActivity(Activity key) {
        activities.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return activities.asUnmodifiableObservableList().size() + " activities";
        // TODO: refine later
    }

    @Override
    public ObservableList<Activity> getActivityList() {
        return activities.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Wishlist // instanceof handles nulls
                && activities.equals(((Wishlist) other).activities));
    }

    @Override
    public int hashCode() {
        return activities.hashCode();
    }
}
