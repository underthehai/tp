package seedu.address.model.travelplanner;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.friend.Friend;
import seedu.address.model.travelplan.TravelPlan;


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
    void deleteActivityFromWishList(Activity target);

    /**
     * Deletes the given activity.
     * The activity must exist in the travel plan.
     */
    void deleteActivityFromTravelPlan(Activity target, TravelPlan travelPlan);

    /**
     * Deletes the given friend.
     * The friend must exist in the travel plan.
     */
    void deleteFriend(Friend target, TravelPlan travelPlan);

    /**
     * Deletes the given accommodation.
     * The friend must exist in the travel plan.
     */
    void deleteAccommodation(Accommodation target, TravelPlan travelPlan);

    /**
     * Adds the given travel plan.
     * {@code travelPlan} must not already exist in the travel planner.
     */
    void addTravelPlan(TravelPlan travelPlan);

    /**
     * Adds the given activity.
     * {@code activity} must not already exist in the wishlist.
     */
    void addActivityToWishList(Activity activity);

    /**
     * Adds the given activity.
     * {@code activity} must not already exist in the travel plan.
     */
    void addActivityToTravelPlan(Activity activity, TravelPlan travelPlan);

    /**
     * Adds the given friend.
     * {@code friend} must not already exist in the travel plan.
     */
    void addFriend(Friend friend, TravelPlan travelPlan);

    /**
     * Adds the given accommodation.
     * {@code accommodation} must not already exist in the travel plan.
     */
    void addAccommodation(Accommodation accommodation, TravelPlan travelPlan);

    /**
     * Replaces the given travel plan {@code target} with {@code editedTravelPlan}.
     * {@code target} must exist in the travel planner.
     * The travel plan identity of {@code editedTravelPlan} must not be the same as another existing travel plan in the
     * travel planner.
     */
    void setTravelPlan(TravelPlan target, TravelPlan editedTravelPlan);

    /**
     * Replaces the given activity {@code target} with {@code editedActivity}.
     * {@code target} must exist in the wishlist.
     * The activity identity of {@code editedActivity} must not be the same as another existing activity in the
     * wishlist.
     */
    void setActivityOnWishList(Activity target, Activity editedActivity);

    /**
     * Replaces the given activity {@code target} with {@code editedActivity}.
     * {@code target} must exist in the travel plan.
     * The activity identity of {@code editedActivity} must not be the same as another existing activity in the
     * travel plan.
     */
    void setActivityOnTravelPlan(Activity target, Activity editedActivity, TravelPlan travelPlan);

    /**
     * Replaces the given accommodation {@code target} with {@code editedAccommodation}.
     * {@code target} must exist in the travel plan.
     * The accommodation identity of {@code editedAccommodation} must not be the same as
     * another existing accommodation in the travel plan.
     * */
    void setAccommodation(Accommodation target, Accommodation editedAccommodation, TravelPlan travelPlan);

    /**
     * Replaces the given Friend {@code target} with {@code editedFriend}.
     * {@code target} must exist in the travel plan.
     * The friend identity of {@code editedFriend} must not be the same as another existing friend in the
     * travel plan.
     */
    void setFriend(Friend target, Friend editedFriend, TravelPlan travelPlan);

    /** Returns an unmodifiable view of the filtered travel plan list */
    ObservableList<TravelPlan> getFilteredTravelPlanList();

    /** Returns an unmodifiable view of the filtered wishlist */
    ObservableList<Activity> getFilteredWishlist();

    /** Returns an unmodifiable view of the filtered activity list */
    ObservableList<Activity> getFilteredActivityList();

    /** Returns an unmodifiable view of the filtered accommodation list */
    ObservableList<Accommodation> getFilteredAccommodationList();

    /** Returns an unmodifiable view of the filtered friend list */
    ObservableList<Friend> getFilteredFriendList();
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
