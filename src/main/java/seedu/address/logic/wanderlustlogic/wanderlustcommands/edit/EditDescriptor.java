package seedu.address.logic.wanderlustlogic.wanderlustcommands.edit;

import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_COST;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_DATETIME;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_END;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_IMPORTANCE;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_PASSPORT;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.PREFIX_START;

import java.util.Optional;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.wanderlustlogic.wanderlustparser.ArgumentMultimap;
import seedu.address.logic.wanderlustlogic.wanderlustparser.ParserUtil;
import seedu.address.logic.wanderlustlogic.wanderlustparser.exceptions.ParseException;
import seedu.address.model.activity.Importance;
import seedu.address.model.activity.WanderlustDateTime;
import seedu.address.model.commons.Cost;
import seedu.address.model.commons.Location;
import seedu.address.model.commons.Name;
import seedu.address.model.commons.WanderlustDate;
import seedu.address.model.friend.Passport;
import seedu.address.model.friend.Phone;

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

    public EditDescriptor() {

    }

    /**
     * Copy constructor
     *
     * @param toCopy contain field to copy over
     */
    public EditDescriptor(EditDescriptor toCopy) {

    }

    /**
     * Returns true if at least one field is edited.
     */
    public boolean isAnyFieldEdited() {
        return CollectionUtil.isAnyNonNull(name, location, cost, levelOfImportance, activityDateTime,
                phone, passport, startDate, endDate);
    }

    /**
     * Provides editdescriptor for edit commands
     *
     * @param source of tokenized fields
     * @return editdescriptor
     */
    public static EditDescriptor buildFromSource(ArgumentMultimap source) throws ParseException {

        EditDescriptor editItemnDescriptor = new EditDescriptor();

        if (source.getValue(PREFIX_NAME).isPresent()) {
            editItemnDescriptor.setName(ParserUtil.parseName(source.getValue(PREFIX_NAME).get()));
        }

        if (source.getValue(PREFIX_LOCATION).isPresent()) {
            editItemnDescriptor.setLocation(ParserUtil.parseLocation(source.getValue(PREFIX_LOCATION).get()));
        }
        if (source.getValue(PREFIX_COST).isPresent()) {
            editItemnDescriptor.setCost(ParserUtil.parseCost(source.getValue(PREFIX_COST).get()));
        }
        if (source.getValue(PREFIX_START).isPresent()) {
            editItemnDescriptor.setStartDate(ParserUtil.parseStartDate(source.getValue(PREFIX_START).get()));
        }
        if (source.getValue(PREFIX_END).isPresent()) {
            editItemnDescriptor.setEndDate(ParserUtil.parseEndDate(source.getValue(PREFIX_END).get()));
        }
        if (source.getValue(PREFIX_PASSPORT).isPresent()) {
            editItemnDescriptor.setPassport(ParserUtil.parsePassport(source.getValue(PREFIX_PASSPORT).get()));
        }
        if (source.getValue(PREFIX_PHONE).isPresent()) {
            editItemnDescriptor.setPhone(ParserUtil.parsePhone(source.getValue(PREFIX_PHONE).get()));
        }
        if (source.getValue(PREFIX_IMPORTANCE).isPresent()) {
            editItemnDescriptor.setLevelOfImportance(ParserUtil.parseLevelOfImportance(source
                    .getValue(PREFIX_IMPORTANCE).get()));
        }
        if (source.getValue(PREFIX_DATETIME).isPresent()) {
            editItemnDescriptor.setActivityDateTime(ParserUtil.parseActivityDateTime(source.getValue(PREFIX_DATETIME)
                    .get()));
        }

        return editItemnDescriptor;

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
        this.levelOfImportance = importance;
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
