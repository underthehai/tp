package seedu.address.model.accommodation;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Date;
import java.util.Objects;

import seedu.address.model.person.Address;
import seedu.address.model.person.Name;

/**
 * Represents an Accommodation in the travel plan.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Accommodation {

    private final Name name;
    private final Date startDate;
    private final Date endDate;
    private final Cost cost;
    private final Address address;

    /**
     * Every field must be present and not null.
     */
    public Accommodation(Name name, Date startDate, Date endDate, Cost cost, Address address) {
        requireAllNonNull(name, startDate, endDate, cost, address);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
        this.address = address;
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

    public Address getAddress() {
        return address;
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
                && otherAccommodation.getAddress().equals(getAddress());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, startDate, endDate, cost, address);
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
                .append(getAddress())
                .append(" Cost: ")
                .append(getCost());
        return builder.toString();
    }

}
