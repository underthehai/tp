package seedu.address.logic.commands.edit;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.commons.Name;
import seedu.address.model.commons.WanderlustDate;
import seedu.address.model.travelplan.AccommodationList;
import seedu.address.model.travelplan.ActivityList;
import seedu.address.model.travelplan.FriendList;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.travelplanner.Model;


/**
 * Edit name start date or end date of travelplan
 */
public class EditTravelPlanCommand extends EditCommand {
    public static final String COMMAND_WORD = "travelplan";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the travel plan identified by the index number used in the displayed travel planner list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_START_DATE + "STARTDATE] "
            + "[" + PREFIX_END_DATE + "ENDDATE] "
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_NAME + " Trip to Japan "
            + PREFIX_START_DATE + " jan 20 2020 "
            + PREFIX_END_DATE + " jan 30 2020";

    public static final String MESSAGE_EDIT_TRAVELPLAN_SUCCESS = "Edited Travel Plan: %1$s";
    public static final String MESSAGE_DUPLICATE_TRAVELPLAN = "This travelplan already exists in Wanderlust.";

    private final Index targetIndex;
    private final EditTravelPlanDescriptor editTravelPlanDescriptor;

    /**
     * Constructor for edit travel plan
     */
    public EditTravelPlanCommand(Index targetIndex, EditTravelPlanDescriptor editTravelPlanDescriptor) {
        super(targetIndex);
        this.targetIndex = targetIndex;
        this.editTravelPlanDescriptor = editTravelPlanDescriptor;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<TravelPlan> lastShownList = model.getFilteredTravelPlanList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TRAVELPLAN_DISPLAYED_INDEX);
        }


        //modify travelplan
        TravelPlan travelPlanToEdit = lastShownList.get(targetIndex.getZeroBased());
        TravelPlan editedTravelPlan = createEditedTravelPlan(travelPlanToEdit, editTravelPlanDescriptor);

        //check for duplicated travel plan
        if (!travelPlanToEdit.isSameTravelPlan(editedTravelPlan) && model.hasTravelPlan(editedTravelPlan)) {
            throw new CommandException(MESSAGE_DUPLICATE_TRAVELPLAN);
        }

        //update travelplan
        model.setTravelPlan(travelPlanToEdit, editedTravelPlan);
        return new CommandResult(String.format(MESSAGE_EDIT_TRAVELPLAN_SUCCESS, editedTravelPlan));
    }

    /**
     * Creates and returns a {@code TravelPlan} with the details of {@code travelPlanToEdit}
     * edited with {@code editTravelPlanDescriptor}.
     */
    private static TravelPlan createEditedTravelPlan(TravelPlan travelPlanToEdit,
                                                     EditTravelPlanDescriptor editTravelPlanDescriptor) {
        assert travelPlanToEdit != null;

        Name updatedName = editTravelPlanDescriptor.getName().orElse(travelPlanToEdit.getName());
        WanderlustDate updatedStartDate = editTravelPlanDescriptor.getStartDate()
                .orElse(travelPlanToEdit.getStartDate());
        WanderlustDate updatedEndDate = editTravelPlanDescriptor.getEndDate().orElse(travelPlanToEdit.getEndDate());

        //obtain data list from original travelplan
        ActivityList activities = (ActivityList) travelPlanToEdit.getActivityList();
        AccommodationList accommodations = (AccommodationList) travelPlanToEdit.getAccommodationList();
        FriendList friends = (FriendList) travelPlanToEdit.getFriendList();

        return new TravelPlan(updatedName, updatedStartDate, updatedEndDate, activities, accommodations, friends);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EditCommand // instanceof handles nulls
                && targetIndex.equals(((EditTravelPlanCommand) other).targetIndex)); // state check
    }


    /**
     * Stores the details to edit the travelplan with. Each non-empty field value will replace the
     * corresponding field value of the travelplan.
     */
    public static class EditTravelPlanDescriptor {
        private Name name;
        private WanderlustDate startDate;
        private WanderlustDate endDate;

        public EditTravelPlanDescriptor() {
        }

        /**
         * Copy constructor.
         */
        public EditTravelPlanDescriptor(EditTravelPlanDescriptor toCopy) {
            setName(toCopy.name);
            setStartDate(toCopy.startDate);
            setEndDate(toCopy.endDate);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, startDate, endDate);
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
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
            if (!(other instanceof EditTravelPlanDescriptor)) {
                return false;
            }

            // state check
            EditTravelPlanDescriptor e = (EditTravelPlanDescriptor) other;

            return getName().equals(e.getName())
                    && getStartDate().equals(e.getStartDate())
                    && getEndDate().equals(e.getEndDate());
        }
    }
}
