package seedu.address.model.commons;

public abstract class TravelPlanObjectList {
    public abstract boolean has(TravelPlanObject travelPlanObject);

    public abstract void add(TravelPlanObject travelPlanObject);

    public abstract void set(TravelPlanObject travelPlanObject);

    public abstract void remove(TravelPlanObject travelPlanObject);
}
