package seedu.address.model.travelplanner;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.activity.Activity;
import seedu.address.model.travelplan.TravelPlan;

import java.nio.file.Path;
import java.util.function.Predicate;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<TravelPlan> PREDICATE_SHOW_ALL_TRAVEL_PLAN = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<Activity> PREDICATE_SHOW_ALL_ACTIVITY = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' travel planner file path.
     */
    Path getTravelPlannerFilePath();

    /**
     * Sets the user prefs' travel planner file path.
     */
    void setTravelPlannerFilePath(Path travelPlannerFilePath);

    /**
     * Replaces travel planner data with the data in {@code travelPlanner}.
     */
    void setTravelPlanner(ReadOnlyTravelPlanner travelPlanner);

    /** Returns the TravelPlanner */
    ReadOnlyTravelPlanner getTravelPlanner();

    /**
     * Returns true if a travel plan with the same identity as {@code travelPlan} exists in the travel planner.
     */
    boolean hasTravelPlan(TravelPlan travelPlan);

    /**
     * Returns true if an activity with the same identity as {@code activity} exists in the wishlist.
     */
    boolean hasActivity(Activity activity);

    /**
     * Deletes the given travel plan.
     * The travel plan must exist in the travel planner.
     */
    void deleteTravelPlan(TravelPlan target);

    /**
     * Deletes the given activity.
     * The activity must exist in the wishlist.
     */
    void deleteActivity(Activity target);

    /**
     * Adds the given travel plan.
     * {@code travelPlan} must not already exist in the travel planner.
     */
    void addTravelPlan(TravelPlan travelPlan);

    /**
     * Adds the given activity.
     * {@code activity} must not already exist in the wishlist.
     */
    void addActivity(Activity activity);

    /**
     * Replaces the given travel plan {@code target} with {@code editedTravelPlan}.
     * {@code target} must exist in the travel planner.
     * The travel plan identity of {@code editedTravelPlan} must not be the same as another existing travel plan in the travel planner.
     */
    void setTravelPlan(TravelPlan target, TravelPlan editedTravelPlan);

    /**
     * Replaces the given activity {@code target} with {@code editedActivity}.
     * {@code target} must exist in the wishlist.
     * The activity identity of {@code editedActivity} must not be the same as another existing activity in the wishlist.
     */
    void setActivity(Activity target, Activity editedActivity);

    /** Returns an unmodifiable view of the filtered travel plan list */
    ObservableList<TravelPlan> getFilteredTravelPlanList();

    /** Returns an unmodifiable view of the filtered wishlist */
    ObservableList<Activity> getFilteredWishlist();

    /**
     * Updates the filter of the filtered travel plan list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTravelPlanList(Predicate<TravelPlan> predicate);

    /**
     * Updates the filter of the filtered wishlist to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredWishlist(Predicate<Activity> predicate);
}
