package seedu.address.model.friend;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents a Friend in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Friend {

    // Identity fields
    private final seedu.address.model.friend.Name name;
    private final seedu.address.model.friend.Passport passport;
    private final seedu.address.model.friend.Phone phone;


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
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSameFriend(Friend otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName())
                && (otherPerson.getPhone().equals(getPhone()) || otherPerson.getPassport().equals(getPassport()));
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

        Friend otherPerson = (Friend) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getPassport().equals(getPassport())
                && otherPerson.getPhone().equals(getPhone());
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
