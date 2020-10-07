package seedu.address.testutil;

import static seedu.address.testutil.TypicalActivities.getTypicalActivities1;
import static seedu.address.testutil.TypicalActivities.getTypicalActivityList;
import static seedu.address.testutil.TypicalFriends.getTypicalFriendList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.activity.Activity;
import seedu.address.model.travelplan.AccommodationList;
import seedu.address.model.travelplan.ActivityList;
import seedu.address.model.travelplan.FriendList;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.TravelPlanner;

public class TypicalTravelPlans {

    /**
     * NOT DONE: WAITING FOR AccommodationBuilder, TypicalAccommodations TO BE UPDATED.
     */
    
    public static final String VALID_NAME_AUSTRALIA = "Trip to Australia";
    public static final String VALID_NAME_BOSTON = "Trip to Boston";
    public static final String VALID_START_DATE_AUSTRALIA = "2020-01-01";
    public static final String VALID_START_DATE_BOSTON = "2020-03-03";
    public static final String VALID_END_DATE_AUSTRALIA = "2020-12-12";
    public static final String VALID_END_DATE_BOSTON = "2020-11-11";
    public static final AccommodationList VALID_ACCOMMODATION_LIST_AUSTRALIA = getTypicalAccommodationList(1);
    public static final AccommodationList VALID_ACCOMMODATION_LIST_BOSTON= getTypicalAccommodationList(2);
    public static final ActivityList VALID_ACTIVITY_LIST_AUSTRALIA = getTypicalActivityList(1);
    public static final ActivityList VALID_ACTIVITY_LIST_BOSTON = getTypicalActivityList(2);
    public static final FriendList VALID_FRIEND_LIST_AUSTRALIA = getTypicalFriendList(1);
    public static final FriendList VALID_FRIEND_LIST_BOSTON = getTypicalFriendList(2);

    public static final TravelPlan AUSTRALIA_TRIP = new TravelPlanBuilder().withName("Trip to Australia")
            .withStartDate("2020-01-01").withEndDate("2020-12-12")
            .withAccommodationList(getTypicalAccommodationList(1))
            .withActivityList(getTypicalActivityList(1))
            .withFriendList(getTypicalFriendList(1)).build();
    public static final TravelPlan BOSTON_TRIP = new TravelPlanBuilder().withName("Trip to Boston")
            .withStartDate("2020-03-03").withEndDate("2021-11-11")
            .withAccommodationList(getTypicalAccommodationList(2))
            .withActivityList(getTypicalActivityList(2))
            .withFriendList(getTypicalFriendList(2)).build();
    
    private TypicalTravelPlans() {} // prevents instantiation

    /**
     * Returns a {@code TravelPlanner} with all typical travel plans and a typical wishlist.
     */
    public static TravelPlanner getTypicalTravelPlanner() {
        TravelPlanner travelPlanner = new TravelPlanner();
        for (Activity activity : getTypicalActivities1()) {
            travelPlanner.addActivity(activity);
        }
        for (TravelPlan travelPlan : getTypicalTravelPlans()) {
            travelPlanner.addTravelPlan(travelPlan);
        }
        return travelPlanner;
    }

    public static List<TravelPlan> getTypicalTravelPlans() {
        return new ArrayList<>(Arrays.asList(AUSTRALIA_TRIP, BOSTON_TRIP));
    }


}
