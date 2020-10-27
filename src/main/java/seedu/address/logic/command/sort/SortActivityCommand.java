package seedu.address.logic.command.sort;

import static java.util.Objects.requireNonNull;

import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.logic.command.CommandResult;
import seedu.address.logic.command.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.activity.Activity;
import seedu.address.model.activity.UniqueActivityList;
import seedu.address.model.travelplan.ActivityList;
import seedu.address.model.travelplan.TravelPlan;
import seedu.address.model.wishlist.Wishlist;

public class SortActivityCommand extends SortCommand {
    public static final String COMMAND_WORD = "sort activity";

    public static final String MESSAGE_USAGE =
            "sort activity: Sorts the list of activities in a travel plan/wishlist by the keyword input by the user.\n"
                    + "Parameters: KEYWORD (COST/IMPORTANCE/DATE)\n";

    public static final String MESSAGE_SORT_ACTIVITY_SUCCESS = "Sorted list of activities by: %1$s";

    public static final String MESSAGE_INVALID_KEYWORD = "INVALID KEYWORD! "
            + "Activity list can only sort by cost, importance or date.";
    private final String keyword;

    /**
     * Constructor for SortActivityCommand.
     * @param keyword identifier to sort activity list.
     */
    public SortActivityCommand(String keyword) {
        super(keyword);
        this.keyword = keyword;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        boolean isTravelPlan = model.isDirectoryTypeTravelPlan();
        if (isTravelPlan) {
            switch (keyword) {

            case SortCommand.KEYWORD_COST:
                Comparator<Activity> costComparator = Comparator.comparingInt(Activity::getCostAsInt);
                model.sortActivityList(costComparator);
                return new CommandResult(String.format(MESSAGE_SORT_ACTIVITY_SUCCESS, SortCommand.KEYWORD_COST));

            case SortCommand.KEYWORD_IMPORTANCE:
                Comparator<Activity> importanceComparator = Comparator.comparingInt(Activity::getImportanceAsInt);
                model.sortActivityList(importanceComparator);
                return new CommandResult(String.format(MESSAGE_SORT_ACTIVITY_SUCCESS, SortCommand.KEYWORD_IMPORTANCE));

            case SortCommand.KEYWORD_DATE:
                Comparator<Activity> dateComparator = Comparator.comparing(d -> d.getActivityDateTime().getValue());
                model.sortActivityList(dateComparator);
                return new CommandResult(String.format(MESSAGE_SORT_ACTIVITY_SUCCESS, SortCommand.KEYWORD_DATETIME));

            default:
                throw new CommandException(MESSAGE_INVALID_KEYWORD);
            }
        } else {
            Wishlist wishlist = (Wishlist) model.getDirectory();
            UniqueActivityList uniqueActivityList = wishlist.getUniqueActivityList();
            ObservableList<Activity> internalList = uniqueActivityList.getInternalList();
            switch (keyword) {

            case SortCommand.KEYWORD_COST:
                Comparator<Activity> costComparator = Comparator.comparingInt(Activity::getCostAsInt);
                FXCollections.sort(internalList, costComparator);
                FXCollections.sort(model.getObservableDirectory().getObservableActivityList(), costComparator);
                return new CommandResult(String.format(MESSAGE_SORT_ACTIVITY_SUCCESS, SortCommand.KEYWORD_COST));

            case SortCommand.KEYWORD_IMPORTANCE:
                Comparator<Activity> importanceComparator = Comparator.comparingInt(Activity::getImportanceAsInt);
                FXCollections.sort(internalList, importanceComparator);
                FXCollections.sort(model.getObservableDirectory().getObservableActivityList(), importanceComparator);
                return new CommandResult(String.format(MESSAGE_SORT_ACTIVITY_SUCCESS, SortCommand.KEYWORD_IMPORTANCE));

            case SortCommand.KEYWORD_DATE:
                Comparator<Activity> dateComparator = Comparator.comparing(d -> d.getActivityDateTime().getValue());
                FXCollections.sort(internalList, dateComparator);
                FXCollections.sort(model.getObservableDirectory().getObservableActivityList(), dateComparator);
                return new CommandResult(String.format(MESSAGE_SORT_ACTIVITY_SUCCESS, SortCommand.KEYWORD_DATETIME));

            default:
                throw new CommandException(MESSAGE_INVALID_KEYWORD);
            }
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SortActivityCommand // instanceof handles nulls
                && keyword.equals(((SortActivityCommand) other).keyword)); // state check
    }
}
