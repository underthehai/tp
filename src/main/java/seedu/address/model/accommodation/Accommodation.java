package seedu.address.model.accommodation;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Date;
import java.util.Objects;

import seedu.address.model.commons.Cost;
import seedu.address.model.commons.Location;
import seedu.address.model.commons.Name;
import seedu.address.model.commons.TravelPlanObject;


/**
 * Represents an Accommodation in the travel plan.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Accommodation extends TravelPlanObject {

    private final Name name;
    private final Date startDate;
    private final Date endDate;
    private final Cost cost;
    private final Location location;

    /**
     * Every field must be present and not null.
     */
    public Accommodation(Name name, Date startDate, Date endDate, Cost cost, Location location) {
        requireAllNonNull(name, startDate, endDate, cost, location);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
        this.location = location;
    }

    public Name getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Cost getCost() {
        return cost;
    }

    public Location getLocation() {
        return location;
    }

    /** Returns true if both accommodations have the same name, startDate and endDate fields. */
    public boolean isSameAccommodation(Accommodation otherAccommodation) {
        if (otherAccommodation == this) {
            return true;
        }

        return otherAccommodation != null
                && otherAccommodation.getName().equals(getName())
                && otherAccommodation.getStartDate().equals(getStartDate())
                && otherAccommodation.getEndDate().equals(getEndDate());
    }


    /**
     * Returns true if both accommodations have identical fields.
     * This defines a stronger notion of equality between two accommodations.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Accommodation)) {
            return false;
        }

        Accommodation otherAccommodation = (Accommodation) other;
        return otherAccommodation.getName().equals(getName())
                && otherAccommodation.getStartDate().equals(getStartDate())
                && otherAccommodation.getEndDate().equals(getEndDate())
                && otherAccommodation.getCost().equals(getCost())
                && otherAccommodation.getLocation().equals(getLocation());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, startDate, endDate, cost, location);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Date: ")
                .append(getStartDate())
                .append(" - ")
                .append(getEndDate())
                .append(" Address: ")
                .append(getLocation())
                .append(" Cost: ")
                .append(getCost());
        return builder.toString();
    }

}
