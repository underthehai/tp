package seedu.address.model.travelplanner;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Person;
import seedu.address.model.travelplanner.UniqueTravelPlanList;

/**
 * Wraps all data at the travel planner level
 * Duplicates are not allowed (by .isSameTravelPlan comparison)
 */
public class TravelPlanner implements ReadOnlyTravelPlanner {

    private final UniqueTravelPlanList travelPlans;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        travelPlans = new UniqueTravelPlanList();
    }

    public TravelPlanner() {}

    /**
     * Creates an TravelPlanner using the TravelPlans in the {@code toBeCopied}
     */
    public TravelPlanner(ReadOnlyTravelPlanner toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the travel plan list with {@code travelPlans}.
     * {@code travelPlans} must not contain duplicate travel plans.
     */
    public void setTravelPlans(List<TravelPlan> travelPlans) {
        this.travelPlans.setTravelPlans(travelPlans);
    }

    /**
     * Resets the existing data of this {@code TravelPlanner} with {@code newData}.
     */
    public void resetData(ReadOnlyTravelPlanner newData) {
        requireNonNull(newData);

        setTravelPlans(newData.getTravelPlanList());
    }

    //// person-level operations

    /**
     * Returns true if a travel plan with the same identity as {@code travelPlan} exists in the travel planner.
     */
    public boolean hasTravelPlan(TravelPlan travelPlan) {
        requireNonNull(travelPlan);
        return travelPlans.contains(travelPlan);
    }

    /**
     * Adds a travel plan to the travel planner.
     * The travel plan must not already exist in the travel planner.
     */
    public void addTravelPlan(TravelPlan tP) {
        travelPlans.add(tP);
    }

    /**
     * Replaces the given travel plan {@code target} in the list with {@code editedTravelPlan}.
     * {@code target} must exist in the travel planner.
     * The travel plan identity of {@code editedTravelPlan} must not be the same as another existing travel plan in the
     * travel planner.
     */
    public void setTravelPlan(TravelPlan target, TravelPlan editedTravelPlan) {
        requireNonNull(editedTravelPlan);

        travelPlans.setTravelPlan(target, editedTravelPlan);
    }

    /**
     * Removes {@code key} from this {@code TravelPlanner}.
     * {@code key} must exist in the travel planner.
     */
    public void removeTravelPlan(TravelPlan key) {
        travelPlans.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return travelPlans.asUnmodifiableObservableList().size() + " travel plans";
        // TODO: refine later
    }

    @Override
    public ObservableList<TravelPlan> getTravelPlanList() {
        return travelPlans.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TravelPlanner // instanceof handles nulls
                && travelPlans.equals(((TravelPlanner) other).travelPlans));
    }

    @Override
    public int hashCode() {
        return travelPlans.hashCode();
    }
}
