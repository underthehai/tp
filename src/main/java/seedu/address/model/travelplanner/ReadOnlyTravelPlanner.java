package seedu.address.model.travelplanner;

import javafx.collections.ObservableList;

/**
 * Unmodifiable view of a travel planner
 */
public interface ReadOnlyTravelPlanner {

    /**
     * Returns an unmodifiable view of the travel plans list.
     * This list will not contain any duplicate travel plans.
     */
    ObservableList<TravelPlan> getTravelPlanList();

    /**
     * Returns an unmodifiable view of the wishlist.
     * This list will not contain any duplicate activities.
     */
    ObservableList<Activity> getWishlist();

}
