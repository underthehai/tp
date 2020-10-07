package seedu.address.model.travelplanner;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.friend.Friend;
import seedu.address.model.travelplan.TravelPlan;

/**
 * Represents the in-memory model of the travel planner data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final TravelPlanner travelPlanner;
    private final UserPrefs userPrefs;
    private final FilteredList<TravelPlan> filteredTravelPlans;
    private final FilteredList<Activity> filteredWishlist;


    /**
     * Initializes a ModelManager with the given travelPlanner and userPrefs.
     */
    public ModelManager(ReadOnlyTravelPlanner travelPlanner, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(travelPlanner, userPrefs);

        logger.fine("Initializing with travel planner: " + travelPlanner + " and user prefs " + userPrefs);

        this.travelPlanner = new TravelPlanner(travelPlanner);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredTravelPlans = new FilteredList<>(this.travelPlanner.getTravelPlanList());
        filteredWishlist = new FilteredList<>(this.travelPlanner.getWishlist());
    }

    public ModelManager() {
        this(new TravelPlanner(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getTravelPlannerFilePath() {
        return userPrefs.getTravelPlannerFilePath();
    }

    @Override
    public void setTravelPlannerFilePath(Path travelPlannerFilePath) {
        requireNonNull(travelPlannerFilePath);
        userPrefs.setTravelPlannerFilePath(travelPlannerFilePath);
    }

    //=========== TravelPlanner ================================================================================

    @Override
    public void setTravelPlanner(ReadOnlyTravelPlanner travelPlanner) {
        this.travelPlanner.resetData(travelPlanner);
    }

    @Override
    public ReadOnlyTravelPlanner getTravelPlanner() {
        return travelPlanner;
    }

    @Override
    public boolean hasTravelPlan(TravelPlan travelPlan) {
        requireNonNull(travelPlan);
        return travelPlanner.hasTravelPlan(travelPlan);
    }

    @Override
    public boolean hasActivity(Activity activity) {
        requireNonNull(activity);
        return travelPlanner.hasActivity(activity);
    }

    @Override
    public void deleteTravelPlan(TravelPlan target) {
        travelPlanner.removeTravelPlan(target);
    }

    @Override
    public void deleteActivityFromWishList(Activity target) {
        travelPlanner.removeActivity(target);
    }

    @Override
    public void deleteActivityFromTravelPlan(Activity target, TravelPlan travelPlan) {
        travelPlan.removeTravelPlanObject(target);
    }

    @Override
    public void deleteFriend(Friend target, TravelPlan travelPlan) {
        travelPlan.removeTravelPlanObject(target);
    }

    @Override
    public void deleteAccommodation(Accommodation target, TravelPlan travelPlan) {
        travelPlan.removeTravelPlanObject(target);
    }

    @Override
    public void addTravelPlan(TravelPlan travelPlan) {
        travelPlanner.addTravelPlan(travelPlan);
        updateFilteredTravelPlanList(PREDICATE_SHOW_ALL_TRAVEL_PLAN);
    }


    @Override
    public void addActivityToTravelPlan(Activity activity, TravelPlan travelPlan) {
        travelPlan.addTravelPlanObject(activity);
    }

    @Override
    public void addFriend(Friend friend, TravelPlan travelPlan) {
        travelPlan.addTravelPlanObject(friend);

    }

    @Override
    public void addAccommodation(Accommodation accommodation, TravelPlan travelPlan) {
        travelPlan.addTravelPlanObject(accommodation);
    }

    @Override
    public void addActivityToWishList(Activity activity) {
        travelPlanner.addActivity(activity);
        updateFilteredWishlist(PREDICATE_SHOW_ALL_ACTIVITY);
    }

    @Override
    public void setTravelPlan(TravelPlan target, TravelPlan editedTravelPlan) {
        requireAllNonNull(target, editedTravelPlan);
        travelPlanner.setTravelPlan(target, editedTravelPlan);
    }

    @Override
    public void setActivityOnWishList(Activity target, Activity editedActivity) {
        requireAllNonNull(target, editedActivity);
        travelPlanner.setActivity(target, editedActivity);
    }

    @Override
    public void setActivityOnTravelPlan(Activity target, Activity editedActivity, TravelPlan travelPlan) {
        requireAllNonNull(target, editedActivity);
        travelPlan.setTravelPlanObject(target, editedActivity);
    }

    @Override
    public void setAccommodation(Accommodation target, Accommodation editedAccommodation, TravelPlan travelPlan) {
        requireAllNonNull(target, editedAccommodation);
        travelPlan.setTravelPlanObject(target, editedAccommodation);
    }

    @Override
    public void setFriend(Friend target, Friend editedFriend, TravelPlan travelPlan) {
        requireAllNonNull(target, editedFriend);
        travelPlan.setTravelPlanObject(target, editedFriend);
    }

    //=========== Filtered TravelPlan List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code TravelPlan} backed by the internal list of
     * {@code TravelPlanner}
     */
    @Override
    public ObservableList<TravelPlan> getFilteredTravelPlanList() {
        return filteredTravelPlans;
    }

    @Override
    public void updateFilteredTravelPlanList(Predicate<TravelPlan> predicate) {
        requireNonNull(predicate);
        filteredTravelPlans.setPredicate(predicate);
    }

    //=========== Filtered Wishlist List Accessors =============================================================
    /**
     * Returns an unmodifiable view of the list of {@code Activity} backed by the internal list of
     * {@code Wishlist}
     */
    @Override
    public ObservableList<Activity> getFilteredWishlist() {
        return filteredWishlist;
    }

    @Override
    public ObservableList<Activity> getFilteredActivityList() {
        return null;
    }

    @Override
    public ObservableList<Accommodation> getFilteredAccommodationList() {
        return null;
    }

    @Override
    public ObservableList<Friend> getFilteredFriendList() {
        return null;
    }

    @Override
    public void updateFilteredWishlist(Predicate<Activity> predicate) {
        requireNonNull(predicate);
        filteredWishlist.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return travelPlanner.equals(other.travelPlanner)
                && userPrefs.equals(other.userPrefs)
                && filteredTravelPlans.equals(other.filteredTravelPlans);
    }

}