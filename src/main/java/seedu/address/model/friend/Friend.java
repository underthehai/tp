package seedu.address.model.friend;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.commons.Name;

/**
 * Represents a Friend in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Friend {

    // Identity fields
    private final Name name;

    // Data fields
    private final Passport passport;
    private final Phone phone;


    /**
     * Every field must be present and not null.
     */
    public Friend(Name name, Passport passport, Phone phone) {
        requireAllNonNull(name, passport, phone);
        this.name = name;
        this.passport = passport;
        this.phone = phone;
    }

    public Name getName() {
        return name;
    }

    public Passport getPassport() {
        return passport;
    }

    public Phone getPhone() {
        return phone;
    }

    /**
     * Returns true if both friends are of the same name
     */
    public boolean isSameFriend(Friend otherFriend) {
        if (otherFriend == this) {
            return true;
        }

        return otherFriend != null
                && otherFriend.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Friend)) {
            return false;
        }

        Friend otherFriend = (Friend) other;
        return otherFriend.getName().equals(getName())
                && otherFriend.getPassport().equals(getPassport())
                && otherFriend.getPhone().equals(getPhone());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, passport, phone);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Passport number: ")
                .append(getPassport())
                .append(" Mobile phone: ")
                .append(getPhone());

        return builder.toString();
    }


}
