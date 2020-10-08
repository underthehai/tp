package seedu.address.logic.wanderlustlogic.wanderlustcommands.edit;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.model.activity.Importance;
import seedu.address.model.activity.WanderlustDateTime;
import seedu.address.model.commons.Cost;
import seedu.address.model.commons.Location;
import seedu.address.model.commons.Name;
import seedu.address.model.commons.WanderlustDate;
import seedu.address.model.friend.Passport;
import seedu.address.model.friend.Phone;

import java.util.Optional;

/**
 * Class to build description
 */
public class EditDescriptor {

    //all possible fields
    private Name name;
    private Location location;
    private Cost cost;
    private WanderlustDate startDate;
    private WanderlustDate endDate;
    private Passport passport;
    private Phone phone;
    private Importance levelOfImportance;
    private WanderlustDateTime activityDateTime;

    public EditDescriptor(){

    }

    /**
     * Copy constructor
     * @param toCopy contain field to copy over
     */
    public EditDescriptor(EditDescriptor toCopy){

    }

    /**
     * Returns true if at least one field is edited.
     */
    public boolean isAnyFieldEdited() {
        return CollectionUtil.isAnyNonNull(name, location, cost, levelOfImportance, activityDateTime);
    }


    public void setName(Name name) {
        this.name = name;
    }

    public Optional<Name> getName() {
        return Optional.ofNullable(name);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Optional<Location> getLocation() {
        return Optional.ofNullable(location);
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public Optional<Cost> getCost() {
        return Optional.ofNullable(cost);
    }

    public void setLevelOfImportance(Importance importance) {
        this.levelOfImportance = levelOfImportance;
    }

    public Optional<Importance> getLevelOfImportance() {
        return Optional.ofNullable(levelOfImportance);
    }

    public void setActivityDateTime(WanderlustDateTime activityDateTime) {
        this.activityDateTime = activityDateTime;
    }
    public Optional<WanderlustDateTime> getActivityDateTime() {
        return Optional.ofNullable(activityDateTime);
    }

    public void setStartDate(WanderlustDate startDate) {
        this.startDate = startDate;
    }

    public Optional<WanderlustDate> getStartDate() {
        return Optional.ofNullable(startDate);
    }

    public void setEndDate(WanderlustDate endDate) {
        this.endDate = endDate;
    }

    public Optional<WanderlustDate> getEndDate() {
        return Optional.ofNullable(endDate);
    }
    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Optional<Passport> getPassport() {
        return Optional.ofNullable(passport);
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Optional<Phone> getPhone() {
        return Optional.ofNullable(phone);
    }


}
