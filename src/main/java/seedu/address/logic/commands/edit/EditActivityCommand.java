package seedu.address.logic.commands.edit;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_IMPORTANCE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COST;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.activity.Importance;
import seedu.address.model.activity.WanderlustDateTime;
import seedu.address.model.commons.Name;
import seedu.address.model.commons.Cost;
import seedu.address.model.commons.Location;
import seedu.address.model.commons.WanderlustDate;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.Directory;
import seedu.address.model.travelplanner.Model;
import seedu.address.model.activity.Activity;

/**
 * Edits an existing Activity in the address book and updates the travel plan/wishlist in the current directory
 * Edits the importance, cost, location, startdate, enddate
 */
public class EditActivityCommand extends EditCommand {
    public static final String COMMAND_WORD = "activity";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the travel plan identified by the index number used in the displayed travel planner list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_IMPORTANCE + "IMPORTANCE] "
            + "[" + PREFIX_LOCATION + "LOCATION] "
            + "[" + PREFIX_COST + "COST] "
            + "[" + PREFIX_START_DATE + "START_DATE] "
            + "[" + PREFIX_END_DATE + "END_DATE] "
            + "Example: " + COMMAND_WORD + " 1 "
            + "n/Hard Rock Hotel"
            + "i/2"
            + "l/Sentosa"
            + "c/SGD500"
            + "sd/20 September 2020"
            + "ed/30 September 2020";

    public static final String MESSAGE_EDIT_ACTIVITY_SUCCESS = "Edited Activity: %1$s";
    public static final String MESSAGE_DUPLICATE_ACTIVITY = "This activity already exists in Wanderlust.";

    private final Index targetIndex;
    private final EditActivityDescriptor editActivityDescriptor;

    public EditActivityCommand(Index targetIndex, EditActivityDescriptor editActivityDescriptor) {
        super(targetIndex);
        this.targetIndex = targetIndex;
        this.editActivityDescriptor = editActivityDescriptor;
    }


    //handling the travelplan activity
    //TODO wishlist activity
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        //Directory class in model (TBD)
        Directory currentDir = model.getDirectory();
        TravelPlan travelPlan = null;

        if (currentDir.isTravelPlan()) {
            travelPlan = (TravelPlan) currentDir;
        }

        List<Activity> lastShownList = travelPlan.getActivityList();
        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ACTIVITY_DISPLAYED_INDEX);
        }

        Activity activityToEdit = lastShownList.get(targetIndex.getZeroBased());
        Activity editedActivity = createEditedActivity(activityToEdit, editActivityDescriptor);

        if (!activityToEdit.isSameActivity(editedActivity) && model.hasActivity(editedActivity)) {
            throw new CommandException(MESSAGE_DUPLICATE_ACTIVITY);
        }

        model.setTravelPlanObject(activityToEdit, editedActivity);
        return new CommandResult(String.format(MESSAGE_EDIT_ACTIVITY_SUCCESS, editedActivity));
    }

    /**
     * Creates and returns a {@code Activity} with the details of {@code activityToEdit}
     * edited with {@code editActivityDescriptor}.
     * Edits the importance, cost, location, startime, end time
     */
    private static Activity createEditedActivity(Activity activityToEdit, EditActivityDescriptor editActivityDescriptor) {
        assert activityToEdit != null;

        Name updatedName = editActivityDescriptor.getName().orElse(activityToEdit.getName());

        Location updatedlocation = editActivityDescriptor.getLocation().orElse(activityToEdit.getLocation());
        Cost updatedCost = editActivityDescriptor.getCost().orElse(activityToEdit.getCost());
        Importance updatedLevelOfImportance = editActivityDescriptor.getLevelOfImportance().orElse(activityToEdit.getLevelOfImportance());
        WanderlustDateTime updatedActivityDateTime = editActivityDescriptor.getActivityDateTime().orElse(activityToEdit.getActivityDateTime());

        return new Activity(updatedName, updatedlocation, updatedCost, updatedLevelOfImportance, updatedActivityDateTime);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EditCommand // instanceof handles nulls
                && targetIndex.equals(((EditActivityCommand) other).targetIndex)); // state check
    }

    /**
     * Stores the details to edit the activity with. Each non-empty field value will replace the
     * corresponding field value of the activity.
     */
    public static class EditActivityDescriptor {

        private Name name;
        private Location location;
        private Cost cost;
        private Importance levelOfImportance;
        private WanderlustDateTime activityDateTime;


        public EditActivityDescriptor() {
        }

        /**
         * Copy constructor.
         */
        public EditActivityDescriptor(EditActivityDescriptor toCopy) {
            setName(toCopy.name);
            setLocation(toCopy.location);
            setCost(toCopy.cost);
            setLevelOfImportance(toCopy.levelOfImportance);
            setActivityDateTime(toCopy.activityDateTime);
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


        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditActivityDescriptor)) {
                return false;
            }

            // state check
            EditActivityDescriptor e = (EditActivityDescriptor) other;

            return getName().equals(e.getName())
                    && getCost().equals(e.getCost())
                    && getLocation().equals((e.getCost()))
                    && getLevelOfImportance().equals(e.getLevelOfImportance())
                    && getActivityDateTime().equals((e.activityDateTime));
        }
    }

}
