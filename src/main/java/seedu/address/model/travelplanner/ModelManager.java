package seedu.address.model.travelplanner;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.travelplan.AccommodationList.EMPTY_ACCOMMODATION_LIST;
import static seedu.address.model.travelplan.FriendList.EMPTY_FRIEND_LIST;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.commons.TravelPlanObject;
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
    private boolean isTravelPlan;
    private Directory directory;
    private FilteredList<Activity> filteredActivityList;
    private FilteredList<Accommodation> filteredAccommodationList;
    private FilteredList<Friend> filteredFriendList;

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
        isTravelPlan = false;
        directory = this.travelPlanner.getWishlistAsDirectory();
        filteredActivityList = new FilteredList<>(directory.getActivityList());
        filteredAccommodationList = new FilteredList<>(directory instanceof TravelPlan
                ? ((TravelPlan) directory).getAccommodationList() : EMPTY_ACCOMMODATION_LIST);
        filteredFriendList = new FilteredList<>(directory instanceof TravelPlan
                ? ((TravelPlan) directory).getFriendList() : EMPTY_FRIEND_LIST);
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
    public void deleteTravelPlan(TravelPlan target) {
        travelPlanner.removeTravelPlan(target);
    }

    @Override
    public void addTravelPlan(TravelPlan travelPlan) {
        travelPlanner.addTravelPlan(travelPlan);
        updateFilteredTravelPlanList(PREDICATE_SHOW_ALL_TRAVEL_PLAN);
    }

    @Override
    public void setTravelPlan(TravelPlan target, TravelPlan editedTravelPlan) {
        requireAllNonNull(target, editedTravelPlan);

        travelPlanner.setTravelPlan(target, editedTravelPlan);
    }

    //=========== Wishlist =============================================================

    @Override
    public boolean hasActivity(Activity activity) {
        requireNonNull(activity);
        return travelPlanner.hasActivity(activity);
    }

    @Override
    public void deleteActivity(Activity target) {
        travelPlanner.removeActivity(target);
    }

    @Override
    public void addActivity(Activity activity) {
        travelPlanner.addActivity(activity);
        updateFilteredWishlist(PREDICATE_SHOW_ALL_ACTIVITY);
    }

    @Override
    public void setActivity(Activity target, Activity editedActivity) {
        requireAllNonNull(target, editedActivity);

        travelPlanner.setActivity(target, editedActivity);
    }

    //=========== Directory =============================================================


    @Override
    public void setDirectory(int index, boolean isTravelPlan) {
        if (isTravelPlan) {
            this.isTravelPlan = isTravelPlan;
            directory = travelPlanner.getTravelPlanList().get(index);
            filteredActivityList = new FilteredList<>(directory.getActivityList());
            filteredAccommodationList = new FilteredList<>(directory instanceof TravelPlan
                    ? ((TravelPlan) directory).getAccommodationList() : EMPTY_ACCOMMODATION_LIST);
            filteredFriendList = new FilteredList<>(directory instanceof TravelPlan
                    ? ((TravelPlan) directory).getFriendList() : EMPTY_FRIEND_LIST);
        } else {
            this.isTravelPlan = isTravelPlan;
            directory = travelPlanner.getWishlistAsDirectory();
        }
    }

    @Override
    public Directory getDirectory() {
        return directory;
    }

    @Override
    public boolean isDirectoryTypeTravelPlan() {
        if (isTravelPlan) {
            return true;
        }
        return false;
    }

    //=========== TravelPlanObject =============================================================

    @Override
    public boolean hasTravelPlanObject(TravelPlanObject tPObj) {
        requireNonNull(tPObj);
        assert directory instanceof TravelPlan : "Directory must be set to a TravelPlan to call hasTravelPlanObject.";
        TravelPlan tp = (TravelPlan) directory;
        return tp.hasTravelPlanObject(tPObj);
    }

    @Override
    public void deleteTravelPlanObject(TravelPlanObject tPObj) {
        requireNonNull(tPObj);
        assert directory instanceof TravelPlan
                : "Directory must be set to a TravelPlan to call deleteTravelPlanObject.";
        TravelPlan tp = (TravelPlan) directory;
        tp.removeTravelPlanObject(tPObj);
    }

    @Override
    public void addTravelPlanObject(TravelPlanObject tPObj) {
        requireNonNull(tPObj);
        assert directory instanceof TravelPlan : "Directory must be set to a TravelPlan to call addTravelPlanObject.";
        TravelPlan tp = (TravelPlan) directory;
        tp.addTravelPlanObject(tPObj);
    }

    @Override
    public void setTravelPlanObject(TravelPlanObject target, TravelPlanObject editedTravelPlanObject) {
        requireAllNonNull(target, editedTravelPlanObject);
        assert directory instanceof TravelPlan : "Directory must be set to a TravelPlan to call setTravelPlanObject.";
        TravelPlan tp = (TravelPlan) directory;
        tp.setTravelPlanObject(target, editedTravelPlanObject);
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
    public void updateFilteredWishlist(Predicate<Activity> predicate) {
        requireNonNull(predicate);
        filteredWishlist.setPredicate(predicate);
    }

    //=========== Filtered TravelPLanObject List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code ? extends TravelPlanObject} backed by the internal list of
     * {@code TravelPlan}
     */
    @Override
    public ObservableList<Activity> getFilteredActivityList() {
        return filteredActivityList;
    }

    @Override
    public void updateFilteredActivityList(Predicate<Activity> predicate) {
        requireNonNull(predicate);
        filteredActivityList.setPredicate(predicate);
    }

    @Override
    public ObservableList<Friend> getFilteredFriendList() {
        return filteredFriendList;
    }

    @Override
    public void updateFilteredFriendList(Predicate<Friend> predicate) {
        requireNonNull(predicate);
        filteredFriendList.setPredicate(predicate);
    }

    @Override
    public ObservableList<Accommodation> getFilteredAccommodationList() {
        return filteredAccommodationList;
    }

    @Override
    public void updateFilteredAccommodationList(Predicate<Accommodation> predicate) {
        requireNonNull(predicate);
        filteredAccommodationList.setPredicate(predicate);
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
