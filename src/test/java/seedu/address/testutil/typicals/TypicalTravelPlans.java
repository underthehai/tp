package seedu.address.testutil.typicals;

import static seedu.address.testutil.typicals.TypicalAccommodations.getTypicalAccommodationList;
import static seedu.address.testutil.typicals.TypicalAccommodations.getTypicalAccommodations1;
import static seedu.address.testutil.typicals.TypicalActivities.getTypicalActivities1;
import static seedu.address.testutil.typicals.TypicalActivities.getTypicalActivityList;
import static seedu.address.testutil.typicals.TypicalFriends.getTypicalFriendList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.activity.Activity;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.TravelPlanner;
import seedu.address.testutil.builders.TravelPlanBuilder;

public class TypicalTravelPlans {

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
