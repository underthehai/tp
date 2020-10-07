package seedu.address.logic.commands.edit;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COST;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.accommodation.Accommodation;
import seedu.address.model.commons.Name;
import seedu.address.model.commons.Cost;
import seedu.address.model.commons.Location;
import seedu.address.model.commons.WanderlustDate;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.Model;

/**
 * Edits existing Accommodation in the address book. This command can only be used within a travel plan.
 * n sd en l c
 */
public class EditAccommodationCommand extends EditCommand {
    public static final String COMMAND_WORD = "accommodation";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the accommodation identified by the index number used in the displayed accommodation list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_START_DATE + "STARTDATE] "
            + "[" + PREFIX_END_DATE + "ENDDATE] "
            + "[" + PREFIX_LOCATION + "LOCATION] "
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_NAME + "Hard Rock Hotel"
            + PREFIX_START_DATE +" jan 20 2020 "
            + PREFIX_END_DATE +" jan 30 2020"
            + PREFIX_LOCATION + "Sentosa"
            + PREFIX_COST + "SGD500";


    public static final String MESSAGE_EDIT_Accommodation_SUCCESS = "Edited Accommodation: %1$s";
    public static final String MESSAGE_DUPLICATE_Accommodation = "This accommodation already exists in the travelplan.";

    private final Index targetIndex;
    private final EditAccommodationDescriptor editAccommodationDescriptor;

    public EditAccommodationCommand(Index targetIndex, EditAccommodationDescriptor editAccommodationDescriptor) {
        super(targetIndex);
        this.targetIndex = targetIndex;
        this.editAccommodationDescriptor = editAccommodationDescriptor;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Accommodation> lastShownList = model.getFilteredAccommodationList();

        //Directory class in model (TBD)
        Directory currentDir = model.getDirectory();
        TravelPlan travelPlan = null;

        if (currentDir.isTravelPlan()) {
            travelPlan = (TravelPlan) currentDir;
        }

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ACCOMMODATION_DISPLAYED_INDEX);
        }

        Accommodation accommodationToEdit = lastShownList.get(targetIndex.getZeroBased());
        Accommodation editedAccommodation = createEditedAccommodation(accommodationToEdit, editAccommodationDescriptor);

        if (!accommodationToEdit.isSameAccommodation(editedAccommodation) && travelPlan.hasTravelPlanObject(editedAccommodation)) {
            throw new CommandException(MESSAGE_DUPLICATE_Accommodation);
        }

        model.setAccommodation(accommodationToEdit, editedAccommodation, travelPlan);
        return new CommandResult(String.format(MESSAGE_EDIT_Accommodation_SUCCESS, editedAccommodation));
    }

    /**
     * Creates and returns a {@code Accommodation} with the details of {@code accommodationToEdit}
     * edited with {@code editAccommodationDescriptor}.
     * Edits the name location cost sd ed
     */
    private static Accommodation createEditedAccommodation(Accommodation accommodationToEdit, EditAccommodationDescriptor editAccommodationDescriptor) {
        assert accommodationToEdit != null;

        Name updatedName;
        Location location;
        Cost cost;
        WanderlustDate startDate;
        WanderlustDate endDate;


        return null;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EditCommand // instanceof handles nulls
                && targetIndex.equals(((EditAccommodationCommand) other).targetIndex)); // state check
    }

    /**
     * Stores the details to edit the accommodation with. Each non-empty field value will replace the
     * corresponding field value of the accommodation.
     */
    public static class EditAccommodationDescriptor {

        private Name name;
        private Location location;
        private Cost cost;
        private WanderlustDate startDate;
        private WanderlustDate endDate;


        public EditAccommodationDescriptor() {
        }

        /**
         * Copy constructor.
         */
        public EditAccommodationDescriptor(EditAccommodationDescriptor toCopy) {
            setName(toCopy.name);
            setLocation(toCopy.location);
            setCost(toCopy.cost);
            setStartDate(toCopy.startDate);
            setEndDate(toCopy.endDate);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, location, cost, startDate, endDate);
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


        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditAccommodationDescriptor)) {
                return false;
            }

            // state check
            EditAccommodationDescriptor e = (EditAccommodationDescriptor) other;

            return getName().equals(e.getName())
                    && getCost().equals(e.getCost())
                    && getLocation().equals((e.getCost()))
                    && getStartDate().equals(e.getStartDate())
                    && getEndDate().equals(e.getEndDate());
        }
    }

}
