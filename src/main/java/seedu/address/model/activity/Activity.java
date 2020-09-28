package seedu.address.model.activity;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.model.tag.Tag;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Activity {

    //Identity fields
    private final Name name;

    //Data fields
    private final Location location;
    private final Cost cost;
    private final Importance levelOfImportance;
    private final Date date;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Activity(Name name, Location location, Cost cost, Importance levelOfImportance, Date date) {
        requireAllNonNull(name, location, cost, levelOfImportance, date);
        this.name = name;
        this.location = location;
        this.cost = cost;
        this.levelOfImportance = levelOfImportance;
        this.date = date;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public Cost getCost() {
        return cost;
    }

    public Importance getLevelOfImportance() {
        return levelOfImportance;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both activities are of the same name.
     * This defines a weaker notion of equality between two activities.
     */
    public boolean isSameActivity(Activity otherActivity) {
        if (otherActivity == this) {
            return true;
        }

        return otherActivity != null
                && otherActivity.getName().equals(getName());
    }

    /**
     * Returns true if both activites have the same identity and data fields.
     * This defines a stronger notion of equality between two activities.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Activity)) {
            return false;
        }

        Activity otherActivity = (Activity) other;
        return otherActivity.getName().equals(getName())
                && otherActivity.getLocation().equals(getLocation())
                && otherActivity.getCost().equals(getCost())
                && otherActivity.getLevelOfImportance().equals(getLevelOfImportance())
                && otherActivity.getDate().equals(getDate())
                && otherActivity.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, location, cost, levelOfImportance, date, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Name: ")
                .append(getLocation())
                .append(" Location: ")
                .append(getLevelOfImportance())
                .append(" Importance Level: ")
                .append(getCost())
                .append(" Cost: ")
                .append(getDate())
                .append(" Date: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
