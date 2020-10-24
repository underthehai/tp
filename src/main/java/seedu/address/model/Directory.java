package seedu.address.model;


import javafx.collections.ObservableList;
import seedu.address.model.activity.Activity;
import seedu.address.model.commons.TravelPlanObject;

/**
 * Represents the current directory of wanderlust, which can be instance of TravelPlan or Wishlist
 */
public abstract class Directory {
    public abstract ObservableList<Activity> getActivityList();

    public abstract boolean isTravelPlan();

    public abstract boolean has(TravelPlanObject travelPlanObject);

    public abstract void remove(TravelPlanObject travelPlanObject);

    public abstract void add(TravelPlanObject travelPlanObject);

    public abstract void set(TravelPlanObject target, TravelPlanObject editedTravelPlanObject);

}
